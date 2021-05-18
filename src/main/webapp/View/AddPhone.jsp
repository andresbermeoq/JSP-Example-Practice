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
<title>Add Phone</title>
</head>
<body>

	<h1>Add Phone</h1>
	
	<h1>Bienvenido: <%  out.print(usuario.getNombre()+" "+usuario.getApellido());  %></h1>
	<h1>Codigo: <%  out.print(usuario.getId());  %></h1>
	
	
	<form action="createPhone" method="post">
		<input hidden="true" name="codigo" type="text" value="${usuario.getId()}">
		<input hidden="true" name="cedula" type="text" value="${usuario.getCedula()}">
		Numero: <input type="text" name="numero" value="${request.getParameter("numero"); }">
		<br>
		<label>Tipo</label>
		<select name="tipo" id="tipo">
				<option value="movil">Movil</option>
				<option value="fijo">Fijo</option>
		</select>
		<br>
		Operadora: <input type="text" name="operadora">
		<br>

		<input type="submit" value="Agregar">
	</form>
	
	<a href="/Practice-JSP/View/UserIndex.jsp">Regresar Al Inicio</a>

</body>
</html>