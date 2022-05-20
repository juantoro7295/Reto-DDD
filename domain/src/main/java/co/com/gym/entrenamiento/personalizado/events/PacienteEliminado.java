package co.com.gym.entrenamiento.personalizado.events;

import co.com.gym.entrenamiento.personalizado.values.PacienteId;
import co.com.sofka.domain.generic.DomainEvent;

public class PacienteEliminado extends DomainEvent {

    private PacienteId pacienteId;

    public PacienteEliminado(String type, PacienteId pacienteId) {
        super("co.com.gym.entrenamiento.PacienteEliminado");
        this.pacienteId = pacienteId;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }
}
