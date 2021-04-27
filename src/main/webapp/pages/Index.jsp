<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMPLOYEE PROJECT MANAGEMENT</title>
<script>
function employeeFunction() {
	if (document.getElementById("project").checked) {
		document.getElementById("ProjectDivision").style.visibility='visible';
	    document.getElementById("EmployeeDivision").style.visibility='hidden';
	} else if (document.getElementById("employee").checked) {
		document.getElementById("EmployeeDivision").style.visibility='visible';
	    document.getElementById("ProjectDivision").style.visibility='hidden';
	}
}
</script>
</head>
<body>   
<h1 style="
position: absolute;
    left: 299px; 
    color: darkblue; 
    font-size: -webkit-xxx-large;">
    EMPLOYEE PROJECT MANAGEMENT</h1>
<div id="EmployeeRadiDivision" style="
position: absolute;
    top: 140px;
    left: 365px; 
    color: red;
    font-size: x-large;">
<input type="radio" id ="employee" name="employeeApplication" checked="checked" onchange="employeeFunction()">
<label for ="employee">EMPLOYEE DETAILS</label><br>
</div>
<div id ="ProjectRadioDivision" style="
position: absolute;
    top: 140px;
    left: 651px; 
    color: red;
    font-size: x-large;">
<input type="radio" id ="project" name="employeeApplication" onchange="employeeFunction()"/>
<label for ="project">PROJECT DETAILS</label><br>
</div>
<div id="EmployeeDivision" style="
    visibility: visible;
    position: absolute;
    top: 280px;
    left: 441px;
    font-size: x-large;">
<h2>Employee Details</h2>
<p><a href="EmployeeController/Insert?mode=1">INSERT</a>
<p><a href="EmployeeController/Update?mode=2">UPDATE</a>
<p><a href="EmployeeController/Delete?mode=3">DELETE</a>
<p><a href="EmployeeController/ViewAll">DISPLAY EMPLOYEE DETAILS</a>
<p><a href="EmployeeController/View?mode=4">DISPLAY EMPLOYEE</a>
<p><a href="EmployeeController/AddProject?mode=5"> ADD EMPLOYEE TO PROJECT</a>
</div>
<div id="ProjectDivision" style="
    visibility: hidden;
    position: absolute;
    top:  280px;
    left: 441px;
    font-size: x-large;">
<h2>Project Details</h2>
<p><a href="RolesController/Insert?mode=1">INSERT</a>
<p><a href="RolesController/Update?mode=2">UPDATE</a>
<p><a href="RolesController/Delete?mode=6">DELETE</a>
<p><a href="RolesController/ViewAllProject">DISPLAY PROJECT DETAILS</a>
<p><a href="RolesController/View?mode=4">DISPLAY PROJECT</a>
<p><a href="RolesController/AddEmployee?mode=5">ADD PROJECT TO EMPLOYEE</a>
</div>
</body>
</html>
