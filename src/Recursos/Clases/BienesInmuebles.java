package Recursos.Clases;

public class BienesInmuebles {
    private int    ID;
    private double precioVenta;
    private double precioRenta;
    private String descripcion;
    private String direccion;

    public BienesInmuebles(){}
    public BienesInmuebles(int pId,double pPrecioVenta,double pPrecioRenta,String pDescripcion,String pDireccion){
        this.ID          = pId;
        this.precioVenta = pPrecioVenta;
        this.precioRenta = pPrecioRenta;
        this.descripcion = pDescripcion;
        this.direccion   = pDireccion;
    }
    //ID
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    //Precio de Venta
    public double getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    //Precio de Renta
    public double getPrecioRenta() {
        return precioRenta;
    }
    public void setPrecioRenta(double precioRenta) {
        this.precioRenta = precioRenta;
    }
    //Descripcion
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //Direccion
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
