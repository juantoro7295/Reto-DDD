package co.com.gym.entrenamiento.rutina.events;

import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.sofka.domain.generic.DomainEvent;

public class RutinaActualizada extends DomainEvent {

    private final RutinaId rutinaId;

    public RutinaActualizada(RutinaId rutinaId) {
        super("co.com.gym.entrenamiento.RutinaActualizada");
        this.rutinaId = rutinaId;
    }

    public RutinaId getRutinaId() {
        return rutinaId;
    }
}
