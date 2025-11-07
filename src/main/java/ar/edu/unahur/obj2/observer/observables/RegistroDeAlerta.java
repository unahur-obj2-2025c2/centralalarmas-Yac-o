package ar.edu.unahur.obj2.observer.observables;

import ar.edu.unahur.obj2.observer.Alerta;

public class RegistroDeAlerta {
    private Alerta alerta;
    private Integer cantNotificaciones;

    public RegistroDeAlerta(Alerta alerta, Integer cantNotificaciones) {
        this.alerta = alerta;
        this.cantNotificaciones = cantNotificaciones;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public Integer getCantNotificaciones() {
        return cantNotificaciones;
    }
}
