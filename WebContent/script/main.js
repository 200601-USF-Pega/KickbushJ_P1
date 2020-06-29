window.onload = onLoad;

document.getElementById("signinButton").addEventListener("click", attemptSignin);

document.querySelector("#toHome").addEventListener("click", function() {
	location.reload();
});


function onLoad() {

	let empId = sessionStorage.empId;

	if (empId == undefined) {

		console.log("not logged in");

	} else if (empId == 1) {

		console.log("Manager logged in");

		document.querySelectorAll("#body nav div ul .nav-item a").forEach(function(e) {
			e.className = "nav-link";
		});

		makeLogoutButton();

		getContent("rss/managerhome.html");

		document.querySelector("#toNN").addEventListener("click", manNaughtyNice);
		document.querySelector("#toToy").addEventListener("click", manToy);
		document.querySelector("#toWorker").addEventListener("click", manWorker);

	} else if (empId > 1) {

		console.log("Employee logged in");

		document.querySelectorAll("#body nav div ul .nav-item a").forEach(function(e) {
			e.className = "nav-link";
		});

		document.querySelector("#workers a").className = "nav-link disabled";

		makeLogoutButton();

		getContent("rss/employeehome.html");

		document.querySelector("#toNN").addEventListener("click", empNaughtyNice);
		document.querySelector("#toToy").addEventListener("click", empToy);


	}

}

function empNaughtyNice() {

	getContent("rss/employeenn.html");
	showNaughtyNice();

}

function manNaughtyNice() {

	getContent("rss/managernn.html");
	showNaughtyNice();
}

function empToy() {

	getContent("rss/employeetoy.html");
	showToyProduction();
	showToyHistory();
}

function manToy() {

	getContent("rss/managertoy.html");
	showToyProduction();
	showToyHistoryMan();
	showDeliveredScrapped();
}

function manWorker() {

	getContent("rss/managerworker.html");
	viewWorkers();
}

var workers = [];

function viewWorkers() {

	console.log("showing Elven Workers");
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelectorAll("#viewTable tbody tr").forEach(function(e) {
				e.remove()
			});

			workers = JSON.parse(this.responseText);
			let table = document.querySelector("#viewTable tbody");

			for (let i = 0; i < workers.length; ++i) {
				let row = table.insertRow(table.rows.length);

				let elvenID = row.insertCell(0);
				elvenID.innerHTML = workers[i].elvenID;

				let elvenName = row.insertCell(1);
				elvenName.innerHTML = workers[i].elvenName;

				let elvenAge = row.insertCell(2);
				elvenAge.innerHTML = workers[i].elvenAge;

				let positionName = row.insertCell(3);
				positionName.innerHTML = workers[i].positionName;

				let shiftNumber = row.insertCell(4);
				shiftNumber.innerHTML = workers[i].shiftNumber;

				let numProducedToys = row.insertCell(5);
				numProducedToys.innerHTML = workers[i].numProducedToys;

			}
		}
	};
	req.open("GET", "http://localhost:8080/santasWorkshop2/workshop/elvenservice/viewworkers", true);
	req.send();

}

function addWorker() {

	let worker = {};

	worker.elvenName = ((document.querySelector("#elvenName") || {}).value) || "";
	worker.elvenAge = ((document.querySelector("#elvenAge") || {}).value) || "0";
	worker.positionName = ((document.querySelector("#positionName") || {}).value) || "";
	worker.shiftNumber = ((document.querySelector("#shiftNumber") || {}).value) || "0";
	worker.numProducedToys = ((document.querySelector("#numProducedToys") || {}).value) || "0";


	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelector("#elvenName").value = "";
			document.querySelector("#elvenAge").value = "";
			document.querySelector("#positionName").value = "";
			document.querySelector("#shiftNumber").value = "";
			document.querySelector("#numProducedToys").value = "";
			document.querySelector("#addWorkerResult").innerHTML = "Worker added.";
		} else {
			document.querySelector("#addWorkerResult").innerHTML = "Worker could not be added.";
		}
	}

	req.open("POST", "http://localhost:8080/santasWorkshop2/workshop/elvenservice/addworker", true);
	req.setRequestHeader('Content-Type', 'application/json');
	req.send(JSON.stringify(worker));

}

function removeWorker() {

	let elvenID = ((document.querySelector("#elvenID") || {}).value) || "0";

	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelector("#elvenID").value = "";
			document.querySelector("#removeWorkerResult").innerHTML = "Worker ID: " + elvenID + " removed from List of Workers.";
		} else {
			document.querySelector("#removeWorkerResult").innerHTML = "Worker could not be removed.";
		}
	}

	req.open("DELETE", "http://localhost:8080/santasWorkshop2/workshop/elvenservice/deleteworker/" + elvenID, true);
	req.send();

}



function showDeliveredScrapped() {

	console.log("showing Delivered vs Scrapped");
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {

			toys = JSON.parse(this.responseText);

			document.querySelector("#insertDelivered").innerHTML = toys[0];
			document.querySelector("#insertScrapped").innerHTML = toys[1];
		}
	};
	req.open("GET", "http://localhost:8080/santasWorkshop2/workshop/toyservice/totaldeliv", true);
	req.send();
}

var toys = [];

function showToyProduction() {
	console.log("showing Toy Production");
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelectorAll("#productionTable tbody tr").forEach(function(e) {
				e.remove()
			});

			toys = JSON.parse(this.responseText);
			let table = document.querySelector("#productionTable tbody");

			for (let i = 0; i < toys.length; ++i) {
				let row = table.insertRow(table.rows.length);

				let toyID = row.insertCell(0);
				toyID.innerHTML = toys[i].toyID;

				let toyName = row.insertCell(1);
				toyName.innerHTML = toys[i].toyName;

				let toyColor = row.insertCell(2);
				toyColor.innerHTML = toys[i].toyColor;

				let workTime = row.insertCell(3);
				workTime.innerHTML = toys[i].workTime.toFixed(2);

				let childName = row.insertCell(4);
				childName.innerHTML = toys[i].childName;

				let naughty = row.insertCell(5);
				naughty.innerHTML = toys[i].naughty;

				let elvenName = row.insertCell(6);
				elvenName.innerHTML = toys[i].elvenName;

				let positionName = row.insertCell(7);
				positionName.innerHTML = toys[i].positionName;

				let shiftNumber = row.insertCell(8);
				shiftNumber.innerHTML = toys[i].shiftNumber;

				let numProducedToys = row.insertCell(9);
				numProducedToys.innerHTML = toys[i].numProducedToys;

			}
		}
	};
	req.open("GET", "http://localhost:8080/santasWorkshop2/workshop/toyservice/fullprod", true);
	req.send();


}


function showToyHistory() {
	console.log("showing Toy History");
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelectorAll("#historyTable tbody tr").forEach(function(e) {
				e.remove()
			});

			toys = JSON.parse(this.responseText);
			let table = document.querySelector("#historyTable tbody");

			for (let i = 0; i < toys.length; ++i) {
				let row = table.insertRow(table.rows.length);

				let toyID = row.insertCell(0);
				toyID.innerHTML = toys[i].toyID;

				let toyName = row.insertCell(1);
				toyName.innerHTML = toys[i].toyName;

				let toyColor = row.insertCell(2);
				toyColor.innerHTML = toys[i].toyColor;

				let workTime = row.insertCell(3);
				workTime.innerHTML = toys[i].workTime.toFixed(2);

				let childID = row.insertCell(4);
				childID.innerHTML = toys[i].childID;

				let yearProduced = row.insertCell(5);
				yearProduced.innerHTML = toys[i].yearProduced;

				let delivered = row.insertCell(6);
				delivered.innerHTML = toys[i].delivered;

			}
		}
	};

	let selection = ((document.querySelector("#searchHistoryBy") || {}).value) || "none";

	if (selection == "year") {

		let selectionValue = document.querySelector("#selectionValue").value;
		if (selectionValue.length == 0) {
			selectionValue = 0;
		}
		req.open("GET", "http://localhost:8080/santasWorkshop2/workshop/toyservice/yearhist/" + selectionValue, true);

	} else if (selection == "child") {

		let selectionValue = document.querySelector("#selectionValue").value;
		if (selectionValue.length == 0) {
			selectionValue = 0;
		}
		req.open("GET", "http://localhost:8080/santasWorkshop2/workshop/toyservice/childtoy/" + selectionValue, true);

	} else if (selection == "worker") {

		req.open("GET", "http://localhost:8080/santasWorkshop2/workshop/toyservice/workertoy/" + sessionStorage.empId, true);


	} else {
		req.open("GET", "http://localhost:8080/santasWorkshop2/workshop/toyservice/fullhist", true);
	}

	req.send();


}

function showToyHistoryMan() {
	console.log("showing Toy History");
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelectorAll("#historyTable tbody tr").forEach(function(e) {
				e.remove()
			});

			toys = JSON.parse(this.responseText);
			let table = document.querySelector("#historyTable tbody");

			for (let i = 0; i < toys.length; ++i) {
				let row = table.insertRow(table.rows.length);

				let toyID = row.insertCell(0);
				toyID.innerHTML = toys[i].toyID;

				let toyName = row.insertCell(1);
				toyName.innerHTML = toys[i].toyName;

				let toyColor = row.insertCell(2);
				toyColor.innerHTML = toys[i].toyColor;

				let workTime = row.insertCell(3);
				workTime.innerHTML = toys[i].workTime.toFixed(2);

				let childID = row.insertCell(4);
				childID.innerHTML = toys[i].childID;

				let elvenID = row.insertCell(5);
				elvenID.innerHTML = toys[i].elvenID;

				let yearProduced = row.insertCell(6);
				yearProduced.innerHTML = toys[i].yearProduced;

				let delivered = row.insertCell(7);
				delivered.innerHTML = toys[i].delivered;

			}
		}
	};

	let selection = ((document.querySelector("#searchHistoryBy") || {}).value) || "none";

	if (selection == "year") {

		let selectionValue = document.querySelector("#selectionValue").value;
		if (selectionValue.length == 0) {
			selectionValue = 0;
		}
		req.open("GET", "http://localhost:8080/santasWorkshop2/workshop/toyservice/yearhist/" + selectionValue, true);

	} else if (selection == "child") {

		let selectionValue = document.querySelector("#selectionValue").value;
		if (selectionValue.length == 0) {
			selectionValue = 0;
		}
		req.open("GET", "http://localhost:8080/santasWorkshop2/workshop/toyservice/childtoy/" + selectionValue, true);

	} else if (selection == "worker") {

		let selectionValue = document.querySelector("#selectionValue").value;
		if (selectionValue.length == 0) {
			selectionValue = 0;
		}
		req.open("GET", "http://localhost:8080/santasWorkshop2/workshop/toyservice/workertoy/" + selectionValue, true);


	} else {
		req.open("GET", "http://localhost:8080/santasWorkshop2/workshop/toyservice/fullhist", true);
	}

	req.send();


}

function sendToyToHistory() {

	let toyID = ((document.querySelector("#toyID") || {}).value) || "";
	let yearProduced = ((document.querySelector("#yearProduced") || {}).value) || "0";
	let delivered = ((document.querySelector("#delivered") || {}).checked) || "false";


	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelector("#toyID").value = "";
			document.querySelector("#yearProduced").value = "";
			document.querySelector("#delivered").checked = false;
			document.querySelector("#sendToyResult").innerHTML = "Toy Sent to History.";
		} else {
			document.querySelector("#sendToyResult").innerHTML = "Toy was not Successfully sent to History.";
		}
	}

	req.open("PUT", "http://localhost:8080/santasWorkshop2/workshop/toyservice/sendtoy/" + toyID + "," + yearProduced + "," + delivered, true);
	req.send();
}

var children = [];

function showNaughtyNice() {
	console.log("showing Naughty Nice List");
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelectorAll("#contentTable tbody tr").forEach(function(e) {
				e.remove()
			});

			children = JSON.parse(this.responseText);
			let table = document.querySelector("#contentTable tbody");

			for (let i = 0; i < children.length; ++i) {
				let row = table.insertRow(table.rows.length);

				let childID = row.insertCell(0);
				childID.innerHTML = children[i].childID;

				let childName = row.insertCell(1);
				childName.innerHTML = children[i].childName;

				let childAge = row.insertCell(2);
				childAge.innerHTML = children[i].childAge;

				let naughty = row.insertCell(3);
				naughty.innerHTML = children[i].naughty;

			}
		}
	};
	req.open("GET", "http://localhost:8080/santasWorkshop2/workshop/nnservice/allchildren", true);
	req.send();
}

function addChildToList() {
	let child = {};
	child.childName = ((document.querySelector("#childName") || {}).value) || "";
	child.childAge = ((document.querySelector("#childAge") || {}).value) || "0";
	child.naughty = ((document.querySelector("#naughty") || {}).checked) || "false";


	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelector("#childName").value = "";
			document.querySelector("#childAge").value = "";
			document.querySelector("#naughty").checked = false;
			document.querySelector("#addChildResult").innerHTML = "Child added.";
		} else {
			document.querySelector("#addChildResult").innerHTML = "Child could not be added.";
		}
	}

	req.open("POST", "http://localhost:8080/santasWorkshop2/workshop/nnservice/addchild", true);
	req.setRequestHeader('Content-Type', 'application/json');
	req.send(JSON.stringify(child));


}

function createNewToy() {
	let toy = {};

	toy.toyName = ((document.querySelector("#toyName") || {}).value) || "";
	toy.toyColor = ((document.querySelector("#toyColor") || {}).value) || "";
	toy.workTime = ((document.querySelector("#workTime") || {}).value) || "0";
	toy.childID = ((document.querySelector("#childID") || {}).value) || "0";
	toy.elvenID = ((document.querySelector("#elvenID") || {}).value) || "0";


	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelector("#toyName").value = "";
			document.querySelector("#toyColor").value = "";
			document.querySelector("#workTime").value = "";
			document.querySelector("#childID").value = "";
			document.querySelector("#elvenID").value = "";
			document.querySelector("#createToyResult").innerHTML = "Toy added.";
		} else {
			document.querySelector("#createToyResult").innerHTML = "Toy could not be added.";
		}
	}

	req.open("POST", "http://localhost:8080/santasWorkshop2/workshop/toyservice/addtoy", true);
	req.setRequestHeader('Content-Type', 'application/json');
	req.send(JSON.stringify(toy));

}

function changeChildNaughty() {

	let childID = ((document.querySelector("#childID") || {}).value) || "";
	let naughty = ((document.querySelector("#updateNaughty") || {}).checked) || "false";

	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelector("#childID").value = "";
			document.querySelector("#updateNaughty").checked = false;
			document.querySelector("#changeStatusResult").innerHTML = "Child ID: " + childID + " naughty status changed to " + naughty;
		} else {
			document.querySelector("#changeStatusResult").innerHTML = "Child naughty status could not be changed.";
		}
	}

	req.open("PUT", "http://localhost:8080/santasWorkshop2/workshop/nnservice/updatenaughty/" + childID + "," + naughty, true);
	req.send();

}

function removeToy() {

	let toyID = ((document.querySelector("#toyID") || {}).value) || "0";

	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelector("#toyID").value = "";
			document.querySelector("#removeToyResult").innerHTML = "Toy ID: " + toyID + " removed from Production.";
		} else {
			document.querySelector("#removeToyResult").innerHTML = "Toy could not be removed from production.";
		}
	}

	req.open("DELETE", "http://localhost:8080/santasWorkshop2/workshop/toyservice/deletetoy/" + toyID, true);
	req.send();
}

function opensnackbar(message) {

	var x = document.getElementById("snackbar");

	x.innerHTML = message;

	x.className = "show";

	setTimeout(function() {
		x.className = x.className.replace("show", "");
	}, 3000);
}

function attemptSignin() {

	let empId = document.getElementById("dropdownID").value;
	let empPass = document.getElementById("dropdownPass").value;

	var req = new XMLHttpRequest();

	req.onreadystatechange = function() {

		if (this.readyState > 3 && this.status > 199 && this.status < 300) {

			let response = JSON.parse(this.responseText);

			if (response.correctLoginInfo == true) {

				opensnackbar("Logging In...");
				sessionStorage.empId = empId;

				setTimeout(function() {
					location.reload();
				}, 1000);

			} else {
				opensnackbar("Incorrect Login Details, Please Try Again.");
			}


			document.querySelector("#dropdownID").value = "";
			document.querySelector("#dropdownPass").value = "";
		}


	}
	req.open("POST", "http://localhost:8080/santasWorkshop2/workshop/loginservice/login/" + empId + "," + empPass, true);
	req.send();

}

function getContent(resource) {
	var req = new XMLHttpRequest();

	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelector("#bodyBox").innerHTML = this.responseText;
		}
	}

	req.open("GET", resource, true);
	req.send();


}


function makeLogoutButton() {
	var req = new XMLHttpRequest();

	console.log("changing login button to logout.");

	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			let menuItem = document.querySelector("#dropdownitem");
			menuItem.innerHTML = this.responseText;
			menuItem.className = "nav-item";

			document.querySelector("#dropdownitem a").addEventListener("click", logout);
		}
	}

	req.open("GET", "rss/logoutbutton.html", true);
	req.send();

}

function logout() {

	sessionStorage.clear();
	location.reload();

}
