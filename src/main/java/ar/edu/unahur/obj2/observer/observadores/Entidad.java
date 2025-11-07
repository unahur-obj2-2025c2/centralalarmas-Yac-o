package ar.edu.unahur.obj2.observer.observadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ar.edu.unahur.obj2.observer.Alerta;
import ar.edu.unahur.obj2.observer.observadores.comportamientos.*;

public class Entidad implements Observer {
    private final String nombre;
    private Comportamiento comportamientoActual;
    private List<Alerta> alertasRecibidas;
    
    public Entidad(String nombre) {
        this.nombre = nombre;
        this.comportamientoActual = RiesgoCritico.getInstance();
        alertasRecibidas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Alerta> getAlertasRecibidas() {
        return alertasRecibidas;
    }

    public Comportamiento getComportamientoActual() {
        return comportamientoActual;
    }

    public void setComportamientoActual(Comportamiento comportamientoActual) {
        this.comportamientoActual = comportamientoActual;
    }

    @Override
    public void actualizar(Alerta alerta) {
        alertasRecibidas.add(alerta);
    }

    public Double riesgo(){
        return alertasRecibidas.isEmpty()? 0.0 : comportamientoActual.calcularRiesgo(alertasRecibidas);
    }

    public void resetAlertas(){
        alertasRecibidas.clear();
    }

    //  BONUS
    public Alerta alertaDeMayorNivel(){
        return alertasRecibidas.stream()
            .max(Comparator.comparingInt(Alerta::getNivel))
            .orElse(new Alerta("temp", 0));
    }
    //TODO Testear si efectivamente responde la primera que ocurrio.
}
