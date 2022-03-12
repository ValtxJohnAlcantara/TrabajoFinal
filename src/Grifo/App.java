package Grifo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {
        Util logica = new Util();
        String tipoComprobante = "";
        String docCliente = "";
        
        //Registro de Vendedor
        Vendedor vendedor = new Vendedor("John","Alcantara","De la Cruz","0001","45879497");

        //Registro de sede
        Sede sede = logica.registrarSede();
         
        //Declarando variables
        Scanner tec = new Scanner(System.in);
        List<ComprobanteVenta> ventas = new ArrayList<ComprobanteVenta>();
        System.out.println("---------------------------------------------------------------\n");
        System.out.println("BIENVENIDO AL SISTEMA DE VENTAS GRIFO");
        int opcion = 0;
        int flag = 1;
        while(flag != 0)
        {
            opcion = logica.mostrarMenu();
            if(opcion != 5)
            {
                ventas = logica.procesarMenu(ventas, opcion, vendedor, sede, tipoComprobante, docCliente);
                System.out.println("\n Para continuar presione 1, para salir presione 0.");
                flag = tec.nextInt();
            }
            else flag = 0;
        }
        
    }
 
}
