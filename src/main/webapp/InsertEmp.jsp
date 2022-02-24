<%@page import="com.techm.dbconn.DatabaseConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert employee </title>
</head>
<body>
	<h2>Enter Below Credentials !</h2>
	<form action="insertData" method="POST">
		<table>
		<tr>
			<td>Emp Id</td><td><input type="text" name='id'></td>
		</tr>
		<tr>
			<td>Emp name</td><td><input type="text" name='name'></td>
		</tr>
		<tr>
			<td>Emp desc</td><td><input type="text" name='desc'></td>
		</tr>
		<tr>
			<td>Emp sal</td><td><input type="text" name='sal'></td>
		</tr>
		<tr>
			<td>Emp age</td><td><input type="text" name='age'></td>
		</tr>
		
		</table>
		
		<input type="submit" value="register"  style="margin-left:10px">
	</form>
	
</body>
</html>