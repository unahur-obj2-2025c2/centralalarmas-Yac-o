package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.exceptions.FueraDeRangoExcepcion;
import ar.edu.unahur.obj2.observer.observables.CentralDeMonitoreo;
import ar.edu.unahur.obj2.observer.observadores.Entidad;
import ar.edu.unahur.obj2.observer.observadores.comportamientos.RiesgoPromedio;

public class CentralDeMonitoreoTest {
    CentralDeMonitoreo central = new CentralDeMonitoreo();
    Entidad e1 = new Entidad("Bomberos");
    Entidad e2 = new Entidad("Hospital Aleman");

    @BeforeEach
    void setUp(){
        central.agregarObservador(e1);
        central.agregarObservador(e2);
    }

    @AfterEach
    void cleanUp(){
        central.reset();
        e1.resetAlertas();
        e2.resetAlertas();
    }

    @Test
    void dadoElSetUp_alAgregarAlertas_SeVerificaCorretamenteLasAlertasRecibidasYElRiesgo(){
        central.emitirAlerta("calor", 6);
        central.emitirAlerta("lluvia", 8);

        assertTrue(e1.getAlertasRecibidas().size() == 2);
        assertTrue(e2.getAlertasRecibidas().size() == 2);

        assertEquals(10.0, e1.riesgo());
        assertEquals(10.0, e2.riesgo());

    }

    @Test
    void dadoElSetUp_alCambiarElComportamientoYAgregarAlertas_SeVerificaCorretamenteLasAlertasRecibidasYElRiesgo(){
        e1.setComportamientoActual(RiesgoPromedio.getInstance());

        central.emitirAlerta("calor", 6);
        central.emitirAlerta("lluvia", 8);

        assertTrue(e1.getAlertasRecibidas().size() == 2);
        assertTrue(e2.getAlertasRecibidas().size() == 2);

        assertEquals(7.0, e1.riesgo());
        assertEquals(10., e2.riesgo());
    }

    @Test
    void dadoElSetUp_alAgregarAlertasQuitarUnaEntidadYAgregaNuevaAlerta_SeVerificaCorretamenteLasAlertasRecibidasYElRiesgo(){
        central.emitirAlerta("calor", 6);
        central.emitirAlerta("lluvia", 8);
        central.sacarObservador(e1);
        central.emitirAlerta("granizo", 7);

        assertEquals(2, e1.getAlertasRecibidas().size());
        assertEquals(10, e1.riesgo());

        assertEquals(3, e2.getAlertasRecibidas().size());
        assertEquals(7, e2.riesgo());

        assertEquals(5, central.cantAlertasNotificadas());
    }

    @Test
    void excepcionAlEmitirUnaAlertaConNivel_0_ONivel_11_ONivelNegativo(){

        assertThrowsExactly(FueraDeRangoExcepcion.class, () -> {
            central.emitirAlerta("lluevenSoretesDePunta", 0);
        });

        assertThrowsExactly(FueraDeRangoExcepcion.class, () -> {
            central.emitirAlerta("vientoDelSur", 11);
        });

        assertThrowsExactly(FueraDeRangoExcepcion.class, () -> {
            central.emitirAlerta("TORMEEEEENTA", -19);
        });
    }

    //  BONUS

}
