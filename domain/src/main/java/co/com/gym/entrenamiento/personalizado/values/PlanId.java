package co.com.gym.entrenamiento.personalizado.values;

import co.com.sofka.domain.generic.Identity;

public class PlanId extends Identity {

    public PlanId(String id) {
        super(id);
    }

    public static PlanId of(String id) {
        return new PlanId(id);
    }
}
