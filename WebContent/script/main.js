window.onload = onLoad;

document.getElementById("signinButton").addEventListener("click", attemptSignin);

document.querySelector("#toHome").addEventListener("click", function(){location.reload();});


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

	let selection = ((document.querySelector("#searchHistoryBy")||{}).value)||"none";

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

	}

	else if (selection == "worker") {

		req.open("GET", "http://localhost:8080/santasWorkshop2/workshop/toyservice/childtoy/" + sessionStorage.empId, true);


	}

	 else {
		req.open("GET", "http://localhost:8080/santasWorkshop2/workshop/toyservice/fullhist", true);
	}

	req.send();


}

function sendToyToHistory() {

	let toyID = ((document.querySelector("#toyID")||{}).value)||"";
	let yearProduced = ((document.querySelector("#yearProduced")||{}).value)||"0";
	let delivered = ((document.querySelector("#delivered")||{}).checked)||"false";
	console.log(delivered);


	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelector("#toyID").value = "";
			document.querySelector("#yearProduced").value = "";
			document.querySelector("#delivered").checked = false;
			document.querySelector("#sendToyResult").innerHTML = "Toy Sent to History.";
		}

		else {
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
	child.childName = ((document.querySelector("#childName")||{}).value)||"";
	child.childAge = ((document.querySelector("#childAge")||{}).value)||"0";
	child.naughty = ((document.querySelector("#naughty")||{}).checked)||"false";


	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelector("#childName").value = "";
			document.querySelector("#childAge").value = "";
			document.querySelector("#naughty").checked = false;
			document.querySelector("#addChildResult").innerHTML = "Child added.";
		}

		else {
			document.querySelector("#addChildResult").innerHTML = "Child could not be added.";
		}
	}

	req.open("POST", "http://localhost:8080/santasWorkshop2/workshop/nnservice/addchild", true);
	req.setRequestHeader('Content-Type', 'application/json');
	req.send(JSON.stringify(child));


}

function changeChildNaughty() {

	let childID = ((document.querySelector("#childID")||{}).value)||"";
	let naughty = ((document.querySelector("#updateNaughty")||{}).checked)||"false";

	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status > 199 && this.status < 300) {
			document.querySelector("#childID").value = "";
			document.querySelector("#updateNaughty").checked = false;
			document.querySelector("#changeStatusResult").innerHTML = "Child ID: " + childID + " naughty status changed to " + naughty;
		}

		else {
			document.querySelector("#changeStatusResult").innerHTML = "Child naughty status could not be changed.";
		}
	}

	req.open("PUT", "http://localhost:8080/santasWorkshop2/workshop/nnservice/updatenaughty/" + childID + "," + naughty, true);
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
