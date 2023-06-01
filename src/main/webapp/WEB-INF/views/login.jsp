<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User Login</title>
</head>
<body>

	<div align="center" style="font-size:20px">
		<h1>Login</h1>
		
		<form action="<%= request.getContextPath() %>/login" method="post">
		<table cellspacing="10px" style="padding:20px; text-align:center">
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<input type="submit" value="Log in" style="margin:20px; padding: 5px; font-size:15px" />
		</form>
		
		<form action="<%= request.getContextPath() %>/signup" method="get">
			<input type="submit" value="Register" style="padding: 5px; font-size:15px" />
		</form>
	</div>

</body>
</html>
