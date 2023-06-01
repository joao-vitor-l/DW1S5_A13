<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Task Registration</title>
</head>
<body>

	<div align="center" style="font-size:20px">
		<h1>New Task</h1>
		
		<form action="<%= request.getContextPath() %>/taskRegister" method="post">
		<table cellspacing="10px" style="padding:20px; text-align:center">
			<tr>
				<td>Title:</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description" /></td>
			</tr>
		</table>
		<input type="submit" value="Save" style="padding: 5px; font-size:15px" />
		</form>
	</div>

</body>
</html>
