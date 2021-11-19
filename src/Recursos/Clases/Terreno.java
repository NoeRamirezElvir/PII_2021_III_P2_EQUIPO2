package Recursos.Clases;

public class Terreno extends BienesInmuebles{
    private String dimension;
    private String tipoSuelo;
    private String orientacionTerreno;
    private String tipoServicios;
    private String categoria;
    private String altitud;
    private String tipoUso;

    public Terreno(){super();}
    public Terreno(int pId,double pPrecioVenta,double pPrecioRenta,String pDescripcion,String pDireccion,
                   String pDimension,String pTipoSuelo,String pOrientacion,String pTipoServicios,String pCategoria,
                   String pAltitud,String ptipoUso){
        super(pId,pPrecioVenta,pPrecioRenta,pDescripcion,pDireccion);
        this.dimension          = pDimension;
        this.tipoSuelo          = pTipoSuelo;
        this.orientacionTerreno = pOrientacion;
        this.tipoServicios      = pTipoServicios;
        this.categoria          = pCategoria;
        this.altitud            = pAltitud;
        this.tipoUso            = ptipoUso;
    }
    //Dimension
    public String getDimension() {
        return dimension;
    }
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
    //Tipo de Suelo
    public String getTipoSuelo() {
        return tipoSuelo;
    }
    public void setTipoSuelo(String tipoSuelo) {
        this.tipoSuelo = tipoSuelo;
    }
    //Orientacion del terreno
    public String getOrientacionTerreno() {
        return orientacionTerreno;
    }
    public void setOrientacionTerreno(String orientacionTerreno) {
        this.orientacionTerreno = orientacionTerreno;
    }
    //Tipo de Servicios
    public String getTipoServicios() {
        return tipoServicios;
    }
    public void setTipoServicios(String tipoServicios) {
        this.tipoServicios = tipoServicios;
    }
    //Categoria
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    //Altitud
    public String getAltitud() {
        return altitud;
    }
    public void setAltitud(String altitud) {
        this.altitud = altitud;
    }
    //Tipo de Uso
    public String getTipoUso() {
        return tipoUso;
    }
    public void setTipoUso(String tipoUso) {
        this.tipoUso = tipoUso;
    }
}
