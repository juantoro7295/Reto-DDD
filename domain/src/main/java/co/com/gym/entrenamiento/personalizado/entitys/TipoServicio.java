package co.com.gym.entrenamiento.personalizado.entitys;

import co.com.gym.entrenamiento.personalizado.values.TipoServicioId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.Entity;

/**
 * Entidad TipoServicio
 *
 * @version 1.0.0
 * @Autor Juan Pablo Toro HUrtado
 * @Since 1.0.0
 */

public class TipoServicio extends Entity<TipoServicioId> {
    /**
     * caracteristicas
     */

    protected String nombreTipoServicio;
    protected Descripcion descripcion;

    /**
     * Constructor TipoServicio
     *
     * @param entityId
     */

    public TipoServicio(TipoServicioId entityId) {
        super(entityId);
    }

    /**
     * Constructor TipoServicio
     *
     * @param entityId
     * @param nombreTipoServicio
     * @param descripcion
     */

    public TipoServicio(TipoServicioId entityId, String nombreTipoServicio, Descripcion descripcion) {
        super(entityId);
        this.nombreTipoServicio = nombreTipoServicio;
        this.descripcion = descripcion;
    }

    /**
     * crear tipo de servicio
     *
     * @param nombreTipoServicio
     * @param descripcion
     */

    public void crearTipoServicio(String nombreTipoServicio, String descripcion) {
        this.nombreTipoServicio = nombreTipoServicio;
        this.descripcion = new Descripcion(descripcion);
    }
}
