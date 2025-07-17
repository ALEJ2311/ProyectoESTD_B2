
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GrafoCiudades grafo = new GrafoCiudades();
        Scanner tcl = new Scanner(System.in);
        boolean seguir = true;

        while (seguir) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Consultar distancia entre ciudades");
            System.out.println("2. Anadir nueva ruta");
            System.out.println("3. Eliminar una ruta");
            System.out.println("4. Salir");
            System.out.print("Elija una opcion: ");
            String opcion = tcl.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("\nCiudades disponibles:");
                    for (String ciudad : grafo.getCiudades()) {
                        System.out.println("- " + ciudad);
                    }

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
                    break;

                case "2":
                    System.out.print("Ingrese ciudad de origen: ");
                    String nuevaOrigen = tcl.nextLine();

                    System.out.print("Ingrese ciudad de destino: ");
                    String nuevaDestino = tcl.nextLine();

                    System.out.print("Ingrese distancia en km: ");
                    int nuevaDistancia = Integer.parseInt(tcl.nextLine());

                    grafo.agregarRuta(nuevaOrigen, nuevaDestino, nuevaDistancia);
                    System.out.println("Ruta añadida con éxito.");
                    break;

                case "3":
                    System.out.print("Ciudad de origen de la ruta a eliminar: ");
                    String eliminarOrigen = tcl.nextLine();

                    System.out.print("Ciudad de destino de la ruta a eliminar: ");
                    String eliminarDestino = tcl.nextLine();

                    grafo.eliminarRuta(eliminarOrigen, eliminarDestino);
                    System.out.println("Ruta eliminada.");
                    break;

                case "4":
                    System.out.println("Saliendo...");
                    seguir = false;
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
