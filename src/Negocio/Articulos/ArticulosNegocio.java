package Negocio.Articulos;

import Datos.Articulos.ArticulosDatos;
import Recursos.Clases.Articulos;

import java.util.ArrayList;
import java.util.List;

public class ArticulosNegocio {
    public String Insertar(Articulos pElectrodomestico)throws Exception {
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
        //Material
        if (pElectrodomestico.getMaterial().isEmpty()) {
            throw new Exception("Error: El Material esta vacio.");
        }
        if ((pElectrodomestico.getMaterial().length()) < 3) {
            throw new Exception("Error: El Material es muy corto.");
        }
        //Categoria
        if (pElectrodomestico.getCategoria().isEmpty()) {
            throw new Exception("Error: La Categoria esta vacia.");
        }
        if ((pElectrodomestico.getCategoria().length()) < 3) {
            throw new Exception("Error: La Categoria es muy corta.");
        }
        //Estilo
        if (pElectrodomestico.getEstilo().isEmpty()) {
            throw new Exception("Error: El Campo Estilo esta vacia.");
        }
        if ((pElectrodomestico.getEstilo().length()) < 3) {
            throw new Exception("Error: El Estilo es muy corto.");
        }
        //Color
        if (String.valueOf(pElectrodomestico.getColor()).isEmpty()) {
            throw new Exception("Error: El Campo Color esta vacia.");
        }
        if ((pElectrodomestico.getColor().length() ) < 2) {
            throw new Exception("Error: El Color es muy corta.");
        }
        //Tamanio
        if (String.valueOf(pElectrodomestico.getTamanio()).isEmpty()) {
            throw new Exception("Error: El Campo Tamaño esta vacia.");
        }
        if ((pElectrodomestico.getTamanio().length() ) < 2) {
            throw new Exception("Error: El Tamaño es muy corto.");
        }
        //Marca
        if (String.valueOf(pElectrodomestico.getMarca()).isEmpty()) {
            throw new Exception("Error: El Campo Marca esta vacia.");
        }
        if ((pElectrodomestico.getMarca().length() ) < 2) {
            throw new Exception("Error: La Marca es muy corta.");
        }
        //NoLote
        if (String.valueOf(pElectrodomestico.getNoLote()).isEmpty()) {
            throw new Exception("Error: El Campo NoEjes esta vacia.");
        }
        if ((pElectrodomestico.getNoLote() ) < 3) {
            throw new Exception("Error: El numero de lote minimo es tres.");
        }
        try {
            respuesta = ArticulosDatos.InsertarArticulo(pElectrodomestico);
            if (respuesta==null){
                respuesta = "Guardado Exitosamente";
            }

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally {
            return respuesta;
        }
    }
    public List<Articulos> Leer()throws Exception{
        List<Articulos> electrodomesticosList = new ArrayList<>();
        try {
            electrodomesticosList = ArticulosDatos.LeerArticulo();
        } catch (Exception e) {
        }
        return electrodomesticosList;
    }
    public String Actualizar(Articulos pElectrodomestico)throws Exception{
        String respuesta = "Error";
        //ID
        if (String.valueOf(pElectrodomestico.getID()).isEmpty()) {
            throw new Exception("Error: El ID esta vacio.");
        }
        if (pElectrodomestico.getID() <= 0) {
            throw new Exception("Error: El ID no debe ser menor o igual a 0");
        }
        //Marca
        if (pElectrodomestico.getCategoria().isEmpty()) {
            throw new Exception("Error: La Categoria esta vacia.");
        }
        if ((pElectrodomestico.getMarca().length()) < 3) {
            throw new Exception("Error: La Categoria es muy corta.");
        }
        try {
            respuesta = ArticulosDatos.ActualizarArticulo(pElectrodomestico);
            if (respuesta==null){
                respuesta = "Actualizado Exitosamente";
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally {
            return respuesta;
        }
    }
    public String Eliminar(Articulos pElectrodomestico)throws Exception{
        String respuesta = "Error";
        if(String.valueOf(pElectrodomestico.getID()).isEmpty()){
            throw new Exception("Error: El Campo ID esta vacio.");
        }
        if (pElectrodomestico.getID()<=0){
            throw new Exception("Error: El Id no debe ser menor a 0");
        }
        try{
            respuesta = ArticulosDatos.EliminarArticulo(pElectrodomestico);
            if (respuesta == null){
                respuesta = "Articulo Eliminado";
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally {
            return respuesta;
        }
    }
    public List<Articulos> Buscar(Articulos pElectrodomestico)throws Exception{
        //Categoria
        if (pElectrodomestico.getCategoria().isEmpty()) {
            throw new Exception("Error: La Categoria esta vacia.");
        }
        if ((pElectrodomestico.getCategoria().length()) < 3) {
            throw new Exception("Error: La Categoria es muy corta.");
        }
        List<Articulos> electrodomesticosList = new ArrayList<>();
        try {
            electrodomesticosList = ArticulosDatos.BuscarArticulo(pElectrodomestico);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return electrodomesticosList;
    }
    public boolean ValidarId(Articulos pElectrodomestico)throws Exception{
        boolean condicion= false;
        try {
            List<Articulos> listaValidar = new ArticulosNegocio().Leer();
            for (Articulos item : listaValidar) {
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
