package co.com.gym.entrenamiento.personalizado.events;


import co.com.gym.entrenamiento.instructor.entitys.Area;
import co.com.gym.entrenamiento.instructor.entitys.Contrato;
import co.com.gym.entrenamiento.instructor.entitys.Especializacion;
import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.gym.generic.values.Apellido;
import co.com.gym.generic.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class InstructorAgregado extends DomainEvent {

    private final InstructorId instructorId;
    private final Nombre nombre;
    private final Apellido apellido;
    private final Contrato contrato;
    private final Area area;
    private final Especializacion especializacion;


    public InstructorAgregado(InstructorId instructorId, Nombre nombre, Apellido apellido,
                              Contrato contrato, Area area, Especializacion especializacion) {
        super("co.com.gym.entrenamiento.InstructorAgregado");
        this.instructorId = instructorId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrato = contrato;
        this.area = area;
        this.especializacion = especializacion;
    }

    public InstructorId getInstructorId() {
        return instructorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Apellido getApellido() {
        return apellido;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public Area getArea() {
        return area;
    }

    public Especializacion getEspecializacion() {
        return especializacion;
    }
}
