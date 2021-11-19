package Recursos.Clases;

public class Persona {
    private long   DNI;
    private String nombre;
    private String apellido;
    private int    edad;
    private String direccion;
    private String genero;
    private long   telefono;

    public Persona(){}
    public Persona(long pDni,String pNombre,String pApellido,int pEdad,String pDireccion,String pGenero,long pTelefono){
        this.DNI       = pDni;
        this.nombre    = pNombre;
        this.apellido  = pApellido;
        this.edad      = pEdad;
        this.direccion = pDireccion;
        this.genero    = pGenero;
        this.telefono  = pTelefono;
    }
    //DNI
    public long getDNI() {
        return DNI;
    }
    public void setDNI(long DNI) {
        this.DNI = DNI;
    }
    //Nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Apellido
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    //Edad
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    //Direccion
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    //Genero
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    //Telefono
    public long getTelefono() {
        return telefono;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
}
