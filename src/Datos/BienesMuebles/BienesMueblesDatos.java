package Datos.BienesMuebles;

import Datos.Conexion.Conexion;
import Recursos.Clases.BienesMuebles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BienesMueblesDatos {
    public static String InsertarBienMueble(BienesMuebles pBienMueble)throws SQLException {
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO BienesMuebles VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,pBienMueble.getID());
            ps.setString(2,pBienMueble.getDescripcion());
            ps.setDouble(3,pBienMueble.getPrecio());
            ps.setDouble(4,pBienMueble.getPeso());
            ps.setDate(5,new java.sql.Date(pBienMueble.getFechaIngreso().getTime()));
            ps.setInt(6,pBienMueble.getGarantia());
            ps.execute();
            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<BienesMuebles> LeerBienMueble() throws SQLException{
        List<BienesMuebles> listaBienesMuebles = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql    = "SELECT ID,Descripcion,Precio,Peso,FechaIngreso,Garantia FROM BienesMuebles ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                BienesMuebles bienMueble = new BienesMuebles();
                bienMueble.setID(rs.getInt(1));
                bienMueble.setDescripcion(rs.getString(2));
                bienMueble.setPrecio(rs.getDouble(3));
                bienMueble.setPeso(rs.getDouble(4));
                bienMueble.setFechaIngreso(rs.getDate(5));
                bienMueble.setGarantia(rs.getInt(6));
                listaBienesMuebles.add(bienMueble);
            }
            rs.close();
            st.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaBienesMuebles;
    }
    public static String ActualizarBienMueble(BienesMuebles pBienMueble) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE BienesMuebles SET Descripcion = ?,Precio = ?,Peso = ?,FechaIngreso = ?,Garantia = ? WHERE ID = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,pBienMueble.getDescripcion());
            ps.setDouble(2,pBienMueble.getPrecio());
            ps.setDouble(3,pBienMueble.getPeso());
            ps.setDate(4,new java.sql.Date(pBienMueble.getFechaIngreso().getTime()));
            ps.setInt(5,pBienMueble.getGarantia());
            ps.setInt(6,pBienMueble.getID());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static String EliminarBienMueble(BienesMuebles pBienMueble)throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM BienesMuebles WHERE ID = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,pBienMueble.getID());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<BienesMuebles> BuscarBienMueble(BienesMuebles pBienMueble)throws SQLException{
        List<BienesMuebles> bienesMueblesList = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT ID,Descripcion,Precio,Peso,FechaIngreso,Garantia FROM BienesMuebles WHERE UPPER(Descripcion) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,"%"+ pBienMueble.getDescripcion() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    BienesMuebles bienesMueble = new BienesMuebles();
                    bienesMueble.setID(rs.getInt(1));
                    bienesMueble.setDescripcion(rs.getString(2));
                    bienesMueble.setPrecio(rs.getDouble(3));
                    bienesMueble.setPeso(rs.getDouble(4));
                    bienesMueble.setFechaIngreso(rs.getDate(5));
                    bienesMueble.setGarantia(rs.getInt(6));
                    bienesMueblesList.add(bienesMueble);
                }while(rs.next());
            }else{
                throw new SQLException("Error no se ha encontrado Concidecia");
            }
            rs.close();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return bienesMueblesList;
    }
}
