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
</head>
	<body>
	<p><a href="/Demo1/Index.jsp"> HOME</a>
<form id="commentForm" name="commentForm" method="post" action="/EmployeeController/AddRole/submit">
<label for="EmployeeProject"> Choose A Employee </label>
<select name="Employee" id ="Employee">
<% EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
List <Employee> employeeList = employeeService.getAllEmployee();
for (int index = 0 ; index < employeeList.size() ; index ++) {
        Employee employee = employeeList.get(index);%>
      <option value = <%=employee.getEmployeeId()%>> <%=employee.getEmployeeId()%> : <%= employee.getPersonalDetails().getName() %></option>
    <%} %>
    </select>
    <br>
   <br> 
    <label for="EmployeeProject"> Choose A Project</label>
    <select  name="Project" id ="Project" multiple>  
    <%
		RoleServiceImpl roleService = new RoleServiceImpl();
		List<Role> roles = roleService.getAllRole();
		for (int index = 0; index < roles.size(); index++) {
			Role role = roles.get(index);
		%>
        <option value = <%=role.getRoleId()%> > <%=role.getRoleId() %> : <%=role.getRoleName() %> </option>
        <%} %>
      </select>  
      <input type="text" name="mode" id="mode" name="mode"
			value="<%=request.getParameter("mode")%>"
			style="visibility: hidden;"> <br> <br>
      <input type="submit" id="submit" value="AddEmployeeProject"/>
      </form>
</body>
</html>