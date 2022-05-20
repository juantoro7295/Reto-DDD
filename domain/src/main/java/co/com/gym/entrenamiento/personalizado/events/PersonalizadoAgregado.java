package co.com.gym.entrenamiento.personalizado.events;

import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.gym.entrenamiento.personalizado.entitys.Paciente;
import co.com.gym.entrenamiento.personalizado.entitys.Plan;
import co.com.gym.entrenamiento.personalizado.entitys.TipoServicio;
import co.com.gym.entrenamiento.personalizado.values.Fecha;
import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.sofka.domain.generic.DomainEvent;

public class PersonalizadoAgregado extends DomainEvent {

    private final PersonalizadoId personalizadoId;
    private final InstructorId instructorId;
    private final RutinaId rutinaId;
    private final Fecha fecha;
    private final Paciente paciente;
    private final Plan plan;
    private final TipoServicio tipoServicio;

    public PersonalizadoAgregado(String type, PersonalizadoId personalizadoId, InstructorId instructorId, RutinaId rutinaId,
                                 Fecha fecha, Paciente paciente, Plan plan, TipoServicio tipoServicio) {
        super("co.com.gym.entrenamiento.PersonalizadoAgregado");
        this.personalizadoId = personalizadoId;
        this.instructorId = instructorId;
        this.rutinaId = rutinaId;
        this.fecha = fecha;
        this.paciente = paciente;
        this.plan = plan;
        this.tipoServicio = tipoServicio;
    }

    public PersonalizadoId getPersonalizadoId() {
        return personalizadoId;
    }

    public InstructorId getInstructorId() {
        return instructorId;
    }

    public RutinaId getRutinaId() {
        return rutinaId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Plan getPlan() {
        return plan;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }
}
