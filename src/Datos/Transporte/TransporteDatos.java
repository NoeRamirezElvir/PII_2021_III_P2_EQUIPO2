package Datos.Transporte;

import Datos.Conexion.Conexion;
import Recursos.Clases.Transporte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransporteDatos {
    public static String InsertarElectrodomestico(Transporte pElectrodomestico)throws SQLException {
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Transporte1 VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,pElectrodomestico.getID());
            ps.setString(2,pElectrodomestico.getNombre());
            ps.setString(3,pElectrodomestico.getMarca());
            ps.setString(4,pElectrodomestico.getModelo());
            ps.setInt(5,pElectrodomestico.getCapacidad());
            ps.setInt(6,pElectrodomestico.getNoEjes());
            ps.setInt(7,pElectrodomestico.getCaballosFuerza());
            ps.setString(8,pElectrodomestico.getLugarFabricacion());
            ps.execute();
            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Transporte> LeerElectrodomestico() throws SQLException{
        List<Transporte> electrodomesticosList = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql    = "SELECT ID,Nombre,Marca,Modelo,Capacidad,NoEjes,CaballosFuerza,LugarFabricacion FROM Transporte1 ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Transporte electrodomestico = new Transporte();
                electrodomestico.setID(rs.getInt(1));
                electrodomestico.setNombre(rs.getString(2));
                electrodomestico.setMarca(rs.getString(3));
                electrodomestico.setModelo(rs.getString(4));
                electrodomestico.setCapacidad(rs.getInt(5));
                electrodomestico.setNoEjes(rs.getInt(6));
                electrodomestico.setCaballosFuerza(rs.getInt(7));
                electrodomestico.setLugarFabricacion(rs.getString(8));
                electrodomesticosList.add(electrodomestico);
            }
            rs.close();
            st.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return electrodomesticosList;
    }
    public static String ActualizarElectrodomestico(Transporte pElectrodomestico) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Transporte1 SET Nombre = ?,Marca = ?,Modelo = ?,Capacidad = ?,NoEjes = ?,CaballosFuerza = ?,LugarFabricacion = ? WHERE ID = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,pElectrodomestico.getNombre());
            ps.setString(2,pElectrodomestico.getMarca());
            ps.setString(3,pElectrodomestico.getModelo());
            ps.setInt(4,pElectrodomestico.getCapacidad());
            ps.setInt(5,pElectrodomestico.getNoEjes());
            ps.setInt(6,pElectrodomestico.getCaballosFuerza());
            ps.setString(7,pElectrodomestico.getLugarFabricacion());
            ps.setInt(8,pElectrodomestico.getID());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static String EliminarElectrodomestico(Transporte pElectrodomestico)throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Transporte1 WHERE ID = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,pElectrodomestico.getID());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Transporte> BuscarElectrodomestico(Transporte pElectrodomestico)throws SQLException  {
        List<Transporte> electrodomesticosList = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT ID,Nombre,Marca,Modelo,Capacidad,NoEjes,CaballosFuerza,LugarFabricacion FROM Transporte1 WHERE UPPER(Nombre) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,"%"+ pElectrodomestico.getNombre() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Transporte electrodomestico = new Transporte();
                    electrodomestico.setID(rs.getInt(1));
                    electrodomestico.setNombre(rs.getString(2));
                    electrodomestico.setMarca(rs.getString(3));
                    electrodomestico.setModelo(rs.getString(4));
                    electrodomestico.setCapacidad(rs.getInt(5));
                    electrodomestico.setNoEjes(rs.getInt(6));
                    electrodomestico.setCaballosFuerza(rs.getInt(7));
                    electrodomestico.setLugarFabricacion(rs.getString(8));
                    electrodomesticosList.add(electrodomestico);
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
        return electrodomesticosList;
    }
}
