package co.com.gym.entrenamiento.instructor.commands;

import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.sofka.domain.generic.Command;

public class EliminarArea extends Command {

    private InstructorId instructorId;

    public EliminarArea(InstructorId instructorId) {
        this.instructorId = instructorId;
    }

    public InstructorId getInstructorId() {
        return instructorId;
    }
}
