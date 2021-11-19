package Datos.Persona;

import Datos.Conexion.Conexion;
import Recursos.Clases.Persona;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDatos {
    public static String insertarPersona(Persona pPersona) throws SQLException{
        try{
            Connection cn= Conexion.obtenerConexion();
            String sql = "INSERT INTO Personas VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setLong(1, pPersona.getDNI());
            ps.setString(2,pPersona.getNombre());
            ps.setString(3,pPersona.getApellido());
            ps.setInt(4,pPersona.getEdad());
            ps.setString(5,pPersona.getDireccion());
            ps.setString(6,pPersona.getGenero());
            ps.setLong(7,pPersona.getTelefono());
            ps.execute();
            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
            //JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    public static List<Persona> leerPersona() throws SQLException{
        List<Persona> listaPersona = new ArrayList<>();
        try{
            Connection cn=Conexion.obtenerConexion();
            Statement st=cn.createStatement();
            String sql = "SELECT DNI, Nombre, Apellido, Edad, Direccion, Genero, Telefono FROM Personas";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Persona persona = new Persona();
                persona.setDNI(rs.getLong(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido(rs.getString(3));
                persona.setEdad(rs.getInt(4));
                persona.setDireccion(rs.getString(5));
                persona.setGenero(rs.getString(6));
                persona.setTelefono(rs.getLong(7));
                listaPersona.add(persona);
            }
            cn.close();
            rs.close();
            st.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaPersona;
    }
    public static String actualizarPersona(Persona pPersona)throws SQLException{
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql="UPDATE Personas SET Nombre = ?, Apellido = ?, Edad = ?, Direccion = ?, Genero = ?, Telefono = ? WHERE DNI = ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,pPersona.getNombre());
            ps.setString(2,pPersona.getApellido());
            ps.setInt(3,pPersona.getEdad());
            ps.setString(4,pPersona.getDireccion());
            ps.setString(5,pPersona.getGenero());
            ps.setLong(6,pPersona.getTelefono());
            ps.setLong(7,pPersona.getDNI());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static String eliminarPersona(Persona pPersona) throws SQLException{
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql="DELETE FROM Personas WHERE DNI = ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setLong(1,pPersona.getDNI());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Persona> buscarPersona(Persona pPersona) throws SQLException{
        List<Persona> listaPersonas = new ArrayList<>();
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql = "SELECT DNI, Nombre, Apellido, Edad, Direccion, Genero, Telefono FROM Personas WHERE UPPER(Nombre) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,"%" + pPersona.getNombre().toUpperCase() + "%");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                do {
                    Persona persona = new Persona();
                    persona.setDNI(rs.getLong(1));
                    persona.setNombre(rs.getString(2));
                    persona.setApellido(rs.getString(3));
                    persona.setEdad(rs.getInt(4));
                    persona.setDireccion(rs.getString(5));
                    persona.setGenero(rs.getString(6));
                    persona.setTelefono(rs.getLong(7));
                    listaPersonas.add(persona);
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
        return listaPersonas;
    }

}
