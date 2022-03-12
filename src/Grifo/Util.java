package Grifo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;   

public class Util {
    public static ComprobanteVenta crearVenta(Sede sede, Vendedor vendedor, String tipoComprobante, String docCliente)
    {
        ComprobanteVenta comprobante = new ComprobanteVenta();
        
        comprobante.setFecha(new Date());
        comprobante.setSede(sede);
        comprobante.setVendedor(vendedor);
        comprobante.setDocCliente(docCliente);
        comprobante.setTipoComprobante(tipoComprobante);
        comprobante.setImporteIGV(0.0);
        comprobante.setImporteTotal(0.0);
        comprobante.setImportesubTotal(0.0);

        return comprobante;
    }
    public static ComprobanteVenta agregarDetalle(ComprobanteVenta compVenta, DetalleComprobante detalleVenta)
    {
        if(compVenta.detalleVenta == null)
        {
            List<DetalleComprobante> detalles = new ArrayList<DetalleComprobante>();
            compVenta.detalleVenta = detalles;
        }
        compVenta.detalleVenta.add(detalleVenta);
        compVenta.setImporteIGV(compVenta.getImporteIGV() + detalleVenta.getIgv());
        compVenta.setImportesubTotal(compVenta.getImportesubTotal() + detalleVenta.getSubtotal());
        compVenta.setImporteTotal(compVenta.getImporteTotal() + detalleVenta.getTotal());
        return compVenta;
    }
    
    public ComprobanteVenta crearVenta(Vendedor vendedor, Sede sede, String tipoComprobante, String docCliente)
    {
        Scanner tecComp = new Scanner(System.in);
        System.out.println("Seleccione tipo comprobante:\n"+
                                        "1. Boleta\n"+
                                        "2. Factura");
        
        if (tecComp.nextInt() == 1)
        {
            tipoComprobante = "Boleta";
            System.out.println("Ingrese DNI de cliente:");
        }
        else
        {
            tipoComprobante = "Factura";
            System.out.println("Ingrese Ruc de cliente:");
        }
        docCliente = tecComp.next();
        
        ComprobanteVenta comprobante = new ComprobanteVenta(vendedor, sede, tipoComprobante, docCliente);
        detallecomprobante(comprobante);
        
        return comprobante;
    }

    public void detallecomprobante(ComprobanteVenta venta){
        Scanner tec = new Scanner(System.in);
        System.out.println("Seleccione producto:");
        int cont = 1;
        for(Producto item : venta.sede.getProductos())
        {
            System.out.println((cont) + ". " + item.getNombre() + ".");
            cont++;
        }
        cont = tec.nextInt();
        System.out.println("Ingrese importe:");

        DetalleComprobante detalle = new DetalleComprobante(venta.sede.getProductos().get(cont-1), tec.nextDouble());
        venta = agregarDetalle(venta, detalle);

        System.out.println("Para continuar agregando productos presione 1, para cerrar venta presione 0.");
        switch(tec.nextInt()){
        case 1:
            detallecomprobante(venta);
            break;
        case 0:
            mostrarComprobante(venta);
            break;
        }        
        //tec.close();
    }

    public static String redondear(Double numero)
    {
        return String.format("%.2f", numero);
    }

    public static Sede registrarSede(){
        List<Producto> productos = new ArrayList<Producto>();

        Producto gasolina95 = new Producto("0001","Gasolina 95","",10000.0,17.50);
        Producto gasolina97 = new Producto("0002","Gasolina 97","",10000.0,18.50);
        Producto gasolina98 = new Producto("0003","Gasolina 98","",10000.0,19.50);
        Producto GLP = new Producto("0004","Combustible GLP","",10000.0,8.90);
        Producto GNV = new Producto("0005","Combustible GNV","",10000.0,1.80);

        productos.add(gasolina95);
        productos.add(gasolina97);
        productos.add(gasolina98);
        productos.add(GLP);
        productos.add(GNV);

        Sede sede = new Sede("0001","Villasol I","", productos);
        return sede;
    }
    public static void mostrarComprobante(ComprobanteVenta venta){
        System.out.println("DETALLE DE VENTA\n----------------------------------------------------------");
        System.out.println("Sede: " + venta.sede.getNombre()+ "\tVendedor: " + venta.vendedor.getNombre() + " " + venta.vendedor.getApeMat() +
                            "\nComprobante: "+venta.getTipoComprobante()+"\tDocumento: " + venta.getDocCliente());
        
        System.out.println("\nCÓDIGO\tPTODUCTO\tCANTIDAD\tPRECIO\n----------------------------------------------------------");
        for(DetalleComprobante item : venta.detalleVenta)
        {
            System.out.println(item.producto.getCodigoProducto() + "\t"
                                +item.producto.getNombre() + "\t"
                                +redondear(item.getCantidad()) +"\t\t"
                                +redondear(item.getTotal()));    
        }
        System.out.println("\nSubtotal: \t" + redondear(venta.importesubTotal) + "\n"
                            +"IGV: \t\t" + redondear(venta.importeIGV) + "\n" 
                            +"Total: \t\t" + redondear(venta.importeTotal));
    }
    public static int mostrarMenu()
    {
        Scanner tec = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------");
        System.out.println("Seleccione una opción:\n"+
                            "1. Realizar una venta\n"+
                            "2. Ver productos\n"+
                            "3. Ver reporte\n"+
                            "4. Generar Reporte\n"+
                            "5. Salir del Sistema");
        int result = tec.nextInt();
        //tec.close();
        return result;
    }
    public void listarProductos(Sede sede){
        System.out.println("PRODUCTOS:\n--------------------------------------------------\n"+
                            "Código\tNombre\t\t\tPrecio\tStock");
        for(Producto item : sede.getProductos())
        {
            System.out.println(item.getCodigoProducto() + "\t"+ item.getNombre() + "\t\t" + item.getPrecioVenta() + "\t" + item.getStock());
        }
    }
    public void verReporteVentas(List<ComprobanteVenta> ventas)
    {
        System.out.println("REPORTE DE VENTAS:\n------------------------------------------------------------\n"+
                            "Item\tFecha\t\t\tComprobante\tCliente\t\tImporte");
        int cont = 1;
        Double total = 0.0;
        for(ComprobanteVenta item : ventas)
        {
            System.out.println(cont + "\t"+ item.getFecha().toLocaleString() + "\t" +item.getTipoComprobante() + "\t\t" +
                                item.getDocCliente() + "\t" + item.getImporteTotal());
            total += item.importeTotal;
            cont++;
        }
        System.out.println("\nTOTAL DE VENTAS: "+total);
    }
    public void generarReporte(List<ComprobanteVenta> ventas){
        java.io.File archivoTexto = new java.io.File("D:/Proyectos/UTP/Verano/Reportes/ReportesGrifo.txt");
        if (archivoTexto.exists()) {
            System.out.println("Archivo ya existe");
            System.exit(0);
        }
        java.io.PrintWriter salida;
        try {
            salida = new java.io.PrintWriter(archivoTexto);

            salida.println("REPORTE DE VENTAS:\n-----------------------------------------------------------------\n"+
                            "Item\tFecha\t\t\tComprobante\tCliente\t\tImporte");
            int cont = 1;
            Double total = 0.0;
            for(ComprobanteVenta item : ventas)
            {
                salida.println(cont + "\t"+ item.getFecha().toLocaleString() + "\t" +item.getTipoComprobante() + "\t\t" +
                                    item.getDocCliente() + "\t" + item.getImporteTotal());
                total += item.importeTotal;
                cont++;
            }
            salida.println("\nTOTAL DE VENTAS: "+total);

            // Cierre de fichero
            salida.close();
            System.out.println("Se generó el reporte solicitado.");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public List<ComprobanteVenta> procesarMenu(List<ComprobanteVenta> ventas, int opcion, Vendedor vendedor, Sede sede, String tipoComprobante, String docCliente)
    {
        switch (opcion){
            case 1: ComprobanteVenta venta = crearVenta(vendedor, sede, tipoComprobante,docCliente);      
                    ventas.add(venta);break;
            case 2: listarProductos(sede);break;
            case 3: verReporteVentas(ventas);break;
            case 4: generarReporte(ventas);break;
        }    
        return ventas;
    }
}
