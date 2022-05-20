package co.com.gym.entrenamiento.personalizado.commands;

import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.sofka.domain.generic.Command;

public class EliminarInstructor extends Command {

    private final InstructorId instructorId;

    public EliminarInstructor(InstructorId instructorId) {
        this.instructorId = instructorId;
    }

    public InstructorId getInstructorId() {
        return instructorId;
    }


}
