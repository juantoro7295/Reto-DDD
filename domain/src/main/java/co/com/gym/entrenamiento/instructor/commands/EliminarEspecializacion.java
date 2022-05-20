package co.com.gym.entrenamiento.instructor.commands;

import co.com.gym.entrenamiento.instructor.values.EspecializacionId;
import co.com.sofka.domain.generic.Command;

public class EliminarEspecializacion extends Command {
    private EspecializacionId especializacionId;

    public EliminarEspecializacion(EspecializacionId especializacionId) {
        this.especializacionId = especializacionId;
    }

    public EspecializacionId getEspecializacionId() {
        return especializacionId;
    }
}
