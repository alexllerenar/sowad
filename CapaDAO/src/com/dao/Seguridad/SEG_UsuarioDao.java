package com.dao.Seguridad;

import java.sql.*;

import com.dao.Comun.*;

import com.ent.Comun.*;
import com.ent.Seguridad.*;

public class SEG_UsuarioDao {
	//Singleton
	public static SEG_UsuarioDao _Instancia;
	private SEG_UsuarioDao(){};
	public static SEG_UsuarioDao Instancia(){
		if(_Instancia==null){
			_Instancia = new SEG_UsuarioDao();
		}
		return _Instancia;
	}
	//endSingleton
	
	public SEG_UsuarioEnt VerificarAcceso(String _Login, String _Passw) throws Exception{
		Connection cn = Conexion.Instancia().Conectar();
		SEG_UsuarioEnt u = null;
		try {
			CallableStatement cst = cn.prepareCall("{call spSEG_VerificarAcceso(?,?)}");
			cst.setString(1, _Login);
			cst.setString(2, _Passw);
			ResultSet rs = cst.executeQuery();
			if(rs.next()){
				u = new SEG_UsuarioEnt();
				u.setIdUsuario(rs.getInt("IdUsuario"));
				u.setActivo(rs.getBoolean("Activo"));
				u.setLogin(rs.getString("Login"));
					CMM_PersonaEnt p = new CMM_PersonaEnt();
					p.setIdPersona(rs.getInt("IdPersona"));
					p.setNombres(rs.getString("nombres"));
					p.setApellidos(rs.getString("apellidos"));
					p.setDNI(rs.getString("dNI"));
					p.setSexo(rs.getString("sexo"));
				u.setPersona(p);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return u;
	}
}
