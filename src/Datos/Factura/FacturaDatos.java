package Datos.Factura;
import Datos.Conexion.Conexion;
import Recursos.Clases.Factura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDatos {
    public static String insertarFactura(Factura factura)throws SQLException{
        try{
            Connection cn= Conexion.obtenerConexion();
            String sql="INSERT INTO Factura VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,factura.getCodigo());
            ps.setDate(2,new java.sql.Date(factura.getFecha().getTime()));
            ps.setString(3,factura.getCliente());
            ps.setString(4,factura.getEmpleado());
            ps.setString(5,factura.getProducto());
            ps.setDouble(6,factura.getTotal());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Factura> leerFactura()throws SQLException{
        List<Factura> listaFactura = new ArrayList<>();
        try{
            Connection cn=Conexion.obtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT Codigo, Fecha, NombreCliente, NombreEmpleado, NombreProducto, Total FROM Factura";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Factura factura = new Factura();
                factura.setCodigo(rs.getInt(1));
                factura.setFecha(rs.getDate(2));
                factura.setCliente(rs.getString(3));
                factura.setEmpleado(rs.getString(4));
                factura.setProducto(rs.getString(5));
                factura.setTotal(rs.getDouble(6));
                listaFactura.add(factura);
            }
            rs.close();
            st.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaFactura;
    }
    public static String actualizarFactura(Factura factura)throws SQLException{
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql="UPDATE Factura Fecha = ?,NombreCliente = ?, NombreEmpleado = ?, NombreProducto = ?, Total = ? WHERE Codigo = ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setDate(1,new java.sql.Date(factura.getFecha().getTime()));
            ps.setString(2,factura.getCliente());
            ps.setString(3,factura.getEmpleado());
            ps.setString(4,factura.getProducto());
            ps.setDouble(5,factura.getTotal());
            ps.setInt(6,factura.getCodigo());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static String eliminarFactura(Factura factura)throws SQLException{
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql="DELETE FROM Factura WHERE Codigo = ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(2,factura.getCodigo());

            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Factura> buscarFactura(Factura pFactura)throws SQLException{
        List<Factura> listaFactura = new ArrayList<>();
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql="SELECT Codigo, Fecha, NombreCliente, NombreEmpleado, NombreProducto, Total FROM Factura WHERE UPPER(NombreCliente) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,"%" + pFactura.getCliente().toUpperCase() + "%");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                do{
                    Factura factura = new Factura();
                    factura.setCodigo(rs.getInt(1));
                    factura.setFecha(rs.getDate(2));
                    factura.setCliente(rs.getString(3));
                    factura.setEmpleado(rs.getString(4));
                    factura.setProducto(rs.getString(5));
                    factura.setTotal(rs.getDouble(6));
                    listaFactura.add(factura);

                }while(rs.next());
            } else{
                throw new SQLException("Error: No se encontro coincidencia.");
            }
            rs.close();
            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaFactura;
    }
}
