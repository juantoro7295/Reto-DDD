package co.com.gym.entrenamiento.instructor.commands;

import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.Command;


public class AgregarArea extends Command {

    private InstructorId instructorId;
    private final String nombreArea;
    private final Descripcion descripcion;

    public AgregarArea(InstructorId instructorId, String nombreArea, Descripcion descripcion) {
        this.instructorId = instructorId;
        this.nombreArea = nombreArea;
        this.descripcion = descripcion;
    }

    public InstructorId getInstructorId() {
        return instructorId;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
