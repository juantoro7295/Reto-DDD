package co.com.gym.entrenamiento.instructor.events;

import co.com.gym.entrenamiento.instructor.values.ContratoId;
import co.com.sofka.domain.generic.DomainEvent;

public class ContratoEliminado extends DomainEvent {

    private ContratoId contratoId;

    public ContratoEliminado(String type, ContratoId contratoId) {
        super("co.com.gym.entrenamiento.ContratoEliminado");
        this.contratoId = contratoId;
    }

    public ContratoId getContratoId() {
        return contratoId;
    }
}
