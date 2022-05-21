package co.com.gym.entrenamiento.instructor.entitys;

import co.com.gym.entrenamiento.instructor.values.AreaId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.Entity;
/**
 * Entidad Area
 *
 * @version 1.0.0
 * @Autor Juan Pablo Toro HUrtado
 * @Since 1.0.0
 */

public class Area extends Entity<AreaId> {
    /**
     * caracteristicas
     */
    protected String nombreArea;
    protected Descripcion descripcion;

    /**
     * Constructor Area
     * @param entityId
     */

    public Area(AreaId entityId) {
        super(entityId);
    }

    /**
     * Constructor Area
     * @param entityId
     * @param nombreArea
     * @param descripcion
     */
    public Area(AreaId entityId, String nombreArea, Descripcion descripcion) {
        super(entityId);
        this.nombreArea = nombreArea;
        this.descripcion = descripcion;
    }

    /**
     * crear Area
     * @param nombreArea
     * @param descripcion
     */
    public void crearArea(String nombreArea, String descripcion){
        this.nombreArea = nombreArea;
        this.descripcion = new Descripcion(descripcion);
    }

}
