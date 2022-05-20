package co.com.gym.entrenamiento.instructor.events;

import co.com.gym.entrenamiento.instructor.values.AreaId;
import co.com.sofka.domain.generic.DomainEvent;

public class AreaEliminada extends DomainEvent {

    private final AreaId areaId;

    public AreaEliminada(String type, AreaId areaId) {
        super("co.com.gym.entrenamiento.AreaEliminada");
        this.areaId = areaId;
    }

    public AreaId getAreaId() {
        return areaId;
    }

}
