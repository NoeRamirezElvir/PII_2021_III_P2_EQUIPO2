package Recursos.Clases;

import Negocio.Transporte.TransporteNegocio;

import java.util.List;

public class ItemBM {
    private long ID;
    private String descripcion;

    // public Item(){}
    public ItemBM(long ID, String nombre){
        this.ID = ID;
        this.descripcion = nombre;
    }

    public long getID() {
        return ID;
    }
    public void setID(long ID) {
        this.ID = ID;
    }
    public void setDescripcion(String nombre) {
        this.descripcion = nombre;
    }
    public String getDescripcion() {
        return descripcion;
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
    @Override
    public String toString(){
        return descripcion;
    }
}
