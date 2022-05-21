package co.com.gym.entrenamiento.personalizado.events;

import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
import co.com.sofka.domain.generic.DomainEvent;

public class PersonalizadoFinalizado extends DomainEvent {

    private final PersonalizadoId personalizadoId;

    public PersonalizadoFinalizado(PersonalizadoId personalizadoId) {
        super("co.com.gym.entrenamiento.PersonalizadoFinalizado");
        this.personalizadoId = personalizadoId;
    }

    public PersonalizadoId getPersonalizadoId() {
        return personalizadoId;
    }
}
