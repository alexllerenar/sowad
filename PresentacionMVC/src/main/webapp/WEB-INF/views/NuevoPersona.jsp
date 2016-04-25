<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Sistema ERP Comercial</title>
</head>
<body>
	<h2>Nueva PErsona</h2>
	<br/>
	<frm:form method="POST">
		<table border="1"> 
			<tr>
				<td><frm:label path="Nombres" name="">Nombres:</frm:label></td>
				<td><frm:input path="Nombres"></frm:input></td>
			</tr>
			<tr>
				<td><frm:label path="Apellidos" name="">Apellidos:</frm:label></td>
				<td><frm:input path="Apellidos"></frm:input></td>
			</tr>
			<tr>
				<td><frm:label path="DNI" name="">DNI:</frm:label></td>
				<td><frm:input path="DNI"></frm:input></td>
			</tr>
			<tr>
				<td><frm:label path="Direccion" name="">Direccion:</frm:label></td>
				<td><frm:input path="Direccion"></frm:input></td>
			</tr>
			<tr>
				<td><frm:label path="Telefono" name="">Telefono:</frm:label></td>
				<td><frm:input path="Telefono"></frm:input></td>
			</tr>
			<tr>
				<td><frm:label path="FechaNacimiento" name="">FechaNacimiento:</frm:label></td>
				<td><frm:input path="FechaNacimiento"></frm:input></td>
			</tr>
			<tr>
				<td><frm:label path="Sexo" name="">Sexo:</frm:label></td>
				<td><frm:input path="Sexo"></frm:input></td>
			</tr>		
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Ingresar" name="btnIngresar"/>
					<input type="reset" value="Limpiar"/>
				</td>
			</td>			
		</table>
	</frm:form>
</body>
</html>