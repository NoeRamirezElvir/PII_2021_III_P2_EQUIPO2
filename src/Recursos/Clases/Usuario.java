package Recursos.Clases;

public class Usuario {
    private long   NumeroCuenta;
    private String nombre;
    private String clave;

    public Usuario(){}
    public Usuario(long pNumeroCuenta,String pNombre,String pClave){
        this. NumeroCuenta = pNumeroCuenta;
        this.nombre = pNombre;
        this.clave  = pClave;
    }
    //NumeroCuenta
    public long getNumeroCuenta() {
        return  NumeroCuenta;
    }
    public void setNumeroCuenta(long NumeroCuenta) {
        this.NumeroCuenta =  NumeroCuenta;
    }
    //Nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Clave
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
}
