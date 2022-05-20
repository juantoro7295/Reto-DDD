package co.com.gym.entrenamiento.instructor.events;

import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.gym.entrenamiento.instructor.values.TipoDeContrato;
import co.com.sofka.domain.generic.DomainEvent;

public class ContratoAgregado extends DomainEvent {

    private final InstructorId instructorId;
    private final String nombreContrato;
    private final TipoDeContrato tipoDeContrato;

    public ContratoAgregado(InstructorId instructorId, String nombreContrato, TipoDeContrato tipoDeContrato) {
        super("co.com.gym.entrenamiento.ContratoAgregado");
        this.instructorId = instructorId;
        this.nombreContrato = nombreContrato;
        this.tipoDeContrato = tipoDeContrato;
    }

    public InstructorId getInstructorId() {
        return instructorId;
    }

    public String getNombreContrato() {
        return nombreContrato;
    }

    public TipoDeContrato getTipoDeContrato() {
        return tipoDeContrato;
    }
}
