
import java.util.*;

public class GrafoCiudades {

    public Map<String, Map<String, Integer>> grafo;

    public GrafoCiudades() {
        grafo = new HashMap<>();
        inicializarRutas();
    }

    public void agregarRuta(String a, String b, int km) {
        grafo.putIfAbsent(a, new HashMap<>());
        grafo.putIfAbsent(b, new HashMap<>());
        grafo.get(a).put(b, km);
        grafo.get(b).put(a, km);
    }

    public void inicializarRutas() {
        agregarRuta("Quito", "Ambato", 150);
        agregarRuta("Quito", "Guayaquil", 421);
        agregarRuta("Ambato", "Cuenca", 330);
        agregarRuta("Guayaquil", "Cuenca", 197);
        agregarRuta("Cuenca", "Loja", 214);
        agregarRuta("Loja", "Quito", 669);
        agregarRuta("Ambato", "Guayaquil", 390);
        agregarRuta("Ambato", "Loja", 510);
        agregarRuta("Guayaquil", "Loja", 340);
        agregarRuta("Quito", "Cuenca", 450);
    }

    public Set<String> getCiudades() {
        return grafo.keySet();
    }

    public int obtenerDistancia(String origen, String destino) {
        if (grafo.containsKey(origen) && grafo.get(origen).containsKey(destino)) {
            return grafo.get(origen).get(destino);
        }
        return -1;
    }

    public String estimarTiempo(String origen, String destino) {
        double velocidad = 60;
        int distancia = obtenerDistancia(origen, destino);

        if (distancia > 0) {
            double tiempo = distancia / velocidad;
            int horas = (int) tiempo;
            int minutos = (int) Math.round((tiempo - horas) * 60);
            return horas + " horas y " + minutos + " minutos";
        } else {
            return "No disponible";
        }
    }    
}