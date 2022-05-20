package co.com.gym.entrenamiento.instructor;

import co.com.gym.entrenamiento.instructor.entitys.Area;
import co.com.gym.entrenamiento.instructor.entitys.Contrato;
import co.com.gym.entrenamiento.instructor.entitys.Especializacion;
import co.com.gym.entrenamiento.instructor.events.InstructorCreado;
import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.gym.generic.values.Apellido;
import co.com.gym.generic.values.Nombre;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Instructor extends AggregateEvent<InstructorId> {

    protected Nombre nombre;
    protected Apellido apellido;
    protected Contrato contrato;
    protected Area area;
    protected Especializacion especializacion;


    public Instructor(InstructorId entityId, Nombre nombre, Apellido apellido, Contrato contrato,
                      Area area, Especializacion especializacion) {
        super(entityId);
        appendChange(new InstructorCreado(nombre, apellido,contrato,area,especializacion)).apply();
        subscribe(new InstructorEventChange(this));
    }

    public Instructor(InstructorId entityId) {
        super(entityId);
        subscribe(new InstructorEventChange(this));
    }

    public static Instructor from(InstructorId instructorId, List<DomainEvent> events){
        var instructor = new Instructor(instructorId);
        events.forEach(instructor::applyEvent);
        return instructor;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Apellido apellido() {
        return apellido;
    }

    public Contrato contrato() {
        return contrato;
    }

    public Area area() {
        return area;
    }

    public Especializacion especializacion() {
        return especializacion;
    }
}
