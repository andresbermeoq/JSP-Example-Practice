<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>

	<h1>Actualizar Telefono</h1>
	<c:set var="t" scope="request" value="${telefono}"/>
	
	<h1>Codigo: ${t.codigo }</h1>
	
	<form action="updatePhone" method="post">
		<input hidden="true" type="text" name="codigo" value="${t.codigo }">
		Numero: <input type="text" name="numero" value="${t.numero }">
		<br>
		<label>Tipo</label>
		<select name="tipo" id="tipo">
				<option value="movil">Movil</option>
				<option value="fijo">Fijo</option>
		</select>
		<br>
		Operadora: <input type="text" name="operadora" value="${t.operadora }">
		<br>

		<input type="submit" value="Actualizar">
	
	</form>

</body>
</html>