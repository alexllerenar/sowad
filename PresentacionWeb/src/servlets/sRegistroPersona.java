package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.log.Comun.*;
import com.ent.Comun.*;
import com.ent.Seguridad.*;

@WebServlet("/sRegistroPersona")
public class sRegistroPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public sRegistroPersona() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			CMM_PersonaEnt p = new CMM_PersonaEnt();
			int id =Integer.parseInt(request.getParameter("txtidPersona")==null?"0":request.getParameter("txtidPersona")); 
			p.setIdPersona(id);
			p.setNombres(request.getParameter("txtNombre"));
			p.setApellidos(request.getParameter("txtApellido"));
			p.setDNI(request.getParameter("txtDNI"));
			p.setDireccion(request.getParameter("txtDireccion"));
			p.setTelefono(request.getParameter("txtTelefono"));
			p.setSexo(request.getParameter("txtSexo"));			
			p.setFechaNacimiento(request.getParameter("txtFechaNac"));
			
			HttpSession s = request.getSession();
			SEG_UsuarioEnt u = (SEG_UsuarioEnt)s.getAttribute("usuario");
			
			String Mensaje = "";
			String Opcion = Integer.parseInt(request.getParameter("txtidPersona")==null?"0":request.getParameter("txtidPersona"))>0?"E":"N";
			if(Opcion.equals("N")){			
				boolean x = CMM_PersonaLog.Instancia().InsertarPersona(p, u.getLogin());
				if(x){Mensaje = "Se Inserto satisfactoriamente";}
			}
			if(Opcion.equals("E")){
				boolean x = CMM_PersonaLog.Instancia().EditarPersona(p, u.getLogin());
				if(x){Mensaje = "Se Edito satisfactoriamente";}
			}			
			response.sendRedirect("frmRegistroPersona.jsp?msj="+Mensaje);
		} catch (Exception e) {
			out.print("<script>alert('"+e.getMessage()+"')</script>");
		}
	}

}

