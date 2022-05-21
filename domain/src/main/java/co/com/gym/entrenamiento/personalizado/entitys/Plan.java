package co.com.gym.entrenamiento.personalizado.entitys;

import co.com.gym.entrenamiento.personalizado.values.PlanId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.Entity;
/**
 * Entidad Plan
 *
 * @version 1.0.0
 * @Autor Juan Pablo Toro Hurtado
 * @Since 1.0.0
 */

public class Plan extends Entity<PlanId> {
    /**
     * caracteristicas
     */
    protected String nombrePlan;
    protected Descripcion descripcion;

    /**
     * Constructo Plan
     * @param entityId
     */

    public Plan(PlanId entityId) {
        super(entityId);
    }

    /**
     * constructor Plan
     * @param entityId
     * @param nombrePlan
     * @param descripcion
     */
    public Plan(PlanId entityId, String nombrePlan, Descripcion descripcion) {
        super(entityId);
        this.nombrePlan = nombrePlan;
        this.descripcion = descripcion;
    }

    /**
     * crear plan
     * @param nombrePlan
     * @param descripcion
     */

    public void crearPlan(String nombrePlan, String descripcion){
        this.nombrePlan = nombrePlan;
        this.descripcion = new Descripcion(descripcion);
    }
}
