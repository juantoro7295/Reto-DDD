package co.com.gym.entrenamiento.personalizado;

import co.com.gym.entrenamiento.instructor.entitys.Area;
import co.com.gym.entrenamiento.instructor.entitys.Contrato;
import co.com.gym.entrenamiento.instructor.entitys.Especializacion;
import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.gym.entrenamiento.personalizado.entitys.Paciente;
import co.com.gym.entrenamiento.personalizado.entitys.Plan;
import co.com.gym.entrenamiento.personalizado.entitys.TipoServicio;
import co.com.gym.entrenamiento.personalizado.events.*;
import co.com.gym.entrenamiento.personalizado.values.Edad;
import co.com.gym.entrenamiento.personalizado.values.Fecha;
import co.com.gym.entrenamiento.personalizado.values.Medida;
import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.gym.generic.values.Apellido;
import co.com.gym.generic.values.Descripcion;
import co.com.gym.generic.values.Nombre;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

/**
 * Agregado Personalizado
 *
 * @version 1.0.0
 * @Autor Juan Pablo Toro HUrtado
 * @Since 1.0.0
 */
public class Personalizado extends AggregateEvent<PersonalizadoId> {

    /**
     * caracteristicas
     */

    protected InstructorId instructorId;
    protected RutinaId rutinaId;

    protected Fecha fecha;

    protected Paciente paciente;
    protected Plan plan;
    protected TipoServicio tipoServicio;

    /**
     * Constructor Personalizado
     *
     * @param entityId
     * @param instructorId
     * @param rutinaId
     * @param fecha
     * @param paciente
     * @param plan
     * @param tipoServicio
     */
    public Personalizado(PersonalizadoId entityId, InstructorId instructorId,
                         RutinaId rutinaId, Fecha fecha, Paciente paciente, Plan plan,
                         TipoServicio tipoServicio) {

        super(entityId);
        appendChange(new PersonalizadoCreado(instructorId, rutinaId, fecha, paciente, plan, tipoServicio)).apply();
        subscribe(new PersonalizadoEventChange(this));
    }

    /**
     * personalizado
     *
     * @param entityId
     */

    public Personalizado(PersonalizadoId entityId) {
        super(entityId);
        subscribe(new PersonalizadoEventChange(this));
    }

    /**
     * from personalizado
     *
     * @param entityId
     * @param events
     * @return
     */

    public static Personalizado from(PersonalizadoId entityId, List<DomainEvent> events) {
        var personalizado = new Personalizado(entityId);
        events.forEach(personalizado::applyEvent);
        return personalizado;
    }

    /**
     * agregar instructor
     *
     * @param personalizadoId
     * @param nombre
     * @param apellido
     * @param contrato
     * @param area
     * @param especializacion
     */

    public void agregarInstructor(PersonalizadoId personalizadoId, Nombre nombre, Apellido apellido,
                                  Contrato contrato, Area area, Especializacion especializacion) {
        appendChange(new InstructorAgregado(personalizadoId, nombre, apellido, contrato, area, especializacion)).apply();

    }

    /**
     * agregar paciente
     *
     * @param personalizadoId
     * @param nombre
     * @param apellido
     * @param edad
     * @param medida
     */

    public void agregarPaciente(PersonalizadoId personalizadoId, Nombre nombre,
                                Apellido apellido, Edad edad, Medida medida) {
        appendChange(new PacienteAgregado(personalizadoId, nombre, apellido, edad, medida)).apply();

    }

    /**
     * agregar plan
     *
     * @param personalizadoId
     * @param nombrePlan
     * @param descripcion
     */
    public void agregarPlan(PersonalizadoId personalizadoId, String nombrePlan, Descripcion descripcion) {
        appendChange(new PlanAgregado(personalizadoId, nombrePlan, descripcion)).apply();
    }

    /**
     * actualizar personalizado
     *
     * @param personalizadoId
     */

    public void actualizarPersonalizado(PersonalizadoId personalizadoId) {
        appendChange(new PersonalizadoActualizado(personalizadoId)).apply();
    }


    public InstructorId instructorId() {
        return instructorId;
    }

    public RutinaId rutinaId() {
        return rutinaId;
    }

    public Fecha fecha() {
        return fecha;
    }

    public Paciente paciente() {
        return paciente;
    }

    public Plan plan() {
        return plan;
    }

    public TipoServicio tipoServicio() {
        return tipoServicio;
    }


}
