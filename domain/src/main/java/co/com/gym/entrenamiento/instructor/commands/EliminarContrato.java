package co.com.gym.entrenamiento.instructor.commands;

import co.com.gym.entrenamiento.instructor.values.ContratoId;
import co.com.sofka.domain.generic.Command;

public class EliminarContrato extends Command {

    private ContratoId contratoId;

    public EliminarContrato(ContratoId contratoId) {
        this.contratoId = contratoId;
    }

    public ContratoId getContratoId() {
        return contratoId;
    }
}
