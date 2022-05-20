package co.com.gym.entrenamiento.instructor.events;


import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class AreaAgregada extends DomainEvent {

    private final InstructorId instructorId;
    private final String nombreArea;
    private final Descripcion descripcion;

    public AreaAgregada(String nombreArea, Descripcion descripcion, InstructorId instructorId) {
        super("co.com.gym.entrenamiento.AreaAgregada");
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
