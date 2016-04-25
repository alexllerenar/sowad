<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ent.Seguridad.*" %>    
<%@ page import="com.log.Seguridad.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
// 		if(request.getParameter("btnIngresar")!=null){
// 			try{
// 				entSEG_Usuario u = logSEG_Usuario.Instancia().VerificarAcceso(
// 						request.getParameter("txtLogin"), 
// 						request.getParameter("txtPassword"));
// 				if(u!=null){
// 					response.sendRedirect("frmPrincipal");
// 				}else{
// 					out.print("Usuario o PAssword no Valido");
// 				}
// 			}catch(Exception e){
// 				out.print(e.getMessage());
// 			}
// 		}
	%>

	<br/><br/>
	<div align="center">
		<form action="sVerificarAcceso" method="post">
			<table border=1>
				<tr>
					<td>Login:</td>
					<td><input type="text" name="txtLogin"/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="txtPassword"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" name="btnIngresar" value="Ingresar"/>
						<input type="reset" value="Limpiar"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>