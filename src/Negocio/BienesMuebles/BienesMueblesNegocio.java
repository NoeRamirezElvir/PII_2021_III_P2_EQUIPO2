package Negocio.BienesMuebles;

import Datos.BienesMuebles.BienesMueblesDatos;
import Recursos.Clases.BienesMuebles;

import java.util.ArrayList;
import java.util.List;


public class BienesMueblesNegocio {
    public String Insertar(BienesMuebles pBienMueble)throws Exception{
        String respuesta = "Error";
        //ID
        if(String.valueOf(pBienMueble.getID()).isEmpty()){
            throw new Exception("Error: El ID esta vacio.");
        }
        if(ValidarId(pBienMueble)){
            throw new Exception("Error: ID ya resgistrado");
        }
        if(pBienMueble.getID()<=0){
            throw new Exception("Error: El ID no debe ser menor o igual a 0");
        }
        //Descripcion
        if(pBienMueble.getDescripcion().isEmpty()){
            throw new Exception("Error: La descripcion esta vacia.");
        }
        if((pBienMueble.getDescripcion().length()) < 4){
            throw new Exception("Error: La descripcion es muy corta.");
        }
        //Precio
        if(String.valueOf(pBienMueble.getPrecio()).isEmpty()){
            throw new Exception("Error: El precio esta vacio.");
        }
        if(pBienMueble.getPrecio() <= 0){
            throw new Exception("Error: El precio no debe ser menor a 0.");
        }
        //peso
        if(String.valueOf(pBienMueble.getPeso()).isEmpty()){
            throw new Exception("Error: El campo peso esta vacio.");
        }
        if(pBienMueble.getPeso() < 0){
            throw new Exception("Error: El peso no debe ser menor a 0.");
        }
        //FechaIngreso
        if (pBienMueble.getFechaIngreso().toString().isEmpty()){
            throw new Exception("Error: Fecha vacia");
        }

        //Garantia
        if(String.valueOf(pBienMueble.getGarantia()).isEmpty()){
            throw new Exception("Error: El campo Garantia esta vacio.");
        }
        if(pBienMueble.getGarantia() < 0){
            throw new Exception("Error: La garantia no debe ser menor a 0");
        }
        if(pBienMueble.getGarantia() > 24){
            throw new Exception("Error: La garantia no debe ser mayor a 24 meses.");
        }
        try {
            respuesta = BienesMueblesDatos.InsertarBienMueble(pBienMueble);
            if (respuesta==null){
                respuesta = "Guardado Exitosamente";
            }

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally {
            return respuesta;
        }
    }
    public List<BienesMuebles> Leer()throws Exception{
        List<BienesMuebles> listaMueblesNegocio = new ArrayList<>();
        try {
            listaMueblesNegocio = BienesMueblesDatos.LeerBienMueble();
        } catch (Exception e) {
        }
        return listaMueblesNegocio;
    }
    public String Actualizar(BienesMuebles pBienMueble)throws Exception{
        String respuesta = "Error";
        //ID
        if(String.valueOf(pBienMueble.getID()).isEmpty()){
            throw new Exception("Error: El ID esta vacio.");
        }
        if(pBienMueble.getID()<=0){
            throw new Exception("Error: El ID no debe ser menor o igual a 0");
        }
        //Descripcion
        if(pBienMueble.getDescripcion().isEmpty()){
            throw new Exception("Error: La descripcion esta vacia.");
        }
        if((pBienMueble.getDescripcion().length()) < 4){
            throw new Exception("Error: La descripcion es muy corta.");
        }
        //Precio
        if(String.valueOf(pBienMueble.getPrecio()).isEmpty()){
            throw new Exception("Error: El precio esta vacio.");
        }
        if(pBienMueble.getPrecio() <= 0){
            throw new Exception("Error: El precio no debe ser menor a 0.");
        }
        //peso
        if(String.valueOf(pBienMueble.getPeso()).isEmpty()){
            throw new Exception("Error: El campo peso esta vacio.");
        }
        if(pBienMueble.getPeso() < 0){
            throw new Exception("Error: El peso no debe ser menor a 0.");
        }
        //FechaIngreso
        if (pBienMueble.getFechaIngreso().toString().isEmpty()){
            throw new Exception("Error: Fecha vacia");
        }
        //Garantia
        if(String.valueOf(pBienMueble.getGarantia()).isEmpty()){
            throw new Exception("Error: El campo Garantia esta vacio.");
        }
        if(pBienMueble.getGarantia() < 0){
            throw new Exception("Error: La garantia no debe ser menor a 0");
        }
        if(pBienMueble.getGarantia() > 24){
            throw new Exception("Error: La garantia no debe ser mayor a 24 meses.");
        }
        try {
            respuesta = BienesMueblesDatos.ActualizarBienMueble(pBienMueble);
            if (respuesta==null){
                respuesta = "Actualizado Exitosamente";
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally {
            return respuesta;
        }
    }
    public String Eliminar(BienesMuebles pBienMueble)throws Exception{
        String respuesta = "Error";
        if(String.valueOf(pBienMueble.getID()).isEmpty()){
            throw new Exception("Error: El Campo ID esta vacio.");
        }
        if (pBienMueble.getID()<=0){
            throw new Exception("Error: El Id no debe ser menor a 0");
        }
        try{
           respuesta = BienesMueblesDatos.EliminarBienMueble(pBienMueble);
            if (respuesta == null){
                respuesta = "Bien Inmueble Eliminado";
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally {
            return respuesta;
        }
    }
    public List<BienesMuebles> Buscar(BienesMuebles pBienMueble)throws Exception{
        //Descripcion
        if(pBienMueble.getDescripcion().isEmpty()){
            throw new Exception("Error: La descripcion esta vacia.");
        }
        if((pBienMueble.getDescripcion().length()) < 4){
            throw new Exception("Error: La descripcion es muy corta.");
        }
        List<BienesMuebles> listaencontrada = new ArrayList<>();
        try {
            listaencontrada = BienesMueblesDatos.BuscarBienMueble(pBienMueble);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaencontrada;
    }
    public boolean ValidarId(BienesMuebles pBienMueble)throws Exception{
        boolean condicion= false;
        try {
            List<BienesMuebles> listaValidar = new BienesMueblesNegocio().Leer();
            for (BienesMuebles item : listaValidar) {
                if (item.getID()==pBienMueble.getID()){
                    condicion = true;
                }
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return condicion;
    }
}
