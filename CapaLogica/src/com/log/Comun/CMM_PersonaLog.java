package com.log.Comun;

import java.util.ArrayList;

import com.dao.Comun.*;
import com.ent.Comun.*;

public class CMM_PersonaLog {
	//Singleton
	public static CMM_PersonaLog _Instancia;
	private CMM_PersonaLog(){};
	public static CMM_PersonaLog Instancia(){
		if(_Instancia==null){
			_Instancia = new CMM_PersonaLog();
		}
		return _Instancia;
	}
	//endSingleton
	
	public ArrayList<CMM_PersonaEnt> ListarPersona() throws Exception{	
		try {
			return CMM_PersonaDao.Instancia().ListarPersona();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean InsertarPersona(CMM_PersonaEnt p, String Usuario) throws Exception{	
		try {
			return CMM_PersonaDao.Instancia().InsertarPersona(p, Usuario);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public CMM_PersonaEnt DevolverPersona(int idPersona) throws Exception{
		try {
			return CMM_PersonaDao.Instancia().DevolverPersona(idPersona);
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean EditarPersona(CMM_PersonaEnt p, String Usuario) throws Exception{	
		try {
			return CMM_PersonaDao.Instancia().EditarPersona(p, Usuario);
		} catch (Exception e) {
			throw e;
		}
	}
}
