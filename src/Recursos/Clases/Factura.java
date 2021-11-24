package Recursos.Clases;

import java.util.Date;

public class Factura {
    private int codigo;
    private Date fecha;
    private String cliente;
    private String empleado;
    private String Producto;
    private double total;

    public Factura() {
    }
    public Factura(int pCodigo, Date pFecha, String pCliente, String pEmpleado, String pProducto, double pTotal) {
        this.codigo = pCodigo;
        this.fecha = pFecha;
        this.cliente = pCliente;
        this.empleado = pEmpleado;
        this.Producto = pProducto;
        this.total = pTotal;
    }

    //Codigo
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    //Fecha
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String producto) {
        Producto = producto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}