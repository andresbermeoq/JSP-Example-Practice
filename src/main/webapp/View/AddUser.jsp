<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create User</title>
</head>
<body>

	<h1>Create User Andres</h1>
	
	<form action="createUser" method="post">
		ID: <input type="text" name="id">
		Nombre: <input type="text" name="nombre">
		Apellido: <input type="text" name="apellido">
		Cedula: <input type="text" name="cedula">
		Email: <input type="text" name="email">
		Password: <input type="text" name="password">
		<br>
		<input type="submit" value="Crear Usuario">
	</form>
	
	<form action="listUser" method="get">
		<input type="submit" value="List Users">
	</form>

</body>
</html>