package co.com.gym.entrenamiento.instructor.events;

import co.com.gym.entrenamiento.instructor.entitys.Area;
import co.com.gym.entrenamiento.instructor.entitys.Contrato;
import co.com.gym.entrenamiento.instructor.entitys.Especializacion;
import co.com.gym.generic.values.Apellido;
import co.com.gym.generic.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class InstructorCreado extends DomainEvent {
    private final Nombre nombre;
    private final Apellido apellido;

    private final Contrato contrato;
    private final Area area;
    private final Especializacion especializacion;


    public InstructorCreado(Nombre nombre, Apellido apellido, Contrato contrato, Area area, Especializacion especializacion) {
        super("co.com.gym.entrenamiento.InstructorCreado");
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrato = contrato;
        this.area = area;
        this.especializacion = especializacion;
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
