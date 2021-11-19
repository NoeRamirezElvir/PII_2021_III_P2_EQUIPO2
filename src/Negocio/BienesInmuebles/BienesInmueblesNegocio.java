package Negocio.BienesInmuebles;

import Datos.BienesInmuebles.BienesInmueblesDatos;
import Recursos.Clases.BienesInmuebles;

import java.util.ArrayList;
import java.util.List;

public class BienesInmueblesNegocio {
    public List<BienesInmuebles> Leer()throws Exception{
        List<BienesInmuebles> listaInmuebles = new ArrayList<>();
        try{
            listaInmuebles = BienesInmueblesDatos.leerInmuebles();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaInmuebles;
    }
    public String Insertar(BienesInmuebles inmuebles)throws Exception{
        String respuesta="Error";
        try{
            //ID
            if(String.valueOf(inmuebles.getID()).isEmpty()){
                throw new Exception("Error: El ID esta vacio.");
            }
            if(validarID(inmuebles)){
                throw new Exception("Error: El ID ya esta registrado.");
            }
            if(inmuebles.getID() <= 0){
                throw new Exception("Error: El ID no debe ser menor o igual a 0.");
            }
            if(String.valueOf(inmuebles.getID()).length() > 7 ){
                throw new Exception("Error: El ID es muy largo.");
            }
            //Precio Venta
            if(String.valueOf(inmuebles.getPrecioVenta()).isEmpty()){
                throw new Exception("Error: El precio de venta esta vacio.");
            }
            if(inmuebles.getPrecioVenta() < 0){
                throw new Exception("Error: El precio de venta no debe ser menor a 0.");
            }
            //Precio Renta
            if(String.valueOf(inmuebles.getPrecioRenta()).isEmpty()){
             throw new Exception("Error: El precio de renta esta vacio.");
             }
             if(inmuebles.getPrecioRenta() < 0){
             throw new Exception("Error: El precio de renta no debe ser menor a 0.");
             }
            //Descripcion
            if(inmuebles.getDescripcion().isEmpty()){
                throw new Exception("Error: La descripcion esta vacia.");
            }
            if((inmuebles.getDescripcion().length()) < 4){
                throw new Exception("Error: La descripcion es muy corta.");
            }
            if((inmuebles.getDescripcion().length()) > 30){
                throw new Exception("Error: La descripcion es muy larga.");
            }
            //Direccion
            if(inmuebles.getDireccion().isEmpty()){
                throw new Exception("Error: La direccion esta vacia.");
            }
            if((inmuebles.getDireccion().length()) < 4){
                throw new Exception("Error: La direccion es muy corta.");
            }
            if((inmuebles.getDireccion().length()) > 30){
                throw new Exception("Error: La direccion es muy larga.");
            }
            //
            respuesta= BienesInmueblesDatos.insertarInmueble(inmuebles);
            if(respuesta==null){
                respuesta= "Guardado Exitosamente";
            }
        }catch(Exception e){
            respuesta=e.getMessage();
            throw new Exception(e.getMessage());
        }
        finally{
            return respuesta;
        }
    }
    public String Actualizar(BienesInmuebles inmuebles)throws Exception{
        String respuesta="Error";
        try{
            //ID
            if(String.valueOf(inmuebles.getID()).isEmpty()){
                throw new Exception("Error: El ID esta vacio.");
            }
            if(String.valueOf(inmuebles.getID()).length() <=0 ){
                throw new Exception("Error: El ID no debe ser menor o igual a 0.");
            }
            if(String.valueOf(inmuebles.getID()).length() > 7 ){
                throw new Exception("Error: El ID es muy largo.");
            }
            //Precio Venta
            if(String.valueOf(inmuebles.getPrecioVenta()).isEmpty()){
                throw new Exception("Error: El precio de venta esta vacio.");
            }
            if(inmuebles.getPrecioVenta() < 0){
                throw new Exception("Error: El precio de venta no debe ser menor a 0.");
            }
            //Precio Renta
            if(String.valueOf(inmuebles.getPrecioRenta()).isEmpty()){
                throw new Exception("Error: El precio de renta esta vacio.");
            }
            if(inmuebles.getPrecioRenta() < 0){
                throw new Exception("Error: El precio de renta no debe ser menor a 0.");
            }
            //Descripcion
            if(inmuebles.getDescripcion().isEmpty()){
                throw new Exception("Error: La descripcion esta vacia.");
            }
            if((inmuebles.getDescripcion().length()) < 4){
                throw new Exception("Error: La descripcion es muy corta.");
            }
            if((inmuebles.getDescripcion().length()) > 30){
                throw new Exception("Error: La descripcion es muy larga.");
            }
            //Direccion
            if(inmuebles.getDireccion().isEmpty()){
                throw new Exception("Error: La direccion esta vacia.");
            }
            if((inmuebles.getDireccion().length()) < 4){
                throw new Exception("Error: La direccion es muy corta.");
            }
            if((inmuebles.getDireccion().length()) > 30){
                throw new Exception("Error: La direccion es muy larga.");
            }
            //
            respuesta= BienesInmueblesDatos.actualizarInmueble(inmuebles);
            if(respuesta==null){
                respuesta= "Actualizado Exitosamente";
            }
        }catch(Exception e){
            respuesta=e.getMessage();
            throw new Exception(e.getMessage());
        }
        finally{
            return respuesta;
        }
    }
    public void Eliminar(BienesInmuebles inmuebles){
        try{
            BienesInmueblesDatos.eliminarInmueble(inmuebles);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public List<BienesInmuebles> Buscar(BienesInmuebles inmuebles)throws Exception{
        List<BienesInmuebles> listaInmuebles = new ArrayList<>();
        try{
            listaInmuebles = BienesInmueblesDatos.buscarInmueble(inmuebles);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaInmuebles;
    }
     public boolean validarID(BienesInmuebles inmuebles)throws Exception{
        List<BienesInmuebles> listaInmuebles = new ArrayList<>();
        boolean condicion=false;
        try {
            listaInmuebles = new BienesInmueblesNegocio().Leer();
            for (BienesInmuebles item: listaInmuebles) {
                if((inmuebles.getID()) == item.getID()){
                    condicion = true;
                }
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return condicion;
    }


}
