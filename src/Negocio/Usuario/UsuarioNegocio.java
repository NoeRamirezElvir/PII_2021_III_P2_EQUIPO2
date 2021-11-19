package Negocio.Usuario;

import Datos.Usuario.UsuarioDatos;
import Recursos.Clases.Usuario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioNegocio {
    public String insertar(Usuario usuario) throws Exception{
        String respuesta ="Error";
        try{
            //Numero de Cuenta
            if((String.valueOf((usuario.getNumeroCuenta())).isEmpty())){
                throw new Exception("Error: El numero de cuenta esta vacio.");
            }
            if(usuario.getNumeroCuenta() <= 0){
                throw new Exception("Error: El numero de cuenta no debe ser menor o igual a 0.");
            }
            //Nombre
            if((usuario.getNombre()).isEmpty()){
                throw new Exception("Error: El nombre de usuario esta vacio.");
            }
            if((usuario.getNombre().length()) < 5){
                throw new Exception("Error: El nombre de usuario es muy corto.");
            }
            if((usuario.getNombre().length())>20){
                throw new Exception(("Error: El nombre de usuario es muy largo."));
            }
            //Clave
            if((usuario.getClave()).isEmpty()){
                throw new Exception("Error: La contraseña esta vacia.");
            }
            if((usuario.getClave().length())<5){
                throw new Exception("Error: La contraseña es muy corta");
            }
            if((usuario.getClave().length())>25){
                throw new Exception("Error: La contraseña es muy larga.");
            }
            respuesta = UsuarioDatos.crearUsuario(usuario);
            if(respuesta==null){
                respuesta = "Guardado Exitosamente.";
            }
        }catch(Exception e){
            respuesta = e.getMessage();
           throw new Exception(respuesta);
        }
        finally{
            return respuesta;
        }
    }
    public List<Usuario> buscar(Usuario usuario)throws Exception{
        List<Usuario> listaUsuario = new ArrayList<>();
        try{
            listaUsuario = UsuarioDatos.buscarUsuario(usuario);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaUsuario;
    }
    public boolean validarNombreUsuario(Usuario usuario){
        boolean acceso = false;
        try {

            String nombre = usuario.getNombre();
            List<Usuario> listaUsuario = new UsuarioNegocio().buscar(usuario);
            for (Usuario item: listaUsuario) {
                if((nombre).equals(item.getNombre())){
                    acceso = true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return acceso;
    }
    public boolean validarUsuario(Usuario usuario){
        boolean acceso = false;
        try {

            String nombre = usuario.getNombre();
            String clave = usuario.getClave();
            List<Usuario> listaUsuario = new UsuarioNegocio().buscar(usuario);
            for (Usuario item: listaUsuario) {
                if((nombre).equals(item.getNombre())&&(clave.equals(item.getClave()))){
                    acceso = true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return acceso;
    }
}
