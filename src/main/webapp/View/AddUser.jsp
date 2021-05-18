<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create User</title>
</head>
<body>

	<h1>Crear Nuevo Usuario</h1>
	
	<form action="createUser" method="post">
		Nombre: <input type="text" name="nombre">
		Apellido: <input type="text" name="apellido">
		Cedula: <input type="text" name="cedula">
		Email: <input type="text" name="email">
		Password: <input type="text" name="password">
		<br>
		<input type="submit" value="Crear Usuario">
	</form>

</body>
</html>