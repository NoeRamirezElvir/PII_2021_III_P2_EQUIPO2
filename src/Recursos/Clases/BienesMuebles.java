package Recursos.Clases;

import java.util.Date;

public class BienesMuebles {
    private int ID;
    private String Descripcion;
    private double Precio;
    private double Peso;
    private Date FechaIngreso;
    private int Garantia;

    public BienesMuebles(){

    }
    public BienesMuebles(int pID,double pPrecio,double pPeso,String pDescripcion,
                                Date pFechaIngreso,int pGarantia){
        this.ID           = pID;
        this.Precio       = pPrecio;
        this.Peso         = pPeso;
        this.Descripcion  = pDescripcion;
        this.FechaIngreso = pFechaIngreso;
        this.Garantia     = pGarantia;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        this.Precio = precio;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double peso) {
        this.Peso = peso;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.FechaIngreso = fechaIngreso;
    }

    public int getGarantia() {
        return Garantia;
    }

    public void setGarantia(int garantia) {
        this.Garantia = garantia;
    }
}