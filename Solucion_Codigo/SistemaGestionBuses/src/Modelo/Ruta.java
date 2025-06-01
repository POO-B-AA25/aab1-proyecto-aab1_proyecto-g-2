package Modelo;

import java.util.List;

public class Ruta {
    public int idRuta;
    public String nombreRuta;
    public List<Parada> paradas;
    public List<Horario> horarios;

    public Ruta(int idRuta, String nombreRuta) {
        this.idRuta = idRuta;
        this.nombreRuta = nombreRuta;
        this.paradas = paradas;
    }

    public Ruta() {

    }
    
     @Override
    public String toString(){
        return "\nID de Ruta: " + idRuta + "\nNombre de Ruta: " + nombreRuta;
    }
}

