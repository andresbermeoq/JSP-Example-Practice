<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>

	
	
	<br>
	
	<div class="container">
		<h1 class="display-1">Login</h1>
		<form action="login" method="post">
			<div class="mb-3 row">
				<label for="staticEmail" class="display-5 col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input class="form-control form-control-lg" type="text" name="email">
				</div>
			</div> 
			<br>
			<div class="mb-3 row">
				<label for="inputPassword" class="display-5 col-sm-2 col-form-label">Password</label>
				<div class="col-sm-10">
					<input class="form-control form-control-lg" type="password" name="password">
				</div>
			</div>
			<br>
			<div class="d-grid gap-2">
				<button type="submit" class="btn btn-primary mb-3">Ingreso</button>
			</div>
			
	</form>
	</div>
	
	
	
	

</body>
</html>