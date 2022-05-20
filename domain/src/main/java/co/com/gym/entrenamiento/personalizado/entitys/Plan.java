package co.com.gym.entrenamiento.personalizado.entitys;

import co.com.gym.entrenamiento.personalizado.values.PlanId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.Entity;

public class Plan extends Entity<PlanId> {
    protected String nombrePlan;
    protected Descripcion descripcion;

    public Plan(PlanId entityId) {
        super(entityId);
    }

    public Plan(PlanId entityId, String nombrePlan, Descripcion descripcion) {
        super(entityId);
        this.nombrePlan = nombrePlan;
        this.descripcion = descripcion;
    }

    public void crearPlan(String nombrePlan, String descripcion){
        this.nombrePlan = nombrePlan;
        this.descripcion = new Descripcion(descripcion);
    }
}
