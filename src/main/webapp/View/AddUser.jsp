<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>

	<div class="container">
		<h1 class="display-1">Crear Nuevo Usuario</h1>
	
		<form class="row g-3" action="createUser" method="post">
			<div class="col-md-6">
				<label for="inputName" class="form-label">Nombre</label>
				<input class="form-control" type="text" name="nombre">
			</div>
			<div class="col-md-6">
				<label for="inputLastName" class="form-label">Apellido</label>
				<input class="form-control" type="text" name="apellido">
			</div> 
			<div class="col-md-6">
				<label for="inputCedula" class="form-label">Cedula</label>
				<input class="form-control" type="text" name="cedula">
			</div>
			<div class="col-12">
				<label for="inputEmail" class="form-label">Email</label>
				<input class="form-control" type="text" name="email">
			</div>
			<div class="col-12">
				<label for="inputPassword" class="form-label">Password</label>
				<input class="form-control" type="password" name="password">
			</div>
			<br>
			<input class="btn btn-primary" type="submit" value="Crear Usuario">
		</form>
		
	</div>
</body>
</html>