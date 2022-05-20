package co.com.gym.entrenamiento.instructor.events;

import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class EspecializacionAgregada extends DomainEvent {

    private InstructorId instructorId;
    private final String especializacion;
    private final Descripcion descripcion;

    public EspecializacionAgregada(InstructorId instructorId, String especializacion, Descripcion descripcion) {
        super("co.com.gym.entrenamiento.EspecializacionAgregada");
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
