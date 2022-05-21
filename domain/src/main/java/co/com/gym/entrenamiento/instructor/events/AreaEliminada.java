package co.com.gym.entrenamiento.instructor.events;

import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.sofka.domain.generic.DomainEvent;

public class AreaEliminada extends DomainEvent {

    private final InstructorId intructorId;

    public AreaEliminada( InstructorId intructorId) {
        super("co.com.gym.entrenamiento.AreaEliminada");
        this.intructorId = intructorId;
    }

    public InstructorId instructorId() {
        return intructorId;
    }

}
