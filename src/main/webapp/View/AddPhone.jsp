<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Phone</title>
</head>
<body>

	<h1>Add Phone</h1>
	
	<form action="createUser" method="post">
		Numero: <input type="text" name="numero">
		Tipo: <input type="text" name="tipo">
		Operadora: <input type="text" name="operadora">
		Usuario: <input type="text" name="usuario">
		<br>
		<input type="submit" value="Agregar">
	</form>

</body>
</html>