package Recursos.Clases;

import java.util.Date;

public class Articulos extends BienesMuebles {
    private long NoLote;
    private String Material;
    private String Categoria;
    private String Estilo;
    private String Color;
    private String Tamanio;
    private String Marca;
    public Articulos(){
        super();
    }
    public Articulos(int pID, double pPrecio, double pPeso, String pDescripcion,
                     Date pFechaIngreso, int pGarantia,long pNoLote,  String pMaterial, String pCategoria,
                     String pEstilo, String pColor,  String pTamanio,  String pMarca) {
        super(pID, pPrecio, pPeso, pDescripcion, pFechaIngreso, pGarantia);
        this.NoLote = pNoLote;
        this.Material = pMaterial;
        this.Categoria = pCategoria;
        this.Estilo = pEstilo;
        this.Color = pColor;
        this.Tamanio = pTamanio;
        this.Marca = pMarca;
    }

    public long getNoLote() {
        return NoLote;
    }

    public void setNoLote(long noLote) {
        NoLote = noLote;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getEstilo() {
        return Estilo;
    }

    public void setEstilo(String estilo) {
        Estilo = estilo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getTamanio() {
        return Tamanio;
    }

    public void setTamanio(String tamanio) {
        Tamanio = tamanio;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }
}
