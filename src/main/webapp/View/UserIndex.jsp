<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Inicio</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>

	<c:set var="u" scope="request" value="${usuario}" />

	<div class="container">
		<ul class="nav nav-pills flex-column flex-sm-row justify-content-center">
			<li class="nav-item">
				<form action="createPhone" method="get">
					<input hidden="true" type="text" name="nombre" value="${usuario.getNombre()}"/>
					<input hidden="true" type="text" name="id" value="${usuario.getId()}"/>
					<input hidden="true" type="text" name="cedula" value="${usuario.getCedula()}"/>
					<input hidden="true" type="text" name="email" value="${usuario.getEmail()}"/>
					<input class="display-5 flex-sm-fill text-sm-center nav-link" type="submit" value="Crear Telefono">
				</form>
			</li>
			<li class="nav-item">
				<form action="logout" method="get">
					<input class="display-5 flex-sm-fill text-sm-center nav-link" type="submit" value="Cerrar Session">
				</form>
			</li>
		</ul>
		
		
		
		<h2 class="display-3">Bienvenido: ${usuario.getNombre().concat(usuario.getApellido())}</h2>
		<a href="mailto: ${u.getEmail()}">Enviar Correo</a>
		
		<br>
		
		<div class="container">
			<h5 class="display-4">Numeros de Telefonos</h5>
			<c:set var="t" scope="request" value="${telefonos}" />
			
			<table class="table table-hover" id="table-1">
				<thead>
					<tr>
						<th>N</th>
						<th>Numero</th>
						<th>Tipo</th>
						<th>Operadora</th>
						<th>Transacciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="t" items="${u.getTelefonos()}">
						<tr>
							<td><p class="h4">${t.codigo}</p></td>
							<td><a href="tel:+593 ${tel.numero}">${t.numero}</a></td>
							<td><p class="h4">${t.tipo}</p></td>
							<td><p class="h4">${t.operadora}</p></td>
							<td>
								<div class="container">
									<div class="row">
										<form class="row g-3" action="updatePhone" method="get">
											<input id="codigo" name="codigo" value="${t.codigo}" type="text" hidden="true"/>
											<input class="btn btn-primary" type="submit" value="Editar" id="button-1"/>
										</form>
									</div>
									<div class="row">
										<form class="row g-3" action="deletePhone" method="get">
											<input id="codigo" name="codigo" value="${t.codigo}" placeholder="Text" type="text" hidden="true"/>
											<input class="btn btn-secondary" type="submit" value="X" id="button-2"/>
										</form>
									</div>
								</div>	
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	
	</div>

	
</body>
</html>