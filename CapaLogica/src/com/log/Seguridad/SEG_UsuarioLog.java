package com.log.Seguridad;

import org.omg.CORBA.portable.ApplicationException;

import com.dao.Seguridad.*;
import com.ent.Seguridad.*;

public class SEG_UsuarioLog {
	//Singleton
	public static SEG_UsuarioLog _Instancia;
	private SEG_UsuarioLog(){};
	public static SEG_UsuarioLog Instancia(){
		if(_Instancia==null){
			_Instancia = new SEG_UsuarioLog();
		}
		return _Instancia;
	}
	//endSingleton
	
	public SEG_UsuarioEnt VerificarAcceso(String _Login, String _Passw) throws Exception{
		try {
			SEG_UsuarioEnt u =SEG_UsuarioDao.Instancia().VerificarAcceso(_Login, _Passw);
			if(u==null){
				throw new Exception("USuario o PAssword no Validop");	
			}else{
				if(!u.getActivo()){
					throw new Exception("USuario fue dado de baja");
				}				
			}
			return u;
		} catch (Exception e) {
			throw e;
		}
	}
}
