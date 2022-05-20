package co.com.gym.entrenamiento.instructor.events;

import co.com.gym.entrenamiento.instructor.values.EspecializacionId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class EspecializacionAgregada extends DomainEvent {

    private EspecializacionId especializacionId;
    private final String especializacion;
    private final Descripcion descripcion;

    public EspecializacionAgregada(String type, EspecializacionId especializacionId, String especializacion, Descripcion descripcion) {
        super("co.com.gym.entrenamiento.EspecializacionAgregada");
        this.especializacionId = especializacionId;
        this.especializacion = especializacion;
        this.descripcion = descripcion;
    }

    public EspecializacionId getEspecializacionId() {
        return especializacionId;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
