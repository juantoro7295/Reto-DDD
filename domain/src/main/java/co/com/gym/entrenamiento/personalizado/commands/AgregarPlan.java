package co.com.gym.entrenamiento.personalizado.commands;

import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.Command;

public class AgregarPlan extends Command {

    private final PersonalizadoId personalizadoId;
    private final String nombrePlan;
    private final Descripcion descripcion;

    public AgregarPlan(PersonalizadoId personalizadoId, String nombrePlan, Descripcion descripcion) {
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
