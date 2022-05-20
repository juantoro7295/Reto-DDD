package co.com.gym.entrenamiento.instructor.commands;


import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.Command;

public class AgregarEspecializacion extends Command {

    private final InstructorId instructorId;
    private final String especializacion;
    private final Descripcion descripcion;

    public AgregarEspecializacion(InstructorId instructorId, String especializacion, Descripcion descripcion) {
        this.instructorId = instructorId;
        this.especializacion = especializacion;
        this.descripcion = descripcion;
    }

    public InstructorId getInstructorId() {
        return instructorId;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
