package Negocio.Casa;

import Datos.Casa.CasaDatos;
import Recursos.Clases.Casa;

import java.util.ArrayList;
import java.util.List;

public class CasaNegocio {
    public List<Casa> Leer()throws Exception{
        List<Casa> listaCasas=new ArrayList<>();
        try{
            listaCasas = CasaDatos.leerCasas();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaCasas;
    }
    public String Insertar(Casa casa) throws Exception{
        String respuesta="Error";
        try{
            //ID
            if(String.valueOf(casa.getID()).isEmpty()){
                throw new Exception("Error: El ID esta vacio.");
            }
            if(validarID(casa)){
                throw new Exception("Error: El ID ya esta registrado.");
            }
            if(casa.getID() <= 0){
                throw new Exception("Error: El ID no debe ser menor o igual a 0.");
            }
            if(String.valueOf(casa.getID()).length() > 7 ){
                throw new Exception("Error: El ID es muy largo.");
            }
            //No Habitaciones
            if(String.valueOf(casa.getNumeroHabitaciones()).isEmpty()){
                throw new Exception("Error: El No.de Habitaciones esta vacio.");
            }
            if(casa.getNumeroHabitaciones() <= 0){
                throw new Exception("Error: El No.de Habitaciones no debe ser menor o igual a 0.");
            }
            if(casa.getNumeroHabitaciones() > 20){
                throw new Exception("Error: El No.de Habitaciones no debe ser mayor a 20.");
            }
            if(String.valueOf(casa.getNumeroHabitaciones()).length() > 2 ){
                throw new Exception("Error: El No.de Habitaciones es muy largo.");
            }
            //No Plantas
            if(String.valueOf(casa.getNumeroPlantas()).isEmpty()){
                throw new Exception("Error: El No.de pisos esta vacio.");
            }
            if(casa.getNumeroPlantas() <= 0){
                throw new Exception("Error: El No.de pisos no debe ser menor o igual a 0.");
            }
            if(casa.getNumeroPlantas() > 5){
                throw new Exception("Error: El No.de pisos no debe ser mayor a 5.");
            }
            if(String.valueOf(casa.getNumeroPlantas()).length() > 2 ){
                throw new Exception("Error: El No. de pisos es muy largo.");
            }
            //Servicios basicos
            if(casa.getServiciosBasicos().isEmpty()){
                throw new Exception("Error: Servicios basicos esta vacio.");
            }
            if((casa.getServiciosBasicos().length()) < 4){
                throw new Exception("Error: Servicios basicos es muy corto.");
            }
            if((casa.getServiciosBasicos().length()) > 15){
                throw new Exception("Error: Servicios es muy largo.");
            }
            //Color
            if(casa.getColor().isEmpty()){
                throw new Exception("Error: El color esta vacio.");
            }
            if((casa.getColor().length()) < 3){
                throw new Exception("Error: El color es muy corto.");
            }
            if((casa.getColor().length()) > 15){
                throw new Exception("Error: El color es muy largo.");
            }
            //Material
            if(casa.getMaterial().isEmpty()){
                throw new Exception("Error: El material esta vacio.");
            }
            if((casa.getMaterial().length()) < 3){
                throw new Exception("Error: El material es muy corto.");
            }
            if((casa.getMaterial().length()) > 15){
                throw new Exception("Error: El material es muy largo.");
            }
            //Propietario
            if(casa.getPropietario().isEmpty()){
                throw new Exception("Error: El propietario esta vacio.");
            }
            if((casa.getPropietario().length()) < 3){
                throw new Exception("Error: El propietario es muy corto.");
            }
            if((casa.getPropietario().length()) > 25){
                throw new Exception("Error: El propietarioes muy largo.");
            }
            //Tipo
            if(casa.getTipo().isEmpty()){
                throw new Exception("Error: El tipo de vivienda esta vacio.");
            }
            if((casa.getTipo().length()) < 3){
                throw new Exception("Error: El tipo de vivienda es muy corto.");
            }
            if((casa.getTipo().length()) > 25){
                throw new Exception("Error: El tipo de vivienda muy largo.");
            }
            //
            respuesta = CasaDatos.insertarCasa(casa);
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
    public String Actualizar(Casa casa)throws Exception{
        String respuesta="Error";
        try{
            //ID
            if(String.valueOf(casa.getID()).isEmpty()){
                throw new Exception("Error: El ID esta vacio.");
            }
            if(casa.getID() <= 0){
                throw new Exception("Error: El ID no debe ser menor o igual a 0.");
            }
            if(String.valueOf(casa.getID()).length() > 7 ){
                throw new Exception("Error: El ID es muy largo.");
            }
            //No Habitaciones
            if(String.valueOf(casa.getNumeroHabitaciones()).isEmpty()){
                throw new Exception("Error: El No.de Habitaciones esta vacio.");
            }
            if(casa.getNumeroHabitaciones() <= 0){
                throw new Exception("Error: El No.de Habitaciones no debe ser menor o igual a 0.");
            }
            if(casa.getNumeroHabitaciones() > 20){
                throw new Exception("Error: El No.de Habitaciones no debe ser mayor a 20.");
            }
            if(String.valueOf(casa.getNumeroHabitaciones()).length() > 2 ){
                throw new Exception("Error: El No.de Habitaciones es muy largo.");
            }
            //No Plantas
            if(String.valueOf(casa.getNumeroPlantas()).isEmpty()){
                throw new Exception("Error: El No.de pisos esta vacio.");
            }
            if(casa.getNumeroPlantas() <= 0){
                throw new Exception("Error: El No.de pisos no debe ser menor o igual a 0.");
            }
            if(casa.getNumeroPlantas() > 5){
                throw new Exception("Error: El No.de pisos no debe ser mayor a 5.");
            }
            if(String.valueOf(casa.getNumeroPlantas()).length() > 2 ){
                throw new Exception("Error: El No. de pisos es muy largo.");
            }
            //Servicios basicos
            if(casa.getServiciosBasicos().isEmpty()){
                throw new Exception("Error: Servicios basicos esta vacio.");
            }
            if((casa.getServiciosBasicos().length()) < 4){
                throw new Exception("Error: Servicios basicos es muy corto.");
            }
            if((casa.getServiciosBasicos().length()) > 15){
                throw new Exception("Error: Servicios es muy largo.");
            }
            //Color
            if(casa.getColor().isEmpty()){
                throw new Exception("Error: El color esta vacio.");
            }
            if((casa.getColor().length()) < 3){
                throw new Exception("Error: El color es muy corto.");
            }
            if((casa.getColor().length()) > 15){
                throw new Exception("Error: El color es muy largo.");
            }
            //Material
            if(casa.getMaterial().isEmpty()){
                throw new Exception("Error: El material esta vacio.");
            }
            if((casa.getMaterial().length()) < 3){
                throw new Exception("Error: El material es muy corto.");
            }
            if((casa.getMaterial().length()) > 15){
                throw new Exception("Error: El material es muy largo.");
            }
            //Propietario
            if(casa.getPropietario().isEmpty()){
                throw new Exception("Error: El propietario esta vacio.");
            }
            if((casa.getPropietario().length()) < 3){
                throw new Exception("Error: El propietario es muy corto.");
            }
            if((casa.getPropietario().length()) > 25){
                throw new Exception("Error: El propietarioes muy largo.");
            }
            //Tipo
            if(casa.getTipo().isEmpty()){
                throw new Exception("Error: El tipo de vivienda esta vacio.");
            }
            if((casa.getTipo().length()) < 3){
                throw new Exception("Error: El tipo de vivienda es muy corto.");
            }
            if((casa.getTipo().length()) > 25){
                throw new Exception("Error: El tipo de vivienda muy largo.");
            }
            //
            respuesta = CasaDatos.actualizarCasa(casa);
            if(respuesta==null){
                respuesta = "Actualizado Exitosamente.";
            }
        }catch(Exception e){
            respuesta = e.getMessage();
            throw new Exception(e.getMessage());
        }
        finally{
            return respuesta;
        }
    }
    public void Eliminar(Casa casa)throws Exception{
        try{
            CasaDatos.eliminarCasa(casa);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public List<Casa> Buscar(Casa casa)throws Exception{
        List<Casa> listaCasa=new ArrayList<>();
        try{
            listaCasa = CasaDatos.buscarCasa(casa);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaCasa;
    }
    public boolean validarID(Casa casa)throws Exception{
        List<Casa> listaCasa = new ArrayList<>();
        boolean condicion=false;
        try {
            listaCasa = new CasaNegocio().Leer();
            for (Casa item: listaCasa) {
                if((casa.getID()) == item.getID()){
                    condicion = true;
                }
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return condicion;
    }
}
