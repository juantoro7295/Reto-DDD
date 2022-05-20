package co.com.gym.entrenamiento.personalizado.events;

import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.sofka.domain.generic.DomainEvent;

public class RutinaEliminada extends DomainEvent {

    private final RutinaId rutinaId;

    public RutinaEliminada(String type, RutinaId rutinaId) {
        super("co.com.gym.entrenamiento.RutinaEliminada");
        this.rutinaId = rutinaId;
    }

    public RutinaId getRutinaId() {
        return rutinaId;
    }
}
