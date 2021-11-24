package Datos.Articulos;

import Datos.Conexion.Conexion;
import Recursos.Clases.Articulos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticulosDatos {
    public static String InsertarArticulo(Articulos pArticulo)throws SQLException {
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Articulos VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,pArticulo.getID());
            ps.setString(2,pArticulo.getMaterial());
            ps.setString(3,pArticulo.getCategoria());
            ps.setString(4,pArticulo.getEstilo());
            ps.setString(5,pArticulo.getColor());
            ps.setString(6,pArticulo.getTamanio());
            ps.setString(7,pArticulo.getMarca());
            ps.setLong(8,pArticulo.getNoLote());
            ps.execute();
            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Articulos> LeerArticulo() throws SQLException{
        List<Articulos> articulosList = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql    = "SELECT ID,Material,Categoria,Estilo,Color,Tamaño,Marca,NoLote FROM Articulos ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Articulos articulo = new Articulos();
                articulo.setID(rs.getInt(1));
                articulo.setMaterial(rs.getString(2));
                articulo.setCategoria(rs.getString(3));
                articulo.setEstilo(rs.getString(4));
                articulo.setColor(rs.getString(5));
                articulo.setTamanio(rs.getString(6));
                articulo.setMarca(rs.getString(7));
                articulo.setNoLote(rs.getLong(8));
                articulosList.add(articulo);
            }
            rs.close();
            st.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return articulosList;
    }
    public static String ActualizarArticulo(Articulos pArticulo) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Articulos SET Material = ?,Categoria = ?,Estilo = ?,Color = ?,Tamaño= ?,Marca = ?,NoLote = ? WHERE ID = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,pArticulo.getMaterial());
            ps.setString(2,pArticulo.getCategoria());
            ps.setString(3,pArticulo.getEstilo());
            ps.setString(4,pArticulo.getColor());
            ps.setString(5,pArticulo.getTamanio());
            ps.setString(6,pArticulo.getMarca());
            ps.setLong(7,pArticulo.getNoLote());
            ps.setInt(8,pArticulo.getID());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static String EliminarArticulo(Articulos pArticulo)throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Articulos WHERE ID = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,pArticulo.getID());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Articulos> BuscarArticulo(Articulos pArticulo)throws SQLException{
        List<Articulos> articulosList = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT ID,Material,Categoria,Estilo,Color,Tamaño,Marca,NoLote FROM Articulos WHERE UPPER(Categoria) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,"%"+ pArticulo.getCategoria() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Articulos articulo = new Articulos();
                    articulo.setID(rs.getInt(1));
                    articulo.setMaterial(rs.getString(2));
                    articulo.setCategoria(rs.getString(3));
                    articulo.setEstilo(rs.getString(4));
                    articulo.setColor(rs.getString(5));
                    articulo.setTamanio(rs.getString(6));
                    articulo.setMarca(rs.getString(7));
                    articulo.setNoLote(rs.getLong(8));;
                    articulosList.add(articulo);
                }while(rs.next());
            }else{
                throw new SQLException("Error no se ha encontrado Concidenia");
            }
            rs.close();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return articulosList;
    }
}
