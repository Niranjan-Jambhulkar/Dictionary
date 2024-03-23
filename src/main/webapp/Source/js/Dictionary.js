function signup(){
	location.href = "SignUp.html"
}

function addWord(){
	location.href = "AddWord.jsp"
}

function Meaning(){
	location.href = "Home.jsp"
}

function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}

function dailog(){
	alert("Word Added");
}

function passReset(){
	location.href = "ForgetPassword.jsp"
}