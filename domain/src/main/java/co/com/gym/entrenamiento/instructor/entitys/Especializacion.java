package co.com.gym.entrenamiento.instructor.entitys;

import co.com.gym.entrenamiento.instructor.values.EspecializacionId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.Entity;

/**
 *  Entidad Especializacion
 * @version 1.0.0
 * @Autor Juan Pablo Toro Hurtado
 * @Since 1.0.0
 */
public class Especializacion extends Entity<EspecializacionId> {
    /**
     * caracteriticas
     */
    protected String especializacion;
    protected Descripcion descripcion;

    /**
     * Constructor Especializacion
     * @param entityId
     */

    public Especializacion(EspecializacionId entityId) {
        super(entityId);
    }

    /**
     * Constructor Especializacion
     * @param entityId
     * @param especializacion
     * @param descripcion
     */

    public Especializacion(EspecializacionId entityId, String especializacion, Descripcion descripcion) {
        super(entityId);
        this.especializacion = especializacion;
        this.descripcion = descripcion;
    }

    /**
     * crear especialiacion
     * @param especializacion
     * @param descripcion
     */

    public void crearEspecializacion(String especializacion,String descripcion){
        this.especializacion = especializacion;
        this.descripcion = new Descripcion(descripcion);
    }
}
