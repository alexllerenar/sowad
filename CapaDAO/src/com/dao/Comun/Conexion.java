package com.dao.Comun;
import java.sql.*;
public class Conexion {
	//Singleton
	public static Conexion _Instancia;
	private Conexion(){};
	public static Conexion Instancia(){
		if(_Instancia==null){
			_Instancia = new Conexion();
		}
		return _Instancia;
	}
	//endSingleton	
	
	public Connection Conectar() throws Exception{
		Connection cn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+
						"databaseName=ERP_Comercial", "sa", "123456");
		} catch (Exception e) {
			throw e;
		}
		return cn;
	}
}


