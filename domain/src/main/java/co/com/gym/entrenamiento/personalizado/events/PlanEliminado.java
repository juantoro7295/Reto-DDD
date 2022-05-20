package co.com.gym.entrenamiento.personalizado.events;

import co.com.gym.entrenamiento.personalizado.values.PlanId;
import co.com.sofka.domain.generic.DomainEvent;

public class PlanEliminado extends DomainEvent {

    private final PlanId planId;

    public PlanEliminado(String type, PlanId planId) {
        super("co.com.gym.entrenamiento.PlanEliminado");
        this.planId = planId;
    }

    public PlanId getPlanId() {
        return planId;
    }
}
