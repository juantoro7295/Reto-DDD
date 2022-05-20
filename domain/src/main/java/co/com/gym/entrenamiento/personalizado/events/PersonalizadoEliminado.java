package co.com.gym.entrenamiento.personalizado.events;

import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
import co.com.sofka.domain.generic.DomainEvent;

public class PersonalizadoEliminado extends DomainEvent {

    private final PersonalizadoId personalizadoId;

    public PersonalizadoEliminado(String type, PersonalizadoId personalizadoId) {
        super("co.com.gym.entrenamiento.PersonalizadoEliminado");
        this.personalizadoId = personalizadoId;
    }
}
