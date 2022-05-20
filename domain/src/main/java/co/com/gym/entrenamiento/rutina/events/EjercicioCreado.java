package co.com.gym.entrenamiento.rutina.events;

import co.com.gym.entrenamiento.rutina.values.DetalleEjercicio;
import co.com.gym.entrenamiento.rutina.values.Intensidad;
import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.sofka.domain.generic.DomainEvent;

public class EjercicioCreado extends DomainEvent {

    private final RutinaId rutinaId;
    private final String nombreEjercicio;
    private final DetalleEjercicio detalleEjercicio;
    private final Intensidad intensidad;

    public EjercicioCreado( RutinaId rutinaId, String nombreEjercicio,
                           DetalleEjercicio detalleEjercicio, Intensidad intensidad) {
        super("co.com.gym.entrenamiento.EjercicioCreado");
        this.rutinaId = rutinaId;
        this.nombreEjercicio = nombreEjercicio;
        this.detalleEjercicio = detalleEjercicio;
        this.intensidad = intensidad;
    }

    public RutinaId getRutinaId() {
        return rutinaId;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public DetalleEjercicio getDetalleEjercicio() {
        return detalleEjercicio;
    }

    public Intensidad getIntensidad() {
        return intensidad;
    }
}
