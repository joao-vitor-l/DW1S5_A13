<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User Sign Up</title>
</head>
<body>

	<div align="center" style="font-size:20px">
		<h1>Register User</h1>
		
		<form action="<%= request.getContextPath() %>/signup" method="post">
		<table cellspacing="10px" style="padding:20px; text-align:center">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<input type="submit" value="Sign Up" style="padding: 5px; font-size:15px" />
		</form>
	</div>

</body>
</html>
