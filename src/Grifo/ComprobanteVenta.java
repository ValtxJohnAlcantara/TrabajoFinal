package Grifo;

import java.util.Date;
import java.util.List;

public class ComprobanteVenta {
    public Date fecha;
    public Vendedor vendedor;
    public Sede sede;
    public String tipoComprobante; //Boleta o Factura
    public String docCliente; //dni o ruc
    public Double importesubTotal;
    public Double importeIGV;
    public Double importeTotal;
    public List<DetalleComprobante> detalleVenta;

    public ComprobanteVenta(){}

    public ComprobanteVenta(Vendedor vendedor, Sede sede, String tipoComprobante, String docCliente) {
        this.vendedor = vendedor;
        this.sede = sede;
        this.tipoComprobante = tipoComprobante;
        this.docCliente = docCliente;
        this.importesubTotal = .0;
        this.importeIGV = .0;
        this.importeTotal = .0;
        this.fecha = new Date();
        
    }



    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getDocCliente() {
        return docCliente;
    }

    public void setDocCliente(String docCliente) {
        this.docCliente = docCliente;
    }

    public Double getImportesubTotal() {
        return importesubTotal;
    }

    public void setImportesubTotal(Double importesubTotal) {
        this.importesubTotal = importesubTotal;
    }

    public Double getImporteIGV() {
        return importeIGV;
    }

    public void setImporteIGV(Double importeIGV) {
        this.importeIGV = importeIGV;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    @Override
    public String toString() {
        return "ComprobanteVenta [docCliente=" + docCliente + ", fecha=" + fecha + ", importeIGV=" + importeIGV
                + ", importeTotal=" + importeTotal + ", importesubTotal=" + importesubTotal + ", sede=" + sede
                + ", tipoComprobante=" + tipoComprobante + ", vendedor=" + vendedor + "]";
    }
    
}
