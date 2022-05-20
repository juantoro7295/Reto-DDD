package co.com.gym.entrenamiento.instructor.events;

import co.com.gym.entrenamiento.instructor.values.ContratoId;
import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.gym.entrenamiento.instructor.values.TipoDeContrato;
import co.com.sofka.domain.generic.DomainEvent;

public class ContratoAgregado extends DomainEvent {

    private final ContratoId contratoId;
    private final String nombreContrato;
    private final TipoDeContrato tipoDeContrato;

    public ContratoAgregado(String type, ContratoId contratoId, String nombreContrato, TipoDeContrato tipoDeContrato) {
        super("co.com.gym.entrenamiento.ContratoAgregado");
        this.contratoId = contratoId;
        this.nombreContrato = nombreContrato;
        this.tipoDeContrato = tipoDeContrato;
    }

    public ContratoId getContratoId() {
        return contratoId;
    }

    public String getNombreContrato() {
        return nombreContrato;
    }

    public TipoDeContrato getTipoDeContrato() {
        return tipoDeContrato;
    }
}
