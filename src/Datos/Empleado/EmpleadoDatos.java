package Datos.Empleado;

import Datos.Conexion.Conexion;
import Recursos.Clases.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDatos {
    public static String insertarEmpleado(Empleado pEmpleado)throws SQLException{
        try{
            Connection cn= Conexion.obtenerConexion();
            String sql="INSERT INTO Empleados VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setLong(1,pEmpleado.getDNI());
            ps.setInt(2,pEmpleado.getCodigo());
            ps.setDate(3,new java.sql.Date(pEmpleado.getFechaIngreso().getTime()));
            ps.setString(4,pEmpleado.getCargo());
            ps.setDouble(5,pEmpleado.getSueldo());
            ps.setString(6,pEmpleado.getHorario());
            ps.setString(7,pEmpleado.getCorreoElectronico());
            ps.setString(8,pEmpleado.getDepartamento());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Empleado> leerEmpleado() throws SQLException{
        List<Empleado> listaEmpleado = new ArrayList<>();
        try{
            Connection cn=Conexion.obtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT DNI,Codigo,FechaIngreso,Cargo,Sueldo,Horario,CorreoElectronico,Departamento FROM Empleados";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Empleado empleado = new Empleado();
                empleado.setDNI(rs.getLong(1));
                empleado.setCodigo(rs.getInt(2));
                empleado.setFechaIngreso(rs.getDate(3));
                empleado.setCargo(rs.getString(4));
                empleado.setSueldo(rs.getDouble(5));
                empleado.setHorario(rs.getString(6));
                empleado.setCorreoElectronico(rs.getString(7));
                empleado.setDepartamento(rs.getString(8));
                listaEmpleado.add(empleado);
            }
            rs.close();
            st.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaEmpleado;
    }
    public static String actualizarEmpleado(Empleado empleado)throws SQLException{
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql = "UPDATE Empleados SET Codigo=?,FechaIngreso=?,Cargo=?,Sueldo=?,Horario=?,CorreoElectronico=?,Departamento=? WHERE DNI=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,empleado.getCodigo());
            ps.setDate(2,new java.sql.Date(empleado.getFechaIngreso().getTime()));
            ps.setString(3,empleado.getCargo());
            ps.setDouble(4,empleado.getSueldo());
            ps.setString(5,empleado.getHorario());
            ps.setString(6,empleado.getCorreoElectronico());
            ps.setString(7,empleado.getDepartamento());
            ps.setLong(8,empleado.getDNI());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static String eliminarEmpleado(Empleado empleado)throws SQLException{
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql="DELETE FROM Empleados WHERE Codigo = ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,empleado.getCodigo());
            ps.execute();

            ps.close();
            cn.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Empleado> buscarEmpleado(Empleado empleado)throws SQLException{
        List<Empleado> listaEmpleado = new ArrayList<>();
        try{
            Connection cn=Conexion.obtenerConexion();
            String sql="SELECT DNI, Codigo, FechaIngreso, Cargo, Sueldo, Horario, CorreoElectronico, Departamento FROM Empleados WHERE UPPER(CorreoElectronico) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,"%" + empleado.getCorreoElectronico().toUpperCase() + "%");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                do{
                    Empleado emplead = new Empleado();
                    emplead.setDNI(rs.getLong(1));
                    emplead.setCodigo(rs.getInt(2));
                    emplead.setFechaIngreso(rs.getDate(3));
                    emplead.setCargo(rs.getString(4));
                    emplead.setSueldo((rs.getDouble(5)));
                    emplead.setHorario(rs.getString(6));
                    emplead.setCorreoElectronico(rs.getString(7));
                    emplead.setDepartamento(rs.getString(8));
                    listaEmpleado.add(emplead);
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
        return listaEmpleado;
    }

}
