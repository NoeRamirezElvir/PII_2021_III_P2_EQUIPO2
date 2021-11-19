package Negocio.Persona;

import Datos.Persona.PersonaDatos;
import Recursos.Clases.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonaNegocio{
    public List<Persona> Leer() throws Exception{
        List<Persona> listaPersona = new ArrayList<>();
        try{
            listaPersona = PersonaDatos.leerPersona();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaPersona;
    }
    public String Insertar(Persona pPersona) throws Exception{
        String respuesta = "Error";
        try{
            //DNI
            if((String.valueOf(pPersona.getDNI()).isEmpty())){
                throw new Exception("Error: El DNI no puede estar vacio.");
            }
            if(validarID(pPersona)){
                throw new Exception("Error: El DNI ya esta registrado.");
            }
            if((String.valueOf(pPersona.getDNI()).length())<=0){
                throw new Exception("Error: El DNI no puede ser menor o igual a 0");
            }
            if((String.valueOf(pPersona.getDNI()).length())<13){
                throw new Exception("Error: El DNI es muy corto.");
            }
            if((String.valueOf(pPersona.getDNI()).length())>13){
                throw new Exception("Error: El DNI es muy largo.");
            }
            //Nombre
            if((pPersona.getNombre()).isEmpty()){
                throw new Exception("Error: El nombre esta vacio.");
            }
            if((pPersona.getNombre()).length()<3){
                throw new Exception("Error: El nombre es muy corto.");
            }
            if((pPersona.getNombre()).length() >25){
                throw new Exception("Error: El nombre es muy largo.");
            }
            //Apellido
            if((pPersona.getApellido()).isEmpty()){
                throw new Exception("Error: El apellido esta vacio.");
            }
            if((pPersona.getApellido()).length()<3){
                throw new Exception("Error: El apellido es muy corto.");
            }
            if((pPersona.getApellido()).length() >25){
                throw new Exception("Error: El apelido es muy largo.");
            }
            //Edad
            if((String.valueOf(pPersona.getEdad()).isEmpty())){
                throw new Exception("Error: La edad esta vacia");
            }
            if((pPersona.getEdad())<=0){
                throw new Exception("Error: La edad no puede ser menor o igual a 0");
            }
            if((pPersona.getEdad())>110){
                throw new Exception("Error: La edad es incorrecta.");
            }
            //Direccion
            if(pPersona.getDireccion().isEmpty()){
                throw new Exception("Error: La direccion esta vacia.");
            }
            if((pPersona.getDireccion().length()) < 4){
                throw new Exception("Error: La direccion es muy corta.");
            }
            if((pPersona.getDireccion().length()) > 30){
                throw new Exception("Error: La direccion es muy larga.");
            }
            //Genero
            if(pPersona.getGenero().isEmpty()){
                throw new Exception("Error: El genero esta vacia.");
            }
            if((!(pPersona.getGenero()).equals("Femenino"))&& !(pPersona.getGenero()).equals("Masculino")){
                throw new Exception("Error: El genero es incorrecto.");
            }
            if((pPersona.getGenero().length()) < 4){
                throw new Exception("Error: El genero es muy corto.");
            }
            if((pPersona.getGenero().length()) > 9){
                throw new Exception("Error: El genero es muy largo.");
            }
            //Telefono
            if(String.valueOf(pPersona.getTelefono()).isEmpty()){
                throw new Exception("Error: el numero de telefono esta vacio.");
            }
            if(pPersona.getTelefono() <= 0){
                throw new Exception("Error: el numero de telefono no puede ser menor o igual a 0.");
            }
            Pattern patron=Pattern.compile("[2389]");
            Matcher validarNumero = patron.matcher(String.valueOf(pPersona.getTelefono()).substring(0,1));
            if(!validarNumero.matches()){
                throw new Exception("Error: El numero de telefono debe iniciar con 2,3,8 o 9");
            }
            if(String.valueOf(pPersona.getTelefono()).length() < 8){
                throw new Exception("Error: el numero de telefono es muy corto.");
            }
            if(String.valueOf(pPersona.getTelefono()).length() > 8){
                throw new Exception("Error: el numero de telefono es muy largo.");
            }
            respuesta = PersonaDatos.insertarPersona(pPersona);
            if(respuesta==null){
                respuesta = "Guardado Exitosamente.";
            }

        }catch(Exception e){
            respuesta = e.getMessage();
            throw new Exception(e.getMessage());
        }
        finally {
            return respuesta;
        }
    }
    public String Actualizar(Persona pPersona)throws Exception{
        String respuesta = "Error";
        try{
            //DNI
            if((String.valueOf(pPersona.getDNI()).isEmpty())){
                throw new Exception("Error: El DNI no puede estar vacio.");
            }
            if((String.valueOf(pPersona.getDNI()).length())<=0){
                throw new Exception("Error: El DNI no puede ser menor o igual a 0");
            }
            if((String.valueOf(pPersona.getDNI()).length())<13){
                throw new Exception("Error: El DNI es muy corto.");
            }
            if((String.valueOf(pPersona.getDNI()).length())>13){
                throw new Exception("Error: El DNI es muy largo.");
            }
            //Nombre
            if((pPersona.getNombre()).isEmpty()){
                throw new Exception("Error: El nombre esta vacio.");
            }
            if((pPersona.getNombre()).length()<3){
                throw new Exception("Error: El nombre es muy corto.");
            }
            if((pPersona.getNombre()).length() >25){
                throw new Exception("Error: El nombre es muy largo.");
            }
            //Apellido
            if((pPersona.getApellido()).isEmpty()){
                throw new Exception("Error: El apellido esta vacio.");
            }
            if((pPersona.getApellido()).length()<3){
                throw new Exception("Error: El apellido es muy corto.");
            }
            if((pPersona.getApellido()).length() >25){
                throw new Exception("Error: El apelido es muy largo.");
            }
            //Edad
            if((String.valueOf(pPersona.getEdad()).isEmpty())){
                throw new Exception("Error: La edad esta vacia");
            }
            if((pPersona.getEdad())<=0){
                throw new Exception("Error: La edad no puede ser menor o igual a 0");
            }
            if((pPersona.getEdad())>110){
                throw new Exception("Error: La edad es incorrecta.");
            }
            //Direccion
            if(pPersona.getDireccion().isEmpty()){
                throw new Exception("Error: La direccion esta vacia.");
            }
            if((pPersona.getDireccion().length()) < 4){
                throw new Exception("Error: La direccion es muy corta.");
            }
            if((pPersona.getDireccion().length()) > 30){
                throw new Exception("Error: La direccion es muy larga.");
            }
            //Genero
            if(pPersona.getGenero().isEmpty()){
                throw new Exception("Error: El genero esta vacia.");
            }
            if((!(pPersona.getGenero()).equals("Femenino"))&& !(pPersona.getGenero()).equals("Masculino")){
                throw new Exception("Error: El genero es incorrecto.");
            }
            if((pPersona.getGenero().length()) < 4){
                throw new Exception("Error: El genero es muy corto.");
            }
            if((pPersona.getGenero().length()) > 9){
                throw new Exception("Error: El genero es muy largo.");
            }
            //Telefono
            if(String.valueOf(pPersona.getTelefono()).isEmpty()){
                throw new Exception("Error: el numero de telefono esta vacio.");
            }
            if(pPersona.getTelefono() <= 0){
                throw new Exception("Error: el numero de telefono no puede ser menor o igual a 0.");
            }
            Pattern patron=Pattern.compile("[2389]");
            Matcher validarNumero = patron.matcher(String.valueOf(pPersona.getTelefono()).substring(0,1));
            if(!validarNumero.matches()){
                throw new Exception("Error: El numero de telefono debe iniciar con 2,3,8 o 9");
            }
            if(String.valueOf(pPersona.getTelefono()).length() < 8){
                throw new Exception("Error: el numero de telefono es muy corto.");
            }
            if(String.valueOf(pPersona.getTelefono()).length() > 8){
                throw new Exception("Error: el numero de telefono es muy largo.");
            }
            respuesta = PersonaDatos.actualizarPersona(pPersona);
            if(respuesta==null){
                respuesta = "Guardado Exitosamente.";
            }
        }catch(Exception e){
            respuesta = e.getMessage();
            throw new Exception(e.getMessage());
        }
        finally{
            return respuesta;
        }
    }
    public void Eliminar(Persona pPersona) {
        try{
            PersonaDatos.eliminarPersona(pPersona);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public List<Persona> Buscar(Persona pPersona) throws Exception{
        List<Persona> listaPersona = new ArrayList<>();
        try{
            listaPersona = PersonaDatos.buscarPersona(pPersona);
        }catch(Exception e){
           throw new Exception(e.getMessage());
        }
        return listaPersona;
    }
    public boolean validarID(Persona pPersona)throws Exception{
        List<Persona> listaPersona = new ArrayList<>();
        boolean condicion=false;
        try {
            listaPersona = new PersonaNegocio().Leer();
            for (Persona item: listaPersona) {
                if((pPersona.getDNI()) == item.getDNI()){
                    condicion = true;
                }
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return condicion;
    }


}
