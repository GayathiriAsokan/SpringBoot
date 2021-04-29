<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.ArrayList" %>
    <%@ page import = "java.util.List" %>
    <%@ page import = "com.ideas2it.Employee.Application.model.Employee" %>
    <%@ page import = "com.ideas2it.Employee.Application.service.Impl.EmployeeServiceImpl" %>
    <%@ page import="com.ideas2it.Employee.Application.service.Impl.RoleServiceImpl"%>
    <%@ page import="com.ideas2it.Employee.Application.model.Role"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMPLOYEE ROLE MANAGEMENT</title>
<script>
function employee() {
	/* var e = document.getElementById("Employee");
	var employee = e.options[e.selectedIndex].value;
	console.log(employee);
	var r = document.getElementById("Roles");
	var roles = r.options[r.selectedIndex].value;
	console.log(roles); */
	 var selected = [];
	    for (var option of document.getElementById('Employee').options)
	    {
	        if (option.selected) {
	            selected.push(option.value);
	        }
	    }
	    var roles = [];
	    for (var option of document.getElementById('Roles').options)
	    {
	        if (option.selected) {
	        	roles.push(option.value);
	        }
	    }
	window.location = 'http://localhost:9020/EmployeeController/AddRole/submit?employee='+ selected  + '&roles=' + roles;
}
</script>
</head>
	<body>
	<h1></h1>
<p><a href="Index.jsp"> HOME</a>
<!-- <form id="commentForm" name="commentForm" method="get" action="/EmployeeController/AddRole/submit"> -->
<label for="EmployeeRole"> Choose A Employee </label>
<select name="Employee" id ="Employee" multiple>

<% int count = (int) request.getAttribute("employeeById");
for (int index = 1 ; index <= count ; index ++) {
      %>
      <option value = <%= index %> name =  <%= index %> > <%= index %>:  </option>
      <%}%>
    </select>
    <br>
   <br> 
    <label for="EmployeeRole"> Choose A Role</label>
    <select  name="Roles" id ="Roles" multiple>  
    <% int countRole = (int) request.getAttribute("rolesById");
		for (int index = 1; index <= countRole; index++) {
		%>
        <option value = <%=index%> name =  <%= index %> > <%=index %>  </option>
        <%} %>
 --%>      </select>  
      <input type="text" name="mode" id="mode" name="mode"
			value="<%=request.getParameter("mode")%>"
			style="visibility: hidden;"> <br> <br>
      <button id="submit" value="AddEmployeeRole" onclick="employee()">AddEmployeeRole
      </button>
      <!-- <a href = "/EmployeeController/AddRole/submit" onclick="employee()">AddEmployeeRole</a> -->
 </body>
</html>