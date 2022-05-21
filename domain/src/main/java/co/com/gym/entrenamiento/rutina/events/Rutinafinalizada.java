package co.com.gym.entrenamiento.rutina.events;

import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.sofka.domain.generic.DomainEvent;

public class Rutinafinalizada extends DomainEvent {
    private final RutinaId rutinaId;

    public Rutinafinalizada(RutinaId rutinaId) {
        super("co.com.gym.entrenamiento.Rutinafinalizada");
        this.rutinaId = rutinaId;
    }

    public RutinaId getRutinaId() {
        return rutinaId;
    }
}
