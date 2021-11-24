package Negocio.Transporte;

import Datos.Transporte.TransporteDatos;
import Recursos.Clases.BienesMuebles;
import Recursos.Clases.Transporte;

import java.util.ArrayList;
import java.util.List;

public class TransporteNegocio {
    public String Insertar(Transporte pElectrodomestico)throws Exception {
        String respuesta = "Error";
        //ID
        if (String.valueOf(pElectrodomestico.getID()).isEmpty()) {
            throw new Exception("Error: El ID esta vacio.");
        }
        if (ValidarId(pElectrodomestico)) {
            throw new Exception("Error: ID ya resgistrado");
        }
        if (pElectrodomestico.getID() <= 0) {
            throw new Exception("Error: El ID no debe ser menor o igual a 0");
        }
        //Nombre
        if (pElectrodomestico.getNombre().isEmpty()) {
            throw new Exception("Error: El Nombre esta vacio.");
        }
        if ((pElectrodomestico.getNombre().length()) < 3) {
            throw new Exception("Error: El Nombre es muy corto.");
        }
        //Marca
        if (pElectrodomestico.getMarca().isEmpty()) {
            throw new Exception("Error: La Marca esta vacia.");
        }
        if ((pElectrodomestico.getMarca().length()) < 3) {
            throw new Exception("Error: La Marca es muy corta.");
        }
        //Modelo
        if (pElectrodomestico.getModelo().isEmpty()) {
            throw new Exception("Error: El Campo modelo esta vacia.");
        }
        if ((pElectrodomestico.getModelo().length()) < 3) {
            throw new Exception("Error: El modelo es muy corto.");
        }
        //Capacidad
        if (String.valueOf(pElectrodomestico.getCapacidad()).isEmpty()) {
            throw new Exception("Error: El Campo Capacidad esta vacia.");
        }
        if ((pElectrodomestico.getCapacidad() ) < 2) {
            throw new Exception("Error: La Capacidad es muy corta.");
        }
        //NoEjes
        if (String.valueOf(pElectrodomestico.getNoEjes()).isEmpty()) {
            throw new Exception("Error: El Campo NoEjes esta vacia.");
        }
        if ((pElectrodomestico.getNoEjes() ) < 2) {
            throw new Exception("Error: El numero de ejes minimo es dos.");
        }
        if ((pElectrodomestico.getNoEjes() ) >6) {
            throw new Exception("Error: El numero de ejes maximo es 6.");
        }
        //HP
        if (String.valueOf(pElectrodomestico.getCaballosFuerza()).isEmpty()) {
            throw new Exception("Error: El Campo Caballos de Fuerza esta vacia.");
        }
        if ((pElectrodomestico.getCaballosFuerza() ) < 5) {
            throw new Exception("Error: Caballos de Fuerza muy corto.");
        }
        //LugarFabricacion
        if (String.valueOf(pElectrodomestico.getLugarFabricacion()).isEmpty()) {
            throw new Exception("Error: El campo Lugar de Fabricacion esta vacio.");
        }
        if (pElectrodomestico.getLugarFabricacion().length() < 5) {
            throw new Exception("Error: El Lugar de Fabricacion no debe ser menor a 5");
        }
        try {
            respuesta = TransporteDatos.InsertarElectrodomestico(pElectrodomestico);
            if (respuesta==null){
                respuesta = "Guardado Exitosamente";
            }

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally {
            return respuesta;
        }
    }
    public List<Transporte> Leer()throws Exception{
        List<Transporte> electrodomesticosList = new ArrayList<>();
        try {
            electrodomesticosList = TransporteDatos.LeerElectrodomestico();
        } catch (Exception e) {
        }
        return electrodomesticosList;
    }
    public String Actualizar(Transporte pElectrodomestico)throws Exception{
        String respuesta = "Error";
        //ID
        if (String.valueOf(pElectrodomestico.getID()).isEmpty()) {
            throw new Exception("Error: El ID esta vacio.");
        }
        if (pElectrodomestico.getID() <= 0) {
            throw new Exception("Error: El ID no debe ser menor o igual a 0");
        }
        //Nombre
        if (pElectrodomestico.getNombre().isEmpty()) {
            throw new Exception("Error: El Nombre esta vacio.");
        }
        if ((pElectrodomestico.getNombre().length()) < 3) {
            throw new Exception("Error: El Nombre es muy corto.");
        }
        //Marca
        if (pElectrodomestico.getMarca().isEmpty()) {
            throw new Exception("Error: La Marca esta vacia.");
        }
        if ((pElectrodomestico.getMarca().length()) < 4) {
            throw new Exception("Error: La Marca es muy corta.");
        }
        try {
            respuesta = TransporteDatos.ActualizarElectrodomestico(pElectrodomestico);
            if (respuesta==null){
                respuesta = "Actualizado Exitosamente";
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally {
            return respuesta;
        }
    }
    public String Eliminar(Transporte pElectrodomestico)throws Exception{
        String respuesta = "Error";
        if(String.valueOf(pElectrodomestico.getID()).isEmpty()){
            throw new Exception("Error: El Campo ID esta vacio.");
        }
        if (pElectrodomestico.getID()<=0){
            throw new Exception("Error: El Id no debe ser menor a 0");
        }
        try{
            respuesta = TransporteDatos.EliminarElectrodomestico(pElectrodomestico);
            if (respuesta == null){
                respuesta = "Electrodomestico Eliminado";
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally {
            return respuesta;
        }
    }
    public List<Transporte> Buscar(Transporte pElectrodomestico)throws Exception{
        //Nombre
        if (pElectrodomestico.getNombre().isEmpty()) {
            throw new Exception("Error: El Nombre esta vacio.");
        }
        if ((pElectrodomestico.getNombre().length()) < 3) {
            throw new Exception("Error: El Nombre es muy corto.");
        }
        List<Transporte> electrodomesticosList = new ArrayList<>();
        try {
            electrodomesticosList = TransporteDatos.BuscarElectrodomestico(pElectrodomestico);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return electrodomesticosList;
    }
    public boolean ValidarId(Transporte pElectrodomestico)throws Exception{
        boolean condicion= false;
        try {
            List<Transporte> listaValidar = new TransporteNegocio().Leer();
            for (BienesMuebles item : listaValidar) {
                if (item.getID()==pElectrodomestico.getID()){
                    condicion = true;
                }
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return condicion;
    }
}
