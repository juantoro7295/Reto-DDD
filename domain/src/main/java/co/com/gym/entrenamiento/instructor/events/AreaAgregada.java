package co.com.gym.entrenamiento.instructor.events;

import co.com.gym.entrenamiento.instructor.values.AreaId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class AreaAgregada extends DomainEvent {

    private final AreaId areaId;
    private final String nombreArea;
    private final Descripcion descripcion;

    public AreaAgregada(String nombreArea, Descripcion descripcion, AreaId areaId) {
        super("co.com.gym.entrenamiento.AreaAgregada");
        this.areaId = areaId;
        this.nombreArea = nombreArea;
        this.descripcion = descripcion;
    }

    public AreaId getAreaId() {
        return areaId;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
