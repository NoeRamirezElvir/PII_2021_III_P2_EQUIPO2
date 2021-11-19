package Recursos.Clases;

public class Casa extends BienesInmuebles{
    private int     numeroHabitaciones;
    private int     numeroPlantas;
    private String  serviciosBasicos;
    private String  color;
    private String  material;
    private String  propietario;
    private String  tipo;

    public Casa(){super();}
    public Casa(int pId,double pPrecioVenta,double pPrecioRenta,String pDescripcion,String pDireccion,
                int pNumHabitaciones,int pNumPlantas,String pServicios,String pColor,String pMaterial,
                String pPropietario,String pTipo){
        super(pId,pPrecioVenta,pPrecioRenta,pDescripcion,pDireccion);
        this.numeroHabitaciones = pNumHabitaciones;
        this.numeroPlantas      = pNumPlantas;
        this.serviciosBasicos   = pServicios;
        this.color              = pColor;
        this.material           = pMaterial;
        this.propietario        = pPropietario;
        this.tipo               = pTipo;
    }
    //Numero de Habitaciones
    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }
    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }
    //Numero de plantas
    public int getNumeroPlantas() {
        return numeroPlantas;
    }
    public void setNumeroPlantas(int numeroPlantas) {
        this.numeroPlantas = numeroPlantas;
    }
    //Servicios Basicos
    public String getServiciosBasicos() {
        return serviciosBasicos;
    }
    public void setServiciosBasicos(String serviciosBasicos) {
        this.serviciosBasicos = serviciosBasicos;
    }
    //Color
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    //Material
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    //Propietario-Cliente
    public String getPropietario() {
        return propietario;
    }
    public void setPropietario(String pPropietario) {
        this.propietario = pPropietario;
    }
    //Tamaño
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
