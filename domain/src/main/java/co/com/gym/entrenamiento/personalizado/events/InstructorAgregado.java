package co.com.gym.entrenamiento.personalizado.events;


import co.com.gym.entrenamiento.instructor.entitys.Area;
import co.com.gym.entrenamiento.instructor.entitys.Contrato;
import co.com.gym.entrenamiento.instructor.entitys.Especializacion;
import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
import co.com.gym.generic.values.Apellido;
import co.com.gym.generic.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class InstructorAgregado extends DomainEvent {

    private final PersonalizadoId personalizadoId;
    private final Nombre nombre;
    private final Apellido apellido;
    private final Contrato contrato;
    private final Area area;
    private final Especializacion especializacion;


    public InstructorAgregado(PersonalizadoId personalizadoId, Nombre nombre, Apellido apellido,
                              Contrato contrato, Area area, Especializacion especializacion) {
        super("co.com.gym.entrenamiento.InstructorAgregado");
        this.personalizadoId = personalizadoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrato = contrato;
        this.area = area;
        this.especializacion = especializacion;
    }

    public PersonalizadoId getPersonalizadoId() {
        return personalizadoId;
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
