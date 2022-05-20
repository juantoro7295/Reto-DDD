package co.com.gym.entrenamiento.instructor.commands;


import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.gym.entrenamiento.instructor.values.TipoDeContrato;
import co.com.sofka.domain.generic.Command;

public class AgregarContrato extends Command {

    private final InstructorId instructorId;
    private final String NombreContrato;
    private final TipoDeContrato tipoDeContrato;

    public AgregarContrato(InstructorId instructorId, String nombreContrato, TipoDeContrato tipoDeContrato) {
        this.instructorId = instructorId;
        NombreContrato = nombreContrato;
        this.tipoDeContrato = tipoDeContrato;
    }

    public InstructorId getInstructorId() {
        return instructorId;
    }

    public String getNombreContrato() {
        return NombreContrato;
    }

    public TipoDeContrato getTipoDeContrato() {
        return tipoDeContrato;
    }
}
