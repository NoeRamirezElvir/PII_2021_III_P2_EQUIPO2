package Recursos.Clases;

import java.util.Date;

public class Empleado extends Persona{
    private int    codigo;
    private Date   fechaIngreso;
    private String cargo;
    private double sueldo;
    private String horario;
    private String correoElectronico;
    private String departamento;

    public Empleado(){super();}
    public Empleado(long pDni,String pNombre,String pApellido,int pEdad,String pDireccion,String pGenero,long pTelefono,
                    int pCodigo,Date pFechaIngreso,String pCargo,double pSueldo,String pHorario,String pCorreo,
                    String pDepartamento){
        super(pDni,pNombre,pApellido,pEdad,pDireccion,pGenero,pTelefono);
        this.codigo            = pCodigo;
        this.fechaIngreso      = pFechaIngreso;
        this.cargo             = pCargo;
        this.sueldo            = pSueldo;
        this.horario           = pHorario;
        this.correoElectronico = pCorreo;
        this.departamento      = pDepartamento;
    }
    //Codigo
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    //Fecha de Ingreso
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    //Cargo
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    //Sueldo
    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    //Horario
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    //Correo Electronico
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    //Departamento
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
