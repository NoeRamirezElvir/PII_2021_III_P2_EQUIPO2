package Recursos.Clases;

import java.util.Date;

public class Cliente extends Persona{
    private int    codigo;
    private String categoria;
    private Date   fechaIngreso;
    private double saldo;
    private String correoElectronico;
    private String ocupacion;
    private String tipoMembresia;

    public Cliente(){super();}
    public Cliente(long pDni,String pNombre,String pApellido,int pEdad,String pDireccion,String pGenero,long pTelefono,
                   int pCodigo,String pCategoria,Date pFechaIngreso,double pSaldo,String pCorreo,String pOcupacion,
                   String pTipoMembresia){
        super(pDni,pNombre,pApellido,pEdad,pDireccion,pGenero,pTelefono);
        this.codigo            = pCodigo;
        this.categoria         = pCategoria;
        this.fechaIngreso      = pFechaIngreso;
        this.saldo             = pSaldo;
        this.correoElectronico = pCorreo;
        this.ocupacion         = pOcupacion;
        this.tipoMembresia     = pTipoMembresia;
    }
    //Codigo
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    //Categoria
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    //Fecha Ingreso
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    //Saldo
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    //Correo Electronico
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    //Ocupacion
    public String getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    //Tipo de Membresia
    public String getTipoMembresia() {
        return tipoMembresia;
    }
    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }
}
