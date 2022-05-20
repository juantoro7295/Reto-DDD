package co.com.gym.entrenamiento.personalizado.commands;

import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
import co.com.sofka.domain.generic.Command;

public class EliminarPersonalizado extends Command {

    private final PersonalizadoId personalizadoId;

    public EliminarPersonalizado(PersonalizadoId personalizadoId) {
        this.personalizadoId = personalizadoId;
    }

    public PersonalizadoId getPersonalizadoId() {
        return personalizadoId;
    }
}
