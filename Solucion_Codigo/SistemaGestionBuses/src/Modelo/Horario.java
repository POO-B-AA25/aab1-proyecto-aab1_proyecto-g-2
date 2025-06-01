package Modelo;

import java.time.LocalTime;


public class Horario {
    public int idHorario;
    public LocalTime horaLlegada;
    public LocalTime horaSalida;

    public Horario(int idHorario, LocalTime horaLlegada, LocalTime horaSalida) {
        this.idHorario = idHorario;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
    }

    public Horario(){
        
        
    }
    @Override
    public String toString() {
        return "Horario ID: " + idHorario + ", Llegada: " + horaLlegada + ", Salida: " + horaSalida;
    }
    
    
}

