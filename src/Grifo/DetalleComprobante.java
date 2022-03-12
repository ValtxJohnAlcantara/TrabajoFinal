package Grifo;

public class DetalleComprobante {
    public Producto producto;
    public Double cantidad;
    public Double igv;
    public Double subtotal;
    public Double total;
    public DetalleComprobante() {
    }
    public DetalleComprobante(Producto producto, Double total) {
        this.producto = producto;
        this.total = total;
        this.cantidad = total/producto.getPrecioVenta();
        this.igv = (total/118)*18;
        this.subtotal = (total/118)*100;        
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Double getCantidad() {
        return cantidad;
    }
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    public Double getIgv() {
        return igv;
    }
    public void setIgv(Double igv) {
        this.igv = igv;
    }
    public Double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    
}
