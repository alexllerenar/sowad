package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ent.Seguridad.*;
import com.log.Seguridad.*;

@WebServlet("/sVerificarAcceso")
public class sVerificarAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public sVerificarAcceso() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		PrintWriter out = response.getWriter();
		if(request.getParameter("btnIngresar")!=null){
			try{
				SEG_UsuarioEnt u = SEG_UsuarioLog.Instancia().VerificarAcceso(
						request.getParameter("txtLogin"), 
						request.getParameter("txtPassword"));
				HttpSession s = request.getSession();
				s.setAttribute("usuario", u);					
				response.sendRedirect("frmPrincipal.jsp");
			}catch(Exception e){
				out.print(e.getMessage());
			}
		}
	}

}
