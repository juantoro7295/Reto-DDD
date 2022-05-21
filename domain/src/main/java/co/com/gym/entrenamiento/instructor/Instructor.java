package co.com.gym.entrenamiento.instructor;

import co.com.gym.entrenamiento.instructor.entitys.Area;
import co.com.gym.entrenamiento.instructor.entitys.Contrato;
import co.com.gym.entrenamiento.instructor.entitys.Especializacion;
import co.com.gym.entrenamiento.instructor.events.*;
import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.gym.entrenamiento.instructor.values.TipoDeContrato;
import co.com.gym.generic.values.Apellido;
import co.com.gym.generic.values.Descripcion;
import co.com.gym.generic.values.Nombre;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

/**
 * Agregado Instructor
 *
 * @version 1.0.0
 * @Autor Juan Pablo Toro HUrtado
 * @Since 1.0.0
 */

public class Instructor extends AggregateEvent<InstructorId> {
    /**
     * caracteriticas
     */

    protected Nombre nombre;
    protected Apellido apellido;
    protected Contrato contrato;
    protected Area area;
    protected Especializacion especializacion;


    /**
     * constructor Instructor
     *
     * @param entityId
     * @param nombre
     * @param apellido
     * @param contrato
     * @param area
     * @param especializacion
     */
    public Instructor(InstructorId entityId, Nombre nombre, Apellido apellido, Contrato contrato,
                      Area area, Especializacion especializacion) {
        super(entityId);
        appendChange(new InstructorCreado(nombre, apellido, contrato, area, especializacion)).apply();
        subscribe(new InstructorEventChange(this));
    }

    /**
     * constructor
     *
     * @param entityId
     */

    public Instructor(InstructorId entityId) {
        super(entityId);
        subscribe(new InstructorEventChange(this));
    }

    /**
     * from de Instructor
     *
     * @param instructorId
     * @param events
     * @return
     */

    public static Instructor from(InstructorId instructorId, List<DomainEvent> events) {
        var instructor = new Instructor(instructorId);
        events.forEach(instructor::applyEvent);
        return instructor;
    }

    /**
     * agregar area
     *
     * @param nombreArea
     * @param descripcion
     * @param instructorId
     */

    public void agregarArea(String nombreArea, Descripcion descripcion, InstructorId instructorId) {
        appendChange(new AreaAgregada(nombreArea, descripcion, instructorId)).apply();
    }

    /**
     * agregar contrato
     *
     * @param instructorId
     * @param nombreContrato
     * @param tipoDeContrato
     */

    public void agregarContrato(InstructorId instructorId, String nombreContrato, TipoDeContrato tipoDeContrato) {
        appendChange(new ContratoAgregado(instructorId, nombreContrato, tipoDeContrato)).apply();
    }

    /**
     * agregar especializacion
     *
     * @param instructorId
     * @param especializacion
     * @param descripcion
     */

    public void agregarEspecializacion(InstructorId instructorId, String especializacion, Descripcion descripcion) {
        appendChange(new EspecializacionAgregada(instructorId, especializacion, descripcion)).apply();
    }

    /**
     * eliminar area
     *
     * @param instructorId
     */
    public void eliminarArea(InstructorId instructorId) {
        appendChange(new AreaEliminada(instructorId)).apply();

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
