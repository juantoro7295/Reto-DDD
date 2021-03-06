package co.com.gym.entrenamiento.rutina;

import co.com.gym.entrenamiento.rutina.entitys.Ejercicio;
import co.com.gym.entrenamiento.rutina.entitys.Material;
import co.com.gym.entrenamiento.rutina.entitys.ZonaDelCuerpo;
import co.com.gym.entrenamiento.rutina.events.*;
import co.com.gym.entrenamiento.rutina.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

/**
 * Agregado Rutina
 *
 * @version 1.0.0
 * @Autor Juan Pablo Toro HUrtado
 * @Since 1.0.0
 */
public class Rutina extends AggregateEvent<RutinaId> {
    /**
     * caracteristicas
     */
    protected String nombreRutina;

    protected Ejercicio ejercicio;
    protected ZonaDelCuerpo zonaDelCuerpo;
    protected Material material;

    /**
     * Constructor Rutina
     *
     * @param entityId
     * @param nombreRutina
     * @param ejercicio
     * @param zonaDelCuerpo
     * @param material
     */
    public Rutina(RutinaId entityId, String nombreRutina, Ejercicio ejercicio, ZonaDelCuerpo zonaDelCuerpo, Material material) {
        super(entityId);
        appendChange(new RutinaCreada(nombreRutina, ejercicio, zonaDelCuerpo, material)).apply();
        subscribe(new RutinaEventChange(this));
    }

    /**
     * Rutina
     *
     * @param entityId
     */
    public Rutina(RutinaId entityId) {
        super(entityId);
        subscribe(new RutinaEventChange(this));
    }

    /**
     * from De Rutina
     *
     * @param rutinaId
     * @param events
     * @return Rutina
     */

    public static Rutina from(RutinaId rutinaId, List<DomainEvent> events) {
        var rutina = new Rutina(rutinaId);
        events.forEach(rutina::applyEvent);
        return rutina;
    }

    /**
     * agregar Ejercicio
     *
     * @param rutinaId
     * @param nombreEjercicio
     * @param detalleEjercicio
     * @param intensidad
     */

    public void agregarEjericio(RutinaId rutinaId, String nombreEjercicio, DetalleEjercicio detalleEjercicio,
                                Intensidad intensidad) {
        appendChange(new EjercicioAgregado(rutinaId, nombreEjercicio, detalleEjercicio, intensidad)).apply();
    }

    /**
     * agregar material
     *
     * @param rutinaId
     * @param nombreMaterial
     * @param detalle
     */

    public void agregarMaterial(RutinaId rutinaId, String nombreMaterial, Detalle detalle) {
        appendChange(new MaterialAgregado(rutinaId, nombreMaterial, detalle)).apply();
    }

    /**
     * agregar zona del cuerpo
     *
     * @param rutinaId
     * @param calentamiento
     * @param zonaCuerpo
     */

    public void agregarZonaDelCuerpo(RutinaId rutinaId, Calentamiento calentamiento,
                                     ZonaCuerpo zonaCuerpo) {
        appendChange(new ZonaDelCuerpoAgregada(rutinaId, calentamiento, zonaCuerpo)).apply();

    }

    /**
     * eliminar ejercicio
     *
     * @param rutinaId
     */

    public void eliminarEjericio(RutinaId rutinaId) {
        appendChange(new EjercicioEliminado(rutinaId)).apply();

    }

    /**
     * actualizar rutina
     *
     * @param rutinaId
     */

    public void actualizarRutina(RutinaId rutinaId) {
        appendChange(new RutinaActualizada(rutinaId)).apply();

    }


}
