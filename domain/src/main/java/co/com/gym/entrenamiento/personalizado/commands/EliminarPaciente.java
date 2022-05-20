package co.com.gym.entrenamiento.personalizado.commands;

import co.com.gym.entrenamiento.personalizado.values.PacienteId;
import co.com.sofka.domain.generic.Command;

public class EliminarPaciente extends Command {

    private final PacienteId pacienteId;

    public EliminarPaciente(PacienteId pacienteId) {
        this.pacienteId = pacienteId;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }
}
