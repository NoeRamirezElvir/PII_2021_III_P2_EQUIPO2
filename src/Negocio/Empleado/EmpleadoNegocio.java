package Negocio.Empleado;

import Datos.Empleado.EmpleadoDatos;
import Recursos.Clases.Empleado;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoNegocio {
    public List<Empleado> Leer()throws Exception{
        List<Empleado> listaEmpleado = new ArrayList<>();
        try{
            listaEmpleado = EmpleadoDatos.leerEmpleado();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaEmpleado;
    }
    public String Insertar(Empleado empleado)throws Exception{
        String respuesta = "Error";
        try{
            //DNI
            if(String.valueOf(empleado.getDNI()).isEmpty()){
                throw new Exception("Error: El DNI esta vacio.");
            }
            if(validarID(empleado)){
                throw new Exception("Error: El DNI esta en uso.");
            }
            if((String.valueOf(empleado.getDNI()).length()) <= 0){
                throw new Exception("Error: El DNI no puede ser menor o igual a 0");
            }
            if((String.valueOf(empleado.getDNI()).length()) < 13){
                throw new Exception("Error: El DNI es muy corto.");
            }
            if((String.valueOf(empleado.getDNI()).length()) > 13){
                throw new Exception("Error: El DNI es muy largo.");
            }
            //Codigo
            if(String.valueOf(empleado.getCodigo()).isEmpty()){
                throw new Exception("Error: EL codigo esta vacio.");
            }
            if(validarCodigo(empleado)){
                throw new Exception("Error: El codigo ya esta registrado");
            }
            if((String.valueOf(empleado.getCodigo()).length())<=0){
                throw new Exception("Error: EL Codigo no debe ser menor o igual a 0.");
            }
            if((String.valueOf(empleado.getCodigo()).length())<7){
                throw new Exception("Error: EL Codigo es muy corto.");
            }
            if((String.valueOf(empleado.getCodigo()).length())>7){
                throw new Exception("Error: EL Codigo es muy largo.");
            }
            //fecha Ingreso
            if(String.valueOf(empleado.getFechaIngreso()).isEmpty()){
                throw new Exception("Error: La fecha de ingreso esta vacia.");
            }
            //Cargo
            if(empleado.getCargo().isEmpty()){
                throw new Exception("Error: El cargo esta vacio.");
            }
            if(empleado.getCargo().length() < 3){
                throw new Exception("Error: El cargo es muy corto.");
            }
            if(empleado.getCargo().length() > 25){
                throw new Exception("Error: El cargo es muy largo.");
            }
            //Sueldo
            if(String.valueOf(empleado.getSueldo()).isEmpty()){
                throw new Exception("Error: El sueldo esta vacio.");
            }
            if(empleado.getSueldo() <= 0){
                throw new Exception("Error: El sueldo no debe ser menor o igual a 0.");
            }
            //Horario
            if(empleado.getHorario().isEmpty()){
                throw new Exception("Error: El correo electronico esta vacio.");
            }
            if(empleado.getHorario().length() < 12){
                throw new Exception("Error: El Horario es muy corto.");
            }
            if(empleado.getHorario().length() > 15){
                throw new Exception("Error: El Horario es muy largo.");
            }
            //Correo
            if(empleado.getCorreoElectronico().isEmpty()){
                throw new Exception("Error: El correo electronico esta vacio.");
            }
            if(empleado.getCorreoElectronico().length() < 12){
                throw new Exception("Error: El correo electronico es muy corto.");
            }
            if(empleado.getCorreoElectronico().length() > 30){
                throw new Exception("Error: El correo electronico es muy largo.");
            }
            //Departamento
            if(empleado.getDepartamento().isEmpty()){
                throw new Exception("Error: El Departamento esta vacio.");
            }
            if(empleado.getDepartamento().length() < 10){
                throw new Exception("Error: El Departamento es muy corto.");
            }
            if(empleado.getDepartamento().length() > 16){
                throw new Exception("Error: El Departamento es muy largo.");
            }
            respuesta = EmpleadoDatos.insertarEmpleado(empleado);
            if(respuesta==null){
                respuesta="Guardado Exitosamente.";
            }
        }catch (Exception e){
            respuesta = e.getMessage();
            throw new Exception(e.getMessage());
        }
        finally{
            return respuesta;
        }
    }
    public String Actualizar(Empleado empleado)throws Exception{
        String respuesta = "Error";
        try{
            //DNI
            if(String.valueOf(empleado.getDNI()).isEmpty()){
                throw new Exception("Error: El DNI esta vacio.");
            }
            if((String.valueOf(empleado.getDNI()).length()) <= 0){
                throw new Exception("Error: El DNI no puede ser menor o igual a 0");
            }
            if((String.valueOf(empleado.getDNI()).length()) < 13){
                throw new Exception("Error: El DNI es muy corto.");
            }
            if((String.valueOf(empleado.getDNI()).length()) > 13){
                throw new Exception("Error: El DNI es muy largo.");
            }
            //Codigo
            if(String.valueOf(empleado.getCodigo()).isEmpty()){
                throw new Exception("Error: EL Codigo esta vacio.");
            }
            if((String.valueOf(empleado.getCodigo()).length())<=0){
                throw new Exception("Error: EL Codigo no debe ser menor o igual a 0.");
            }
            if((String.valueOf(empleado.getCodigo()).length())<7){
                throw new Exception("Error: EL Codigo es muy corto.");
            }
            if((String.valueOf(empleado.getCodigo()).length())>7){
                throw new Exception("Error: EL Codigo es muy largo.");
            }
            //fecha Ingreso
            if(String.valueOf(empleado.getFechaIngreso()).isEmpty()){
                throw new Exception("Error: La fecha de ingreso esta vacia.");
            }
            //Cargo
            if(empleado.getCargo().isEmpty()){
                throw new Exception("Error: El cargo esta vacio.");
            }
            if(empleado.getCargo().length() < 3){
                throw new Exception("Error: El cargo es muy corto.");
            }
            if(empleado.getCargo().length() > 25){
                throw new Exception("Error: El cargo es muy largo.");
            }
            //Sueldo
            if(String.valueOf(empleado.getSueldo()).isEmpty()){
                throw new Exception("Error: El sueldo esta vacio.");
            }
            if(empleado.getSueldo() <= 0){
                throw new Exception("Error: El sueldo no debe ser menor o igual a 0.");
            }
            //Horario
            if(empleado.getHorario().isEmpty()){
                throw new Exception("Error: El correo electronico esta vacio.");
            }
            if(empleado.getHorario().length() < 12){
                throw new Exception("Error: El Horario es muy corto.");
            }
            if(empleado.getHorario().length() > 15){
                throw new Exception("Error: El Horario es muy largo.");
            }
            //Correo
            if(empleado.getCorreoElectronico().isEmpty()){
                throw new Exception("Error: El correo electronico esta vacio.");
            }
            if(empleado.getCorreoElectronico().length() < 12){
                throw new Exception("Error: El correo electronico es muy corto.");
            }
            if(empleado.getCorreoElectronico().length() > 30){
                throw new Exception("Error: El correo electronico es muy largo.");
            }
            //Departamento
            if(empleado.getDepartamento().isEmpty()){
                throw new Exception("Error: El Departamento esta vacio.");
            }
            if(empleado.getDepartamento().length() < 10){
                throw new Exception("Error: El Departamento es muy corto.");
            }
            if(empleado.getDepartamento().length() > 16){
                throw new Exception("Error: El Departamento es muy largo.");
            }
            respuesta = EmpleadoDatos.actualizarEmpleado(empleado);
            if(respuesta==null){
                respuesta="Guardado Exitosamente.";
            }
        }catch (Exception e){
            respuesta = e.getMessage();
            throw new Exception(e.getMessage());
        }
        finally{
            return respuesta;
        }
    }
    public void Eliminar(Empleado empleado)throws Exception{
        try{
            EmpleadoDatos.eliminarEmpleado(empleado);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public List<Empleado> Buscar(Empleado empleado)throws Exception{
        List<Empleado> listaEmpleado = new ArrayList<>();
        try{
            listaEmpleado = EmpleadoDatos.buscarEmpleado(empleado);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaEmpleado;
    }
    public boolean validarID(Empleado empleado)throws Exception{
        List<Empleado> listaEmpleado = new ArrayList<>();
        boolean condicion=false;
        try {
            listaEmpleado = Leer();
            for (Empleado item: listaEmpleado) {
                if((empleado.getDNI()) == item.getDNI()){
                    condicion = true;
                }
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return condicion;
    }
    public boolean validarCodigo(Empleado empleado) throws Exception{
        List<Empleado> listaEmpleado= new ArrayList<>();
        boolean condicion=false;
        try{
            listaEmpleado = Leer();
            for (Empleado item: listaEmpleado) {
                if((empleado.getCodigo()) == (item.getCodigo())){
                    condicion = true;
                }
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return condicion;
    }
}
