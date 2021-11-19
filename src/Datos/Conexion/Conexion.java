package Datos.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String USUARIO = "sa";
    private static final String CLAVE = "Ujcv.2021";

    public static Connection obtenerConexion(){
        try{
            String URL = "jdbc:sqlserver://192.168.0.13:1433;dataBaseName=Proyecto;";
            Connection cn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            return cn;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
