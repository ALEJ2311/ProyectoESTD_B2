
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GrafoCiudades grafo = new GrafoCiudades();
        boolean seguir = true;
        while (seguir) {
            System.out.println("Ciudades disponibles:");
            for (String ciudad : grafo.getCiudades()) {
                System.out.println("- " + ciudad);
            }

            Scanner tcl = new Scanner(System.in);
            System.out.print("\nCiudad de origen: ");
            String origen = tcl.nextLine();

            System.out.print("Ciudad de destino: ");
            String destino = tcl.nextLine();

            int distancia = grafo.obtenerDistancia(origen, destino);

            if (distancia != -1) {
                System.out.println("La distancia entre " + origen + " y " + destino + " es: " + distancia + " km.");
                String tiempo = grafo.estimarTiempo(origen, destino);
                System.out.println("Tiempo estimado de viaje: " + tiempo);
            } else {
                System.out.println("No hay una ruta directa entre esas dos ciudades.");
            }

            System.out.println("Desea informacion de mas ciudades? S/N");
            String opcion = tcl.nextLine();
            if (opcion.equalsIgnoreCase("S")) {
                seguir = true;
            } else {
                if (opcion.equalsIgnoreCase("n")) {
                    System.out.println("Saliendo...");
                    seguir = false;
                }
            }            
        }                
    }    
}
