/*function mesg(){
	alert("SignUp Successful");
}*/
function buttonClick(){
	document.getElementById("heading2").innerHTML="Namasta";
}
function validateform(){
	var fname=document.getElementById("fname").value; 
	var lname=document.getElementById("lname").value;
	var uname=document.getElementById("uname").value;
	var password=document.getElementById("password").value;
	
	if(fname==null || fname==""){
		alert("First Name cannot be null");
		return false;
	}
	else if(lname==null || lname==""){
		alert("Last Name cannot be null");
		return false;
	}
	else if(uname==null || uname==""){
		alert("User Name cannot be null");
		return false;
	}
	else if(password==null || password==""){
		alert("Password cannot be null");
		return false;
	}
	else{
		true;
	}
}

function validateLoginForm(){
	var uname=document.getElementById("uname").value;
	var password=document.getElementById("password").value;
	var confirmPassword=document.getElementById("confirmPassword").value;
	if(uname=="" || password=="" || confirmPassword==""){
		alert("No blank space allowed");
		return false;
	}
	else{
		true;
	}
}

 const signup=document.getElementById("signup");
    signup.addEventListener("mouseover",function handleMouseOver(){
		signup.style.color="red";
});