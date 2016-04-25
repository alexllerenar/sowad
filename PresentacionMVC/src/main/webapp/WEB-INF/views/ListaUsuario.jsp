<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Registro de USuarios</h3>
	
	<a href="${pageContext.request.contextPath}/Persona/NuevoPersona">Nueva Persona</a>
	
	<table border="1" with="100%">
		<thead>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>DNI</th>
		</thead>
		<tbody>
			<c:forEach items="${lista}" var="persona">
				<tr>
					<td>${persona.nombres}</td>		
					<td>${persona.apellidos}</td>
					<td>${persona.DNI}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>