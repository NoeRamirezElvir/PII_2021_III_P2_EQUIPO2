package Datos.Terreno;

import Datos.Conexion.Conexion;
import Recursos.Clases.Terreno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TerrenoDatos {
    public static String insertarTerreno(Terreno terreno)throws SQLException{
        try{
            Connection cn= Conexion.obtenerConexion();
            String sql="INSERT INTO Terreno VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,terreno.getID());
            ps.setString(2,terreno.getDimension());
            ps.setString(3,terreno.getTipoSuelo());
            ps.setString(4,terreno.getOrientacionTerreno());
            ps.setString(5,terreno.getTipoServicios());
            ps.setString(6,terreno.getCategoria());
            ps.setString(7,terreno.getAltitud());
            ps.setString(8,terreno.getTipoUso());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Terreno> leerTerrenos()throws SQLException{
        List<Terreno> listaTerrenos=new ArrayList<>();
        try{
            Connection cn= Conexion.obtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT ID, Dimension, TipoSuelo, OrientacionTerreno, TipoServicios, Categoria, Altitud, TipoUso FROM Terreno";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Terreno terreno = new Terreno();
                terreno.setID(rs.getInt(1));
                terreno.setDimension(rs.getString(2));
                terreno.setTipoSuelo(rs.getString(3));
                terreno.setOrientacionTerreno(rs.getString(4));
                terreno.setTipoServicios(rs.getString(5));
                terreno.setCategoria(rs.getString(6));
                terreno.setAltitud(rs.getString(7));
                terreno.setTipoUso(rs.getString(8));
                listaTerrenos.add(terreno);
            }
            rs.close();
            st.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaTerrenos;
    }
    public static String actualizarTerreno(Terreno terreno)throws SQLException{
        try{
            Connection cn= Conexion.obtenerConexion();
            String sql="UPDATE Terreno SET Dimension = ?, TipoSuelo = ?, OrientacionTerreno = ?, TipoServicios = ?, Categoria = ?, Altitud = ?, TipoUso = ? WHERE ID = ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,terreno.getDimension());
            ps.setString(2,terreno.getTipoSuelo());
            ps.setString(3,terreno.getOrientacionTerreno());
            ps.setString(4,terreno.getTipoServicios());
            ps.setString(5,terreno.getCategoria());
            ps.setString(6,terreno.getAltitud());
            ps.setString(7,terreno.getTipoUso());
            ps.setInt(8,terreno.getID());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static String eliminarTerreno(Terreno terreno)throws SQLException{
        try{
            Connection cn= Conexion.obtenerConexion();
            String sql="DELETE FROM Terreno WHERE ID = ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,terreno.getID());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Terreno> buscarTerreno(Terreno pTerreno)throws SQLException{
        List<Terreno> listaTerreno = new ArrayList<>();
        try{
            Connection cn= Conexion.obtenerConexion();
            String sql="SELECT ID, Dimension, TipoSuelo, OrientacionTerreno, TipoServicios, Categoria, Altitud, TipoUso FROM Terreno WHERE UPPER(TipoSuelo) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,"%" + pTerreno.getTipoSuelo() + "%");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                do{
                    Terreno terreno = new Terreno();
                    terreno.setID(rs.getInt(1));
                    terreno.setDimension(rs.getString(2));
                    terreno.setTipoSuelo(rs.getString(3));
                    terreno.setOrientacionTerreno(rs.getString(4));
                    terreno.setTipoServicios(rs.getString(5));
                    terreno.setCategoria(rs.getString(6));
                    terreno.setAltitud(rs.getString(7));
                    terreno.setTipoUso(rs.getString(8));
                    listaTerreno.add(terreno);
                }while(rs.next());
            }else{
                throw new SQLException("Error: No se encontro coincidencia.");
            }
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaTerreno;
    }

}
