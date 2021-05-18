<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Inicio</title>
</head>
<body>

	<h1>Agenda Telefonica</h1>
	<c:set var="u" scope="request" value="${usuario}" />
	
	<h1>Bienvenido: ${usuario.getNombre().concat(usuario.getApellido())}</h1>
	
	<form action="createPhone" method="get">
		<input hidden="true" type="text" name="nombre" value="${usuario.getNombre()}"/>
		<input hidden="true" type="text" name="id" value="${usuario.getId()}"/>
		<input hidden="true" type="text" name="cedula" value="${usuario.getCedula()}"/>
		<input hidden="true" type="text" name="email" value="${usuario.getEmail()}"/>
		<input type="submit" value="Crear Telefono">
	</form>
	
	<form action="logout" method="get">
		<input type="submit" value="Cerrar Session">
	</form>
	
	<div>
		<h5>Numeros de Telefonos</h5>
		<c:set var="t" scope="request" value="${telefonos}" />
		
		<table id="table-1">
			<thead>
				<tr>
					<th>N</th>
					<th>Numero</th>
					<th>Tipo</th>
					<th>Operadora</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="t" items="${u.getTelefonos()}">
					<tr>
						<td>${t.codigo}</td>
						<td>${t.numero}</td>
						<td>${t.tipo}</td>
						<td>${t.operadora}</td>
						<td>
							<form action="updatePhone" method="get">
								<input id="codigo" name="codigo" value="${t.codigo}" type="text" hidden="true"/>
								<input type="submit" value="Editar" id="button-2"/>
							</form>
						</td>
						<td>
							<form action="deletePhone" method="get">
								<input id="codigo" name="codigo" value="${t.codigo}" placeholder="Text" type="text" hidden="true"/>
								<input type="submit" value="X" id="button-2"/>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>