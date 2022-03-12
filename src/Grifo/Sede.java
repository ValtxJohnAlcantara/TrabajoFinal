package Grifo;

import java.util.List;

public class Sede{
    private String codigoSede;
    private String nombre;
    private String direccion;
    private List<Producto> productos;
    private List<Vendedor> vendedores;

    public Sede(){}
    public Sede(String codigoSede, String nombre, String direccion, List<Producto> productos) {
        this.codigoSede = codigoSede;
        this.nombre = nombre;
        this.direccion = direccion;
        this.productos = productos;
    }
    public String getCodigoSede() {
        return codigoSede;
    }
    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public List<Producto> getProductos() {
        return productos;
    }
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    public List<Vendedor> getVendedores() {
        return vendedores;
    }
    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }
    
    
}