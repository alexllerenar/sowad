<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Sistema ERP Comercial</title>
</head>
<body>
	<div align="center">
		<frm:form method="POST" action="VerificarAcceso">
			<table border="1"> 
				<tr>
					<td><frm:label path="Login" name="">Usuario:</frm:label></td>
					<td><frm:input path="Login"></frm:input></td>
				</tr>
				<tr>
					<td><frm:label path="Password" name="">Psssword:</frm:label></td>
					<td><frm:input path="Password"></frm:input></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Ingresar" name="btnIngresar"/>
						<input type="reset" value="Limpiar"/>
					</td>
				</td>			
			</table>
		</frm:form>
	</div>
</body>
</html>
