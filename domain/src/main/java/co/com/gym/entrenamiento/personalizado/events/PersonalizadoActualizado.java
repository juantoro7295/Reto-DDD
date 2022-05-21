package co.com.gym.entrenamiento.personalizado.events;

import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
import co.com.sofka.domain.generic.DomainEvent;

public class PersonalizadoActualizado extends DomainEvent {
    private final PersonalizadoId personalizadoId;

    public PersonalizadoActualizado(PersonalizadoId personalizadoId) {
        super("co.com.gym.entrenamiento.PersonalizadoActualizado");
        this.personalizadoId = personalizadoId;
    }

    public PersonalizadoId getPersonalizadoId() {
        return personalizadoId;
    }
}
