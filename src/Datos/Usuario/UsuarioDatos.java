package Datos.Usuario;

import Datos.Conexion.Conexion;
import Recursos.Clases.Usuario;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDatos {
    public static String crearUsuario(Usuario pUsuario) throws SQLException {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Usuarios VALUES(?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1,pUsuario.getNumeroCuenta());
            ps.setString(2,pUsuario.getNombre());
            ps.setString(3, pUsuario.getClave());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Usuario> buscarUsuario(Usuario pUsuario)throws SQLException{
        List<Usuario> listaUsuario = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql="SELECT NumeroCUenta, Nombre, Clave FROM Usuarios WHERE UPPER(Nombre) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,"%" + pUsuario.getNombre().toUpperCase() + "%");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                do{
                    Usuario usuario = new Usuario();
                    usuario.setNumeroCuenta(rs.getLong(1));
                    usuario.setNombre(rs.getString(2));
                    usuario.setClave(rs.getString(3));
                    listaUsuario.add(usuario);
                }while(rs.next());
            }
            cn.close();
            rs.close();
            ps.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaUsuario;
    }
}
