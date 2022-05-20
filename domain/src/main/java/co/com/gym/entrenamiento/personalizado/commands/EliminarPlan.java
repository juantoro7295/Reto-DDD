package co.com.gym.entrenamiento.personalizado.commands;

import co.com.gym.entrenamiento.personalizado.values.PlanId;
import co.com.sofka.domain.generic.Command;

public class EliminarPlan extends Command {

    private final PlanId planId;


    public EliminarPlan(PlanId planId) {
        this.planId = planId;
    }

    public PlanId getPlanId() {
        return planId;
    }

}
