package co.com.gym.entrenamiento.instructor.events;

import co.com.gym.entrenamiento.instructor.values.EspecializacionId;
import co.com.sofka.domain.generic.DomainEvent;

public class EspecializacionEliminada extends DomainEvent {

    private EspecializacionId especializacionId;

    public EspecializacionEliminada(String type, EspecializacionId especializacionId) {
        super("co.com.gym.entrenamiento.EspecializacionEliminada");
        this.especializacionId = especializacionId;
    }

    public EspecializacionId getEspecializacionId() {
        return especializacionId;
    }
}
