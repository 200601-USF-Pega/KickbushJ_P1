
window.onload = onLoad;

document.getElementById("signinButton").addEventListener("click", attemptSignin);


function onLoad() {

	let empId = sessionStorage.empId;

	if (empId == undefined) {

		console.log("not logged in");

	}

	else if (empId == 1) {

		console.log("Manager logged in");

		document.querySelectorAll("#body nav div ul .nav-item a").forEach(function(e) {e.className = "nav-link";});

		document.querySelector("#dropdownitem").style.visibility = "hidden";

		getContent("rss/managerhome.html");

	}

	else if (empId > 1) {

		console.log("Employee logged in");

		document.querySelectorAll("#body nav div ul .nav-item a").forEach(function(e) {e.className = "nav-link";});

		document.querySelector("#workers a").className = "nav-link disabled";

		document.querySelector("#dropdownitem").style.visibility = "hidden";

		getContent("rss/employeehome.html");

	}

}

function opensnackbar(message) {

	var x = document.getElementById("snackbar");

	x.innerHTML = message;

	x.className = "show";

	setTimeout(function(){x.className = x.className.replace("show", ""); }, 3000);
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

			}

			else {
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
