<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Employee</title>
</head>
<body>
	<h3>Enter id of employee you want to delete !</h3>
	<form action="deleteData" method="post">

		Enter EmpId<input type="text" name="id"><br>
		<br> <input type="submit" value="delete"
			style="margin-left: 10px">
	</form>

</body>
</html>