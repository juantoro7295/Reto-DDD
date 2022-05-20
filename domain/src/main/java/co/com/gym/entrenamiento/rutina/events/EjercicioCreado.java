package co.com.gym.entrenamiento.rutina.events;

import co.com.gym.entrenamiento.rutina.values.DetalleEjercicio;
import co.com.gym.entrenamiento.rutina.values.EjercicioId;
import co.com.gym.entrenamiento.rutina.values.Intensidad;
import co.com.sofka.domain.generic.DomainEvent;

public class EjercicioCreado extends DomainEvent {

    private final EjercicioId ejercicioId;
    private final String nombreEjercicio;
    private final DetalleEjercicio detalleEjercicio;
    private final Intensidad intensidad;

    public EjercicioCreado(String type, EjercicioId ejercicioId, String nombreEjercicio,
                           DetalleEjercicio detalleEjercicio, Intensidad intensidad) {
        super("co.com.gym.entrenamiento.EjercicioCreado");
        this.ejercicioId = ejercicioId;
        this.nombreEjercicio = nombreEjercicio;
        this.detalleEjercicio = detalleEjercicio;
        this.intensidad = intensidad;
    }

    public EjercicioId getEjercicioId() {
        return ejercicioId;
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
