package Modelo;

public class Autobus {
     public int idAutobus;
    public String placa;
    public int capacidad;
    public Ruta rutaAsignada = new Ruta();

    public Autobus(int idAutobus, String placa, int capacidad, Ruta rutaAsignada) {
        this.idAutobus = idAutobus;
        this.placa = placa;
        this.capacidad = capacidad;
        this.rutaAsignada = rutaAsignada;
    }

    public Autobus() {
        
    }

    
    @Override
    public String toString() {
        return "Autobús ID: " + idAutobus + ", Placa: " + placa + ", Capacidad: " + capacidad + "rUTA ASIGNADA" + rutaAsignada;

    }
}

