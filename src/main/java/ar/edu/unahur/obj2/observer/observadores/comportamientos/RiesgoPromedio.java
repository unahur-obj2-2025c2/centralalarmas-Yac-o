package ar.edu.unahur.obj2.observer.observadores.comportamientos;

import java.util.List;

import ar.edu.unahur.obj2.observer.Alerta;

public class RiesgoPromedio implements Comportamiento {
    private final static RiesgoPromedio instance = new RiesgoPromedio();
    
    private RiesgoPromedio(){}

    public static RiesgoPromedio getInstance(){
        return instance;
    }

    @Override
    public Double calcularRiesgo(List<Alerta> alertas) {
        return alertas.stream().mapToDouble(a -> a.getNivel()).sum() / alertas.size();
    }
}
