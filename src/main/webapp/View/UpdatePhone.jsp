<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>

	
	<c:set var="t" scope="request" value="${telefono}"/>
	
	<div class="container">
		<h1 class="display-1">Actualizar Telefono</h1>
		<h1 class="display-3">Codigo: ${t.codigo }</h1>
	
		<form class="row g-3" action="updatePhone" method="post">
			<input hidden="true" type="text" name="codigo" value="${t.codigo }">
			<div class="col-md-6">
				<label for="inputNumber" class="form-label">Numero</label>
				<input class="form-control" type="text" name="numero" value="${t.numero }">
			</div>
			<div class="col-md-6">
				<label for="inputOperator" class="form-label">Operadora</label>
				<input class="form-control" type="text" name="operadora" value="${t.operadora }">
			</div>
			
			<div class="col-12">
				<label for="inputType" class="form-label">Tipo</label>
				<select class="form-select" name="tipo" id="tipo">
					<option value="movil">Movil</option>
					<option value="fijo">Fijo</option>
				</select>
			
			</div>
	
			<input class="btn btn-primary" type="submit" value="Actualizar">
		
		</form>
	</div>
	
	

</body>
</html>