package Datos.Casa;

import Datos.Conexion.Conexion;
import Recursos.Clases.Casa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CasaDatos {
    public static String insertarCasa(Casa casa)throws SQLException{
        try{
            Connection cn= Conexion.obtenerConexion();
            String sql = "INSERT INTO Casa VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,casa.getID());
            ps.setInt(2,casa.getNumeroHabitaciones());
            ps.setInt(3,casa.getNumeroPlantas());
            ps.setString(4,casa.getServiciosBasicos());
            ps.setString(5,casa.getColor());
            ps.setString(6, casa.getMaterial());
            ps.setString(7,casa.getPropietario());
            ps.setString(8,casa.getTipo());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Casa> leerCasas()throws SQLException{
        List<Casa> listaCasas=new ArrayList<>();
        try{
            Connection cn=Conexion.obtenerConexion();
            Statement st=cn.createStatement();
            String sql = "SELECT ID, NumeroHabitaciones, NumeroPlantas, ServiciosBasicos, Color, Material, Propietario,Tipo FROM Casa";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Casa casa= new Casa();
                casa.setID((rs.getInt(1)));
                casa.setNumeroHabitaciones(rs.getInt(2));
                casa.setNumeroPlantas(rs.getInt(3));
                casa.setServiciosBasicos(rs.getString(4));
                casa.setColor(rs.getString(5));
                casa.setMaterial(rs.getString(6));
                casa.setPropietario(rs.getString(7));
                casa.setTipo(rs.getString(8));
                listaCasas.add(casa);
            }
            rs.close();
            st.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaCasas;
    }
    public static String actualizarCasa(Casa casa)throws SQLException{
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql="UPDATE Casa SET NumeroHabitaciones = ?, NumeroPlantas = ?, ServiciosBasicos = ?, Color = ?, Material = ?, Propietario = ?, Tipo = ? WHERE ID = ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,casa.getNumeroHabitaciones());
            ps.setInt(2,casa.getNumeroPlantas());
            ps.setString(3,casa.getServiciosBasicos());
            ps.setString(4,casa.getColor());
            ps.setString(5,casa.getMaterial());
            ps.setString(6,casa.getPropietario());
            ps.setString(7,casa.getTipo());
            ps.setInt(8,casa.getID());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static String eliminarCasa(Casa casa)throws SQLException{
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql = "DELETE FROM Casa WHERE ID = ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,casa.getID());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Casa> buscarCasa(Casa casas)throws SQLException{
        List<Casa> listaCasas=new ArrayList<>();
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql = "SELECT ID, NumeroHabitaciones, NumeroPlantas, ServiciosBasicos, Color, Material, Propietario, Tipo FROM Casa WHERE UPPER(Propietario) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,"%" +  casas.getPropietario() + "%");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                do{
                    Casa casa= new Casa();
                    casa.setID((rs.getInt(1)));
                    casa.setNumeroHabitaciones(rs.getInt(2));
                    casa.setNumeroPlantas(rs.getInt(3));
                    casa.setServiciosBasicos(rs.getString(4));
                    casa.setColor(rs.getString(5));
                    casa.setMaterial(rs.getString(6));
                    casa.setPropietario(rs.getString(7));
                    casa.setTipo(rs.getString(8));
                    listaCasas.add(casa);
                }while(rs.next());
            }else{
                throw new SQLException("Error: No se encontro coincidencia.");
            }
            rs.close();
            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaCasas;
    }

}
