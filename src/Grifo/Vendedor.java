package Grifo;

public class Vendedor {
    private String nombre;
    private String apePat;
    private String apeMat;
    private String codigoVendedor;
    private String dniVendedor;

    public Vendedor(){}
    public Vendedor(String nombre, String apePat, String apeMat, String codigoVendedor, String dniVendedor) {
        this.nombre = nombre;
        this.apePat = apePat;
        this.apeMat = apeMat;
        this.codigoVendedor = codigoVendedor;
        this.dniVendedor = dniVendedor;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApePat() {
        return apePat;
    }
    public void setApePat(String apePat) {
        this.apePat = apePat;
    }
    public String getApeMat() {
        return apeMat;
    }
    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }
    public String getCodigoVendedor() {
        return codigoVendedor;
    }
    public void setCodigoVendedor(String codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }
    public String getDniVendedor() {
        return dniVendedor;
    }
    public void setDniVendedor(String dniVendedor) {
        this.dniVendedor = dniVendedor;
    }

    
    
}
