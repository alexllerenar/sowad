package com.dao.Comun;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ent.Comun.*;

public class CMM_PersonaDao {
	//Singleton
	public static CMM_PersonaDao _Instancia;
	private CMM_PersonaDao(){};
	public static CMM_PersonaDao Instancia(){
		if(_Instancia==null){
			_Instancia = new CMM_PersonaDao();
		}
		return _Instancia;
	}
	//endSingleton
	
	public ArrayList<CMM_PersonaEnt> ListarPersona() throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		ArrayList<CMM_PersonaEnt> lista = new ArrayList<CMM_PersonaEnt>();
		try {
			CallableStatement cst = cn.prepareCall("{call spCMM_ListarPersona()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				CMM_PersonaEnt p = new CMM_PersonaEnt();
				p.setIdPersona(rs.getInt("idPersona"));
				p.setNombres(rs.getString("Nombres"));
				p.setApellidos(rs.getString("Apellidos"));
				p.setDNI(rs.getString("DNI"));
				p.setDireccion(rs.getString("Direccion"));
				p.setTelefono(rs.getString("Telefono"));
				p.setFechaNacimiento(rs.getString("fechaNacimiento"));
				p.setSexo(rs.getString("Sexo"));
				lista.add(p);
			}
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return lista;
	}

	public boolean InsertarPersona(CMM_PersonaEnt p, String Usuario) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call spCMM_InsertarPersona(?,?,?,?,?,?,?,?)}");
			cst.setString(1, p.getNombres());
			cst.setString(2, p.getApellidos());
			cst.setString(3, p.getDNI());
			cst.setString(4, p.getDireccion());
			cst.setString(5, p.getTelefono());
			cst.setString(6, p.getFechaNacimiento());
			cst.setString(7, p.getSexo());
			cst.setString(8, Usuario);
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
	}
		
	public CMM_PersonaEnt DevolverPersona(int idPersona) throws Exception{
		Connection cn = Conexion.Instancia().Conectar();
		CMM_PersonaEnt p = null;
		try {
			CallableStatement cst = cn.prepareCall("{call spCMM_DevolverPersona(?)}");
			cst.setInt(1, idPersona);
			ResultSet rs = cst.executeQuery();
			if(rs.next()){
				p = new CMM_PersonaEnt();
				p.setIdPersona(rs.getInt("idPersona"));
				p.setNombres(rs.getString("Nombres"));
				p.setApellidos(rs.getString("Apellidos"));
				p.setDNI(rs.getString("DNI"));
				p.setDireccion(rs.getString("Direccion"));
				p.setTelefono(rs.getString("Telefono"));
				p.setFechaNacimiento(rs.getString("fechaNacimiento"));
				p.setSexo(rs.getString("Sexo"));				
			}
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return p;
	}

	public boolean EditarPersona(CMM_PersonaEnt p, String Usuario) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean edito = false;
		try {
			CallableStatement cst = cn.prepareCall("{call spCMM_EditarPersona(?,?,?,?,?,?,?,?,?)}");
			cst.setInt(1, p.getIdPersona());
			cst.setString(2, p.getNombres());
			cst.setString(3, p.getApellidos());
			cst.setString(4, p.getDNI());
			cst.setString(5, p.getDireccion());
			cst.setString(6, p.getTelefono());
			cst.setString(7, p.getFechaNacimiento());
			cst.setString(8, p.getSexo());
			cst.setString(9, Usuario);
			int i = cst.executeUpdate();
			if(i>0){ edito = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return edito;
	}
}
