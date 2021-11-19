package Negocio.Terreno;

import Datos.Terreno.TerrenoDatos;
import Recursos.Clases.Terreno;

import java.util.ArrayList;
import java.util.List;

public class TerrenoNegocio {
    public List<Terreno> Leer()throws Exception{
        List<Terreno> listaTerrenos = new ArrayList<>();
        try{
            listaTerrenos = TerrenoDatos.leerTerrenos();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaTerrenos;
    }
    public String Insertar(Terreno terreno)throws Exception{
        String respuesta = "Error";
        try{
            //ID
            if(String.valueOf(terreno.getID()).isEmpty()){
                throw new Exception("Error: El ID esta vacio.");
            }
            if(validarID(terreno)){
                throw new Exception("Error: El ID ya esta registrado.");
            }
            if(terreno.getID() <= 0){
                throw new Exception("Error: El ID no debe ser menor o igual a 0.");
            }
            if(String.valueOf(terreno.getID()).length() > 7 ){
                throw new Exception("Error: El ID es muy largo.");
            }
            //Dimension
            if(terreno.getDimension().isEmpty()){
                throw new Exception("Error: la dimension esta vacia.");
            }
            if((terreno.getDimension().length()) < 2){
                throw new Exception("Error: la dimension es muy corta.");
            }
            if((terreno.getDimension().length()) > 15){
                throw new Exception("Error: la dimension es muy larga.");
            }
            //Tipo de Suelo
            if(terreno.getTipoSuelo().isEmpty()){
                throw new Exception("Error: la dimension esta vacia.");
            }
            if((terreno.getTipoSuelo().length()) < 2){
                throw new Exception("Error: la dimension es muy corta.");
            }
            if((terreno.getTipoSuelo().length()) > 15){
                throw new Exception("Error: la dimension es muy larga.");
            }
            //Orientacion del terreno
            if(terreno.getOrientacionTerreno().isEmpty()){
                throw new Exception("Error: la orientacion del terreno esta vacia.");
            }
            if((terreno.getOrientacionTerreno().length()) < 2){
                throw new Exception("Error: la orientacion del terreno es muy corta.");
            }
            if((terreno.getOrientacionTerreno().length()) > 15){
                throw new Exception("Error: la orientacion del terreno es muy larga.");
            }
            //Tipo de Servicios
            if(terreno.getTipoServicios().isEmpty()){
                throw new Exception("Error: tipo de servicios esta vaci0.");
            }
            if((terreno.getTipoServicios().length()) < 2){
                throw new Exception("Error: tipo de servicios  es muy corto.");
            }
            if((terreno.getTipoServicios().length()) > 15){
                throw new Exception("Error: tipo de servicios  es muy largo.");
            }
            //Categoria
            if(terreno.getCategoria().isEmpty()){
                throw new Exception("Error: la categoria esta vacia.");
            }
            if((terreno.getCategoria().length()) < 2){
                throw new Exception("Error: la categoria es muy corta.");
            }
            if((terreno.getCategoria().length()) > 15){
                throw new Exception("Error: la categoria es muy larga.");
            }
            //Actitud
            if(terreno.getAltitud().isEmpty()){
                throw new Exception("Error: la altitud esta vacia.");
            }
            if((terreno.getAltitud().length()) < 2){
                throw new Exception("Error: la altitud es muy corta.");
            }
            if((terreno.getAltitud().length()) >30){
                throw new Exception("Error: la altitud es muy larga.");
            }
            //Tipo de uso
            if(terreno.getTipoUso().isEmpty()){
                throw new Exception("Error: tipo de uso esta vacio.");
            }
            if((terreno.getTipoUso().length()) < 2){
                throw new Exception("Error: tipo de uso es muy corto.");
            }
            if((terreno.getTipoUso().length()) > 15){
                throw new Exception("Error: tipo de uso es muy largo.");
            }
            //
            respuesta=TerrenoDatos.insertarTerreno(terreno);
            if(respuesta==null){
                respuesta = "Guardado Exitosamente.";
            }
        }catch(Exception e){
            respuesta=e.getMessage();
            throw new Exception(e.getMessage());
        }
        finally {
            return respuesta;
        }
    }
    public String Actualizar(Terreno terreno) throws Exception{
        String respuesta = "Error";
        try{
            //ID
            if(String.valueOf(terreno.getID()).isEmpty()){
                throw new Exception("Error: El ID esta vacio.");
            }
            if(terreno.getID() <= 0){
                throw new Exception("Error: El ID no debe ser menor o igual a 0.");
            }
            if(String.valueOf(terreno.getID()).length() > 7 ){
                throw new Exception("Error: El ID es muy largo.");
            }
            //Dimension
            if(terreno.getDimension().isEmpty()){
                throw new Exception("Error: la dimension esta vacia.");
            }
            if((terreno.getDimension().length()) < 2){
                throw new Exception("Error: la dimension es muy corta.");
            }
            if((terreno.getDimension().length()) > 15){
                throw new Exception("Error: la dimension es muy larga.");
            }
            //Tipo de Suelo
            if(terreno.getTipoSuelo().isEmpty()){
                throw new Exception("Error: la dimension esta vacia.");
            }
            if((terreno.getTipoSuelo().length()) < 2){
                throw new Exception("Error: la dimension es muy corta.");
            }
            if((terreno.getTipoSuelo().length()) > 25){
                throw new Exception("Error: la dimension es muy larga.");
            }
            //Orientacion del terreno
            if(terreno.getOrientacionTerreno().isEmpty()){
                throw new Exception("Error: la orientacion del terreno esta vacia.");
            }
            if((terreno.getOrientacionTerreno().length()) < 2){
                throw new Exception("Error: la orientacion del terreno es muy corta.");
            }
            if((terreno.getOrientacionTerreno().length()) > 20){
                throw new Exception("Error: la orientacion del terreno es muy larga.");
            }
            //Tipo de Servicios
            if(terreno.getTipoServicios().isEmpty()){
                throw new Exception("Error: tipo de servicios esta vaci0.");
            }
            if((terreno.getTipoServicios().length()) < 2){
                throw new Exception("Error: tipo de servicios  es muy corto.");
            }
            if((terreno.getTipoServicios().length()) > 25){
                throw new Exception("Error: tipo de servicios  es muy largo.");
            }
            //Categoria
            if(terreno.getCategoria().isEmpty()){
                throw new Exception("Error: la categoria esta vacia.");
            }
            if((terreno.getCategoria().length()) < 2){
                throw new Exception("Error: la categoria es muy corta.");
            }
            if((terreno.getCategoria().length()) > 20){
                throw new Exception("Error: la categoria es muy larga.");
            }
            //Actitud
            if(terreno.getAltitud().isEmpty()){
                throw new Exception("Error: la altitud esta vacia.");
            }
            if((terreno.getAltitud().length()) < 2){
                throw new Exception("Error: la altitud es muy corta.");
            }
            if((terreno.getAltitud().length()) >30){
                throw new Exception("Error: la altitud es muy larga.");
            }
            //Tipo de uso
            if(terreno.getTipoUso().isEmpty()){
                throw new Exception("Error: tipo de uso esta vacio.");
            }
            if((terreno.getTipoUso().length()) < 2){
                throw new Exception("Error: tipo de uso es muy corto.");
            }
            if((terreno.getTipoUso().length()) > 25){
                throw new Exception("Error: tipo de uso es muy largo.");
            }
            //
            respuesta=TerrenoDatos.actualizarTerreno(terreno);
            if(respuesta==null){
                respuesta = "Actualizado Exitosamente.";
            }
        }catch(Exception e){
            respuesta=e.getMessage();
            throw new Exception(e.getMessage());
        }
        finally {
            return respuesta;
        }
    }
    public void Eliminar(Terreno terreno)throws Exception{
        try{
            TerrenoDatos.eliminarTerreno(terreno);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public List<Terreno> Buscar(Terreno terreno)throws Exception{
        List<Terreno> listaTerreno = new ArrayList<>();
        try{
            listaTerreno = TerrenoDatos.buscarTerreno(terreno);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaTerreno;
    }
    public boolean validarID(Terreno terreno)throws Exception{
        List<Terreno> listaTerrenos = new ArrayList<>();
        boolean condicion=false;
        try {
            listaTerrenos = new TerrenoNegocio().Leer();
            for (Terreno item: listaTerrenos) {
                if((terreno.getID()) == item.getID()){
                    condicion = true;
                }
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return condicion;
    }
}
