<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.List, model.Task" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main Page</title>
</head>
<body>

	<%
	List<Task> tasks = (List<Task>) request.getAttribute("tasks");
	
	if(tasks != null){
		for(Task task : tasks){
	%>
	
	<div align="center" style="font-size:20px">
		<h1>Task Editing</h1>
		
		<table cellspacing="10px" style="padding:20px; text-align:center">
			<tr>
				<td>Title:</td>
				<td><%= task.getTitle() %></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><%= task.getDescription() %></td>
			</tr>
		</table>
	</div>
	
	<%
		}
	}else{
	%>
	
	<div align="center" style="font-size:20px">
		<h1>No tasks registered.</h1>
	</div>
	
	<%
	}
	%>

</body>
</html>
