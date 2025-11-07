package ar.edu.unahur.obj2.observer.observadores.comportamientos;

import java.util.List;

import ar.edu.unahur.obj2.observer.Alerta;

public interface Comportamiento {
    Double calcularRiesgo(List<Alerta> alertas);
}
