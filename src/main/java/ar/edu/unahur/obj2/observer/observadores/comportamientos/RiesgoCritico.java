package ar.edu.unahur.obj2.observer.observadores.comportamientos;

import java.util.List;

import ar.edu.unahur.obj2.observer.Alerta;

public class RiesgoCritico implements Comportamiento {
    private final static RiesgoCritico instance = new RiesgoCritico();
    
    private RiesgoCritico(){}

    public static RiesgoCritico getInstance(){
        return instance;
    }
    
    @Override
    public Double calcularRiesgo(List<Alerta> alertas) {
        Double riesgo = Double.valueOf(alertas.getLast().getNivel());
        return (riesgo >= 8) ? 10.0 : riesgo;
    }
}
