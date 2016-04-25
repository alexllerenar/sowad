package com.comercial.mvc;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ent.Comun.*;
import com.ent.Seguridad.SEG_UsuarioEnt;
import com.log.Comun.*;
import com.log.Seguridad.SEG_UsuarioLog;

@Controller
public class PersonaController {
	
	@RequestMapping(value = "/Persona/NuevoPersona", method = RequestMethod.GET)
	public ModelAndView Nuevo(Locale locale, Model model) {		
		return new ModelAndView("NuevoPersona", "command", new CMM_PersonaEnt());
	}

	@RequestMapping(value = "/Persona/NuevoPersona", method = RequestMethod.POST)
	public String GuardaPersona(@ModelAttribute("SpringWeb")CMM_PersonaEnt p, 
										ModelMap model) {
		try {
			boolean inserto = CMM_PersonaLog.Instancia().InsertarPersona(p, "XYZ");
			return "redirect:/RegistroUsuario";
		} catch (Exception e) {
			return "frmError";
		}
	}
}
