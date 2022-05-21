package co.com.gym.entrenamiento.rutina.events;

import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.sofka.domain.generic.DomainEvent;

public class EjercicioEliminado extends DomainEvent {

    private final RutinaId rutinaId;

    public EjercicioEliminado(RutinaId rutinaId) {
        super("co.com.gym.entrenamiento.EjercicioEliminado");
        this.rutinaId = rutinaId;
    }

    public RutinaId getRutinaId() {
        return rutinaId;
    }
}
