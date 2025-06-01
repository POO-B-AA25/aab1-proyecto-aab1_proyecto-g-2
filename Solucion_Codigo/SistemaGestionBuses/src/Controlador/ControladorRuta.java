package Controlador;

import Modelo.Horario;
import java.util.ArrayList;
import java.util.List;
import Modelo.Parada;
import Modelo.Ruta;
import java.time.LocalTime;
import java.util.Comparator;

public class ControladorRuta {

    List<Horario> horarios = new ArrayList();
    List<Parada> paradas = new ArrayList();

    Ruta ruta = new Ruta();

    public List<Horario> obtenerHorarios() {
        return horarios;
    }

    public boolean esHoraValida(LocalTime horaSalida, LocalTime horaLlegada) {
        return horaSalida.isAfter(horaLlegada);
    }

    public void agregarParada(Parada parada) {
        paradas.add(parada);
    }

    public List<Parada> removerParada(int id_parada, List<Parada> paradas) {
        boolean okDelete = false;
        for (int i = 0; i < paradas.size(); i++) {
            Parada p = paradas.get(i);
            if (p.idParada == id_parada) {
                paradas.remove(p);
                okDelete = true;
                break;
            }
        }
        if (okDelete == true) {
            System.out.println("Parada eliminada");
        } else {
            System.out.println("No existe la parada...");
        }
        return paradas;
    }

    public void mostrarParadas(List<Parada> paradas) {
    if (paradas.isEmpty()) {
        System.out.println("\nNo hay paradas registradas.");
        return;
    }

    System.out.println("\n Las paradas que tienes son: ");
    for (int i = 0; i < paradas.size(); i++) {
        Parada get = paradas.get(i);
        System.out.println(get);
    }
}


    public void mostrarRutas(List<Ruta> rutas) {
        if (rutas.isEmpty()) {
            System.out.println("No hay rutas registradas.");
            return;
        }
        System.out.println("Las rutas que tienes son: ");
        for (Ruta ruta : rutas) {
            System.out.println("\n" + ruta);
        }
    }

    public void mostrarRutasHorarioyParada(List<Ruta> rutas) {
        if (rutas.isEmpty()) {
            System.out.println("No hay rutas registradas.");
            return;
        }
        System.out.println("Las rutas que tienes son: ");
        for (Ruta ruta : rutas) {
            System.out.println("\n" + ruta);
            for (Parada parada : ruta.paradas) {
                System.out.println("  " + parada);
                for (Horario horario : obtenerHorarios()) {
                    System.out.println("    " + horario);
                }
            }
        }
    }

    public void optimizarRuta(List<Ruta> rutas, int seleccion) {
        Ruta ruta = rutas.get(seleccion - 1);
        ruta.paradas.sort(Comparator.comparing(p -> p.nombre));
        System.out.println("Ruta optimizada por orden alfabético de paradas.");
        mostrarRutasHorarioyParada(rutas);
    }

    public void agregarParadaARuta(List<Ruta> rutas) {
        System.out.println("\n");
        if (rutas.isEmpty()) {
            System.out.println("Primero debe crear una ruta.");
            return;
        }
        System.out.println("Seleccione la ruta:");
        mostrarRutas(rutas);

    }
}
