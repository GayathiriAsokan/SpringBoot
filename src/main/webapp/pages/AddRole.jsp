<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ROLE DETAILS</title>
<style>
body {
	background-image: url('/WebContent/view/jsp/Work.jpg');
	background-color: #cccccc;
	height: 500px;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

.view_only {
	background-color: ghostwhite;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/json2/20130526/json2.min.js"></script>
<script type="text/javascript">
	$(function() {
		 function view_only() {
			$("#RoleName").attr("readonly", true);
			$('.non_editable').addClass('view_only');
		}
		$('#SEARCH').click(function() {
			if ($('#mode').val() == "2") {
				 view_only();
				$("#EmployeeId").attr("readonly", false);
			} else if ($('#mode').val() == "3") {
				 view_only();
			     $("#Status").attr("readonly", false);
			} else if ($('#mode').val() == "4") {
				view_only();
			}
			var RoleId = $('#RoleId');
			console.log(RoleId);
			$.ajax({
				type : "GET",
				url : "Update/ajax",
				data : RoleId,
				success : function(data) {
					var arrayEmployeeValues = JSON.parse(data);
					var role = arrayEmployeeValues[0];
				 	$("#EmployeeId").val(role.employeeId);
					$("#RoleName").val(role.roleName); 
				}
			});
		});
		}); 
</script>
</head>
<body>
	<p>
		<a href="/"> HOME</a>
	<form id="commentForm" name="commentForm" method="post"
		<% 
	 int mode = Integer.parseInt(request.getParameter("mode"));
	 if (mode == 1) {
	%>
		action=Insert/submit <% } 
        else if (mode == 2)  {%>
		action=Update/submit <%}
        else if (mode ==3) { %>
		action=Delete/submit <%} %>>
		<div id="Employee" style="position: absolute; left: 171px;">
			<h1>ROLE DETAILS</h1>
			<%
			 mode = Integer.parseInt(request.getParameter("mode"));
		if (mode > 1) {
		%>
			<label for="RoleId"> RoleId: </label><br> <input
				type="number" id="RoleId" name="RoleId" required> <input
				type="button" id="SEARCH" value="SEARCH">
			<%
			}
		%>
			<br> <br> <label for="RoleName">RoleName: </label> <br>
			<input type="text" id="RoleName" name="RoleName" 
				class="non_editable" required> <br> <br>
			<br>  <label
				for="EmployeeId">EmployeeId: </label> <br> <input type="number"
				id="EmployeeId" name="EmployeeId" class="non_editable" required>
			<br> <br> 
			<input type="text" name="mode" id="mode" name="mode"
				value="<%=request.getParameter("mode")%>"
				style="visibility: hidden;"> <br> <br>
		</div>
		<%
			mode = Integer.parseInt(request.getParameter("mode"));
		if (mode != 4) {
		%>
		<div id="submit division"
			style="position: absolute; top: 333px;
    left: 328px; color: darkblue !important; font-size: medium !important;">
			<input type="submit" id="submit" value="ADD ROLE DETAILS" />
			<%
			}
		%>
		</div>
	</form>
</body>
</html>