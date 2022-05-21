package co.com.gym.entrenamiento.rutina.events;

import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.sofka.domain.generic.DomainEvent;

public class MaterialEliminado extends DomainEvent {


    private final RutinaId rutinaId;

    public MaterialEliminado(RutinaId rutinaId) {
        super("co.com.gym.entrenamiento.MaterialEliminado");
        this.rutinaId = rutinaId;
    }

    public RutinaId getRutinaId() {
        return rutinaId;
    }
}
