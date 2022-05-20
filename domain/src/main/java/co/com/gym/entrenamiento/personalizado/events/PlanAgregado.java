package co.com.gym.entrenamiento.personalizado.events;

import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class PlanAgregado extends DomainEvent {

    private final PersonalizadoId personalizadoId;
    private final String nombrePlan;
    private final Descripcion descripcion;

    public PlanAgregado(PersonalizadoId personalizadoId, String nombrePlan, Descripcion descripcion) {
        super("co.com.gym.entrenamiento.PlanAgregado");
        this.personalizadoId = personalizadoId;
        this.nombrePlan = nombrePlan;
        this.descripcion = descripcion;
    }

    public PersonalizadoId getPersonalizadoId() {
        return personalizadoId;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
