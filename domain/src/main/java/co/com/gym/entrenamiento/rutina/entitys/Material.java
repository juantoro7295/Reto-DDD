package co.com.gym.entrenamiento.rutina.entitys;

import co.com.gym.entrenamiento.rutina.values.Detalle;
import co.com.gym.entrenamiento.rutina.values.MaterialId;
import co.com.sofka.domain.generic.Entity;

/**
 * Entidad Material
 *
 * @version 1.0.0
 * @Autor Juan Pablo Toro Hurtado
 * @Since 1.0.0
 */

public class Material extends Entity<MaterialId> {
    /**
     * Caracteristicas
     */

    protected String nombreMaterial;
    protected Detalle detalle;

    /**
     * Constructor Material
     *
     * @param entityId
     */

    public Material(MaterialId entityId) {
        super(entityId);
    }

    /**
     * Constructor Material
     *
     * @param entityId
     * @param nombreMaterial
     * @param detalle
     */

    public Material(MaterialId entityId, String nombreMaterial, Detalle detalle) {
        super(entityId);
        this.nombreMaterial = nombreMaterial;
        this.detalle = detalle;
    }

    /**
     * crear material
     *
     * @param nombreMaterial
     * @param detalle
     * @param peso
     */

    public void crearMaterial(String nombreMaterial, String detalle, Double peso) {
        this.nombreMaterial = nombreMaterial;
        this.detalle = new Detalle(detalle, peso);
    }
}
