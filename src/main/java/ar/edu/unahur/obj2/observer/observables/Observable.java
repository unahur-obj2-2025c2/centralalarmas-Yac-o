package ar.edu.unahur.obj2.observer.observables;

import ar.edu.unahur.obj2.observer.Alerta;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public interface Observable {
    void agregarObservador(Observer observer);

    void sacarObservador(Observer obsever);

    void notificar(Alerta alerta);

    void emitirAlerta(String tipo, Integer nivel);

    Integer cantAlertasNotificadas();
}
