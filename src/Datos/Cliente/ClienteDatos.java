package Datos.Cliente;

import Datos.Conexion.Conexion;
import Recursos.Clases.Cliente;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDatos {
    public static String insertarCliente(Cliente pCliente) throws SQLException{
        try{
            Connection cn= Conexion.obtenerConexion();
            String sql="INSERT INTO Clientes VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setLong(1,pCliente.getDNI());
            ps.setInt(2,pCliente.getCodigo());
            ps.setString(3,pCliente.getCategoria());
            ps.setDate(4,new java.sql.Date(pCliente.getFechaIngreso().getTime()));
            ps.setDouble(5,pCliente.getSaldo());
            ps.setString(6,pCliente.getCorreoElectronico());
            ps.setString(7,pCliente.getOcupacion());
            ps.setString(8,pCliente.getTipoMembresia());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
           //JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    public static List<Cliente> leerClientes()throws SQLException{
        List<Cliente> listaClientes = new ArrayList<>();
        try{
            Connection cn=Conexion.obtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT DNI, Codigo, Categoria, FechaIngreso, Saldo, CorreoElectronico, Ocupacion, TipoMembresia FROM Clientes";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setDNI(rs.getLong(1));
                cliente.setCodigo(rs.getInt(2));
                cliente.setCategoria(rs.getString(3));
                cliente.setFechaIngreso(rs.getDate(4));
                cliente.setSaldo(rs.getDouble(5));
                cliente.setCorreoElectronico(rs.getString(6));
                cliente.setOcupacion(rs.getString(7));
                cliente.setTipoMembresia(rs.getString(8));
                listaClientes.add(cliente);
            }
            rs.close();
            st.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
            //JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return listaClientes;
    }
    public static String actualizarCliente(Cliente pCliente)throws SQLException{
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql="UPDATE Clientes SET Codigo = ?, Categoria = ?, FechaIngreso = ?, Saldo = ?, CorreoElectronico = ?, Ocupacion = ?, TipoMembresia = ? WHERE DNI = ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,pCliente.getCodigo());
            ps.setString(2,pCliente.getCategoria());
            ps.setDate(3,new java.sql.Date(pCliente.getFechaIngreso().getTime()));
            ps.setDouble(4,pCliente.getSaldo());
            ps.setString(5,pCliente.getCorreoElectronico());
            ps.setString(6,pCliente.getOcupacion());
            ps.setString(7,pCliente.getTipoMembresia());
            ps.setLong(8,pCliente.getDNI());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static String eliminarCliente(Cliente pCliente)throws SQLException{
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql="DELETE FROM Clientes WHERE Codigo = ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setLong(1,pCliente.getCodigo());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Cliente> buscarCliente(Cliente pCliente)throws SQLException{
        List<Cliente> listaClientes = new ArrayList<>();
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql = "SELECT DNI, Codigo, Categoria, FechaIngreso, Saldo, CorreoElectronico, Ocupacion, TipoMembresia FROM Clientes WHERE UPPER(CorreoElectronico) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,"%" + pCliente.getCorreoElectronico().toUpperCase() + "%");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                do{
                    Cliente cliente = new Cliente();
                    cliente.setDNI(rs.getLong(1));
                    cliente.setCodigo(rs.getInt(2));
                    cliente.setCategoria(rs.getString(3));
                    cliente.setFechaIngreso(rs.getDate(4));
                    cliente.setSaldo(rs.getDouble(5));
                    cliente.setCorreoElectronico(rs.getString(6));
                    cliente.setOcupacion(rs.getString(7));
                    cliente.setTipoMembresia(rs.getString(8));
                    listaClientes.add(cliente);
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
        return listaClientes;
    }
}
