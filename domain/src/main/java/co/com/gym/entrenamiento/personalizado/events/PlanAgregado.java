package co.com.gym.entrenamiento.personalizado.events;

import co.com.gym.entrenamiento.personalizado.values.PlanId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class PlanAgregado extends DomainEvent {

    private final PlanId planId;
    private final String nombrePlan;
    private final Descripcion descripcion;

    public PlanAgregado(String type, PlanId planId, String nombrePlan, Descripcion descripcion) {
        super("co.com.gym.entrenamiento.PlanAgregado");
        this.planId = planId;
        this.nombrePlan = nombrePlan;
        this.descripcion = descripcion;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
