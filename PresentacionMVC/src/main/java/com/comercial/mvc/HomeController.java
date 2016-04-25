package com.comercial.mvc;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ent.Seguridad.SEG_UsuarioEnt;
import com.log.Comun.CMM_PersonaLog;
import com.log.Seguridad.SEG_UsuarioLog;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		
		return new ModelAndView("home", "command", new SEG_UsuarioEnt());
	}
	
	@RequestMapping(value = "/VerificarAcceso", method = RequestMethod.POST)
	public String VerificarAcceso(@ModelAttribute("SpringWeb")SEG_UsuarioEnt u, 
										ModelMap model) {
		try {
			String Usuario = u.getLogin();
			String Password = u.getPassword();
			SEG_UsuarioLog.Instancia().VerificarAcceso(Usuario, Password);			
			return "frmMenuPrincipal";	
		} catch (Exception e) {
			return "frmError";
		}
	}
	
	@RequestMapping(value = "/RegistroUsuario", method = RequestMethod.GET)
	public ModelAndView RegistroUsuario() {		
		try {
			ModelAndView m = new ModelAndView("ListaUsuario");
			m.addObject("lista", CMM_PersonaLog.Instancia().ListarPersona());

			return m;

		} catch (Exception e) {
			return new ModelAndView("home", "command", new SEG_UsuarioEnt());
		}
		
	}
	
}
