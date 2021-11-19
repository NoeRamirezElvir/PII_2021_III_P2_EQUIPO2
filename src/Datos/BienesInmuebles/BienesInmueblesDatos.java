package Datos.BienesInmuebles;

import Datos.Conexion.Conexion;
import Recursos.Clases.BienesInmuebles;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BienesInmueblesDatos {
    public static String insertarInmueble(BienesInmuebles inmueble)throws SQLException{
        try{
            Connection cn= Conexion.obtenerConexion();
            String sql="INSERT INTO BienesInmuebles VALUES(?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,inmueble.getID());
            ps.setDouble(2,inmueble.getPrecioVenta());
            ps.setDouble(3,inmueble.getPrecioRenta());
            ps.setString(4,inmueble.getDescripcion());
            ps.setString(5,inmueble.getDireccion());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<BienesInmuebles> leerInmuebles()throws SQLException{
        List<BienesInmuebles> listaInmuebles = new ArrayList<>();
        try{
            Connection cn=Conexion.obtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT ID,PrecioVenta,PrecioRenta,Descripcion,Direccion FROM BienesInmuebles";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                BienesInmuebles inmuebles = new BienesInmuebles();
                inmuebles.setID(rs.getInt(1));
                inmuebles.setPrecioVenta(rs.getDouble(2));
                inmuebles.setPrecioRenta(rs.getDouble(3));
                inmuebles.setDescripcion(rs.getString(4));
                inmuebles.setDireccion(rs.getString(5));
                listaInmuebles.add(inmuebles);
            }
            st.close();
            rs.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaInmuebles;
    }
    public static String actualizarInmueble(BienesInmuebles inmuebles)throws SQLException{
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql= ("UPDATE BienesInmuebles SET PrecioVenta = ?, PrecioRenta = ?, Descripcion = ?, Direccion = ? WHERE ID = ?");
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setDouble(1,inmuebles.getPrecioVenta());
            ps.setDouble(2,inmuebles.getPrecioRenta());
            ps.setString(3,inmuebles.getDescripcion());
            ps.setString(4,inmuebles.getDireccion());
            ps.setInt(5,inmuebles.getID());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static String eliminarInmueble(BienesInmuebles inmuebles)throws SQLException{
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql="DELETE FROM BienesInmuebles WHERE ID = ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,inmuebles.getID());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<BienesInmuebles> buscarInmueble(BienesInmuebles pInmuebles)throws SQLException{
        List<BienesInmuebles> listaInmuebles = new ArrayList<>();
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql="SELECT ID, PrecioVenta, PrecioRenta, Descripcion, Direccion FROM BienesInmuebles WHERE UPPER(Descripcion) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,"%" + pInmuebles.getDescripcion().toUpperCase() + "%");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                do{
                    BienesInmuebles inmuebles=new BienesInmuebles();
                    inmuebles.setID(rs.getInt(1));
                    inmuebles.setPrecioVenta(rs.getDouble(2));
                    inmuebles.setPrecioRenta(rs.getDouble(3));
                    inmuebles.setDescripcion(rs.getString(4));
                    inmuebles.setDireccion(rs.getString(5));
                    listaInmuebles.add(inmuebles);
                }while(rs.next());
            }
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaInmuebles;
    }
}
