package ar.edu.unahur.obj2.observer.observadores.comportamientos;

import java.util.List;

import ar.edu.unahur.obj2.observer.Alerta;

public class RiesgoAcumulativo implements Comportamiento {
    private final static RiesgoAcumulativo instance = new RiesgoAcumulativo();
    
    private RiesgoAcumulativo(){}

    public static RiesgoAcumulativo getInstance(){
        return instance;
    }

    @Override
    public Double calcularRiesgo(List<Alerta> alertas) {
        return Double.valueOf(alertas.getLast().getNivel() + alertas.get(alertas.size() - 2).getNivel());
        //TODO Verificar a que se refiere el enunciado, esto suma las dos ultimas.
    }
}
