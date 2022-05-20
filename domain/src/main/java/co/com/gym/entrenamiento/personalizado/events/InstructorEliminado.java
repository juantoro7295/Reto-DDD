package co.com.gym.entrenamiento.personalizado.events;

import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.sofka.domain.generic.DomainEvent;

public class InstructorEliminado extends DomainEvent {

    private final InstructorId instructorId;

    public InstructorEliminado(String type, InstructorId instructorId) {
        super("co.com.gym.entrenamiento.InstructorEliminado");
        this.instructorId = instructorId;
    }

    public InstructorId getInstructorId() {
        return instructorId;
    }
}
