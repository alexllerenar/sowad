<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.log.Comun.*"%> 
<%@page import="com.ent.Comun.*"%>
<%@page import="java.util.*"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title></head>
<body>

	<h3>Registro de Persona</h3>
	<%
	CMM_PersonaEnt p = new CMM_PersonaEnt();
	if(request.getParameter("idPersona")!=null){
		int id = Integer.parseInt(request.getParameter("idPersona"));
		p = CMM_PersonaLog.Instancia().DevolverPersona(id);		
	}
	%>
	<form method="post" action="sRegistroPersona">
		<table border="1">
			<tr><td>idPersona:</td><td><input type="text" name="txtidPersona"  value="<%=p.getIdPersona()%>" /></td></tr>
			<tr><td>Nombres:</td><td><input type="text" name="txtNombre" value="<%=p.getNombres()==null?"":p.getNombres()%>"/></td></tr>
			<tr><td>Apellidos:</td><td><input type="text" name="txtApellido" value="<%=p.getApellidos()==null?"":p.getApellidos()%>"/></td></tr>
			<tr><td>DNI:</td><td><input type="text" name="txtDNI" value="<%=p.getDNI()!=null?p.getDNI():""%>"/></td></tr>
			<tr><td>Direccion:</td><td><input type="text" name="txtDireccion" value="<%=p.getDireccion()%>"/></td></tr>		
			<tr><td>Telefono:</td><td><input type="text" name="txtTelefono" value="<%=p.getTelefono()%>"/></td></tr>
			<tr><td>Sexo:</td><td><input type="text" name="txtSexo" value="<%=p.getSexo()%>"/></td></tr>
			<tr><td>Fecha Nac:</td><td><input type="text" name="txtFechaNac"  value="<%=p.getFechaNacimiento()%>"/></td></tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="btnGrabar" value="Grabar"/>
					<input type="submit" name="btnEliminar" value="Eliminar" <%if(request.getParameter("idPersona")==null){out.print("disabled");} %> />
				</td>
			</tr>
		</table>
	</form>
	<%
	out.print("<p style='color: blue'>"+request.getParameter("msj")+"</p>");
	%>

	<table border="1" style="width: 100%" class="table table-hover">
		<thead style="background-color: yellow">
			<tr>
				<th>DNI</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Sexo</th>
			</tr>
		</thead>
		<tbody>
		<%
		try{
			ArrayList<CMM_PersonaEnt> lista = CMM_PersonaLog.Instancia().ListarPersona();
			for(int i=0;i<lista.size();i++){
				out.print("<tr>");
				out.print("<td>"+lista.get(i).getDNI()+"</td>");
				out.print("<td>"+lista.get(i).getNombres()+"</td>");
				out.print("<td>"+lista.get(i).getApellidos()+"</td>");
				out.print("<td>"+lista.get(i).getSexo()+"</td>");
				out.print("<td><a href='frmRegistroPersona.jsp?idPersona="+
						lista.get(i).getIdPersona()+"'>Editar</a></td>");
				out.print("</tr>");
			}
		}catch(Exception e){
			out.print("<h3>"+e.getMessage()+"</h3>");
		}
		%>	
		</tbody>
	</table>

</body>
</html>