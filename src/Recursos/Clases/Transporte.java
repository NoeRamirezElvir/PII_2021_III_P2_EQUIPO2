package Recursos.Clases;

import java.util.Date;

public class Transporte extends BienesMuebles{
    private String Nombre;
    private String Marca;
    private String Modelo;
    private int Capacidad;
    private int NoEjes;
    private int CaballosFuerza;
    private String LugarFabricacion;
    public Transporte(){
        super();
    }
    public Transporte(int pID, double pPrecio, double pPeso, String pDescripcion,
                      Date pFechaIngreso, int pGarantia, String pNombre, String pMarca, String pModelo,
                      int pCapacidad, int pNoejes, int pCaballosFuerza, String pLugarFabricacion){
        super(pID,pPrecio,pPeso,pDescripcion,pFechaIngreso,pGarantia);
        this.Nombre           = pNombre;
        this.Marca            = pMarca;
        this.Modelo           = pModelo;
        this.Capacidad        = pCapacidad;
        this.NoEjes           = pNoejes;
        this.CaballosFuerza   = pCaballosFuerza;
        this.LugarFabricacion = pLugarFabricacion;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int capacidad) {
        Capacidad = capacidad;
    }

    public int getNoEjes() {
        return NoEjes;
    }

    public void setNoEjes(int noEjes) {
        NoEjes = noEjes;
    }

    public int getCaballosFuerza() {
        return CaballosFuerza;
    }

    public void setCaballosFuerza(int caballosFuerza) {
        CaballosFuerza = caballosFuerza;
    }

    public String getLugarFabricacion() {
        return LugarFabricacion;
    }

    public void setLugarFabricacion(String lugarFabricacion) {
        LugarFabricacion = lugarFabricacion;
    }
}
