package ar.edu.unahur.obj2.observer.observables;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.observer.Alerta;
import ar.edu.unahur.obj2.observer.exceptions.FueraDeRangoExcepcion;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public class CentralDeMonitoreo implements Observable {
    private List<Observer> observadores;
    private List<RegistroDeAlerta> alertas;
    
    
    public CentralDeMonitoreo() {
        this.observadores = new ArrayList<>();
        this.alertas = new ArrayList<>();
    }

    @Override
    public void agregarObservador(Observer observer) {
        if (!observadores.contains(observer)){
            observadores.add(observer);
        }
    }

    @Override
    public void sacarObservador(Observer obsever) {
        observadores.remove(obsever);
    }

    @Override
    public void notificar(Alerta alerta) {
        observadores.forEach(o -> {
            o.actualizar(alerta);
        });
    }

    //private Alerta ultimaAlerta(){
    //    return alertas.getLast().getAlerta();
    //}

    @Override
    public void emitirAlerta(String tipo, Integer nivel){
        validarRangoNivel(nivel);

        Alerta nuevaAlerta = new Alerta(tipo, nivel);

        alertas.add(new RegistroDeAlerta(nuevaAlerta, observadores.size()));
        notificar(nuevaAlerta);
    }

    private void validarRangoNivel(Integer nivel){
        if (nivel < 1 || nivel > 10){
            throw new FueraDeRangoExcepcion("Nivel de alerta incorrecto");
        }
    }

    @Override
    public Integer cantAlertasNotificadas(){
        return alertas.stream().mapToInt(a -> a.getCantNotificaciones()).sum();
    }

    public void reset(){
        observadores.clear();
        alertas.clear();
    }
}
