<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" session="true" %>
<%@ page import="ec.edu.ups.modelo.Usuario" %>


<% HttpSession sesion=request.getSession();
Usuario usuario=new Usuario();
usuario = (Usuario) sesion.getAttribute("usuario");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agrega Telefono</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>

	<div class="container">
		<h1 class="display-1">Agrega Telefono</h1>
	
		<h1 class="display-1">Bienvenido: <%  out.print(usuario.getNombre()+" "+usuario.getApellido());  %></h1>
		
		<form class="row g-3" action="createPhone" method="post">
			<input hidden="true" name="codigo" type="text" value="${usuario.getId()}">
			<input hidden="true" name="cedula" type="text" value="${usuario.getCedula()}">
			
			<div class="col-md-6">
				<label for="inputNumber" class="form-label">Numero</label>
				<input class="form-control" type="text" name="numero">
			</div>
			
			<div class="col-md-6">
				<label for="inputOperator" class="form-label">Operadora</label>
				<input class="form-control" type="text" name="operadora">
			</div>
			
			<div class="col-12">
				<label for="inputType" class="form-label">Tipo</label>
				<select class="form-select" name="tipo" id="tipo">
					<option value="movil">Movil</option>
					<option value="fijo">Fijo</option>
				</select>
			</div>
			
			<br>
	
			<input class="btn btn-primary" type="submit" value="Agregar">
		</form>
	
	</div>

</body>
</html>