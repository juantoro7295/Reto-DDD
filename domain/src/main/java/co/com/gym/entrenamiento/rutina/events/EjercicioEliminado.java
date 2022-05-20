package co.com.gym.entrenamiento.rutina.events;

import co.com.gym.entrenamiento.rutina.values.EjercicioId;
import co.com.sofka.domain.generic.DomainEvent;

public class EjercicioEliminado extends DomainEvent {

    private final EjercicioId ejercicioId;

    public EjercicioEliminado(String type, EjercicioId ejercicioId) {
        super("co.com.gym.entrenamiento.EjercicioEliminado");
        this.ejercicioId = ejercicioId;
    }

    public EjercicioId getEjercicioId() {
        return ejercicioId;
    }
}
