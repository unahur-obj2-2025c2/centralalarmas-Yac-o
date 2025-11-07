package ar.edu.unahur.obj2.observer.observadores.comportamientos;

import java.util.List;

import ar.edu.unahur.obj2.observer.Alerta;

public class RiesgoVariable implements Comportamiento {
    /*
     * El calculo del riesgo variable depende de si esta o no confirmado.
     * en caso de confirmado, el riesgo sera de 9, sino el riesgo sera el nivel de la ultima alerta.
     */

    private Boolean esRiesgoConfirmado;

    public RiesgoVariable(Boolean esRiesgoConfirmado){
        this.esRiesgoConfirmado = esRiesgoConfirmado;
    }

    @Override
    public Double calcularRiesgo(List<Alerta> alertas) {
        return esRiesgoConfirmado? 9.0 : alertas.getLast().getNivel();
    }
}
