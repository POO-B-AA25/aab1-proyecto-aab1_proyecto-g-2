package Controlador;

import Modelo.Ruta;
import Modelo.Autobus;
import java.util.ArrayList;
import java.util.List;

public class ControladorAutobus {

    Ruta rutaAsignada = new Ruta();
    Autobus auto = new Autobus();
    List<Autobus> listautobus = new ArrayList();

    public void registrarAutobus(Autobus autobus, int idRuta) {
        auto = autobus;
        listautobus.add(auto);
    }

    public void mostrarAutobus(List<Autobus> listautobus) {
        System.out.println("\n");
        for (int i = 0; i < listautobus.size(); i++) {
            Autobus a = listautobus.get(i);
            System.out.println(a);
        }
    }

    public Ruta asignarRutaBus(int idruta, List <Ruta> rutas) {
        for (int i = 0; i < rutas.size(); i++) {
            rutaAsignada = rutas.get(i);
            
            if (idruta == rutaAsignada.idRuta) {
                rutaAsignada = rutas.get(i);
                System.out.println("Ruta asignada");
                return rutaAsignada;
            } else {
                System.out.println("No existe la ruta...");
            }
        }
        return rutaAsignada;
    }
}