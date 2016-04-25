package com.ent.Seguridad;

import com.ent.Comun.CMM_PersonaEnt;

public class SEG_UsuarioEnt {
	private int idUsuario;	
	private String Login;
	private String Password;
	private Boolean Activo;
	private CMM_PersonaEnt Persona;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Boolean getActivo() {
		return Activo;
	}
	public void setActivo(Boolean activo) {
		Activo = activo;
	}
	public CMM_PersonaEnt getPersona() {
		return Persona;
	}
	public void setPersona(CMM_PersonaEnt persona) {
		Persona = persona;
	}
}
