package co.com.gym.entrenamiento.rutina.events;

import co.com.gym.entrenamiento.rutina.values.ZonaDeLCuerpoId;
import co.com.sofka.domain.generic.DomainEvent;

public class ZonaDelCuerpoEliminada extends DomainEvent {

    private final ZonaDeLCuerpoId zonaDeLCuerpoId;

    public ZonaDelCuerpoEliminada(String type, ZonaDeLCuerpoId zonaDeLCuerpoId) {
        super("co.com.gym.entrenamiento.ZonaDelCuerpoEliminada");
        this.zonaDeLCuerpoId = zonaDeLCuerpoId;
    }

    public ZonaDeLCuerpoId getZonaDeLCuerpoId() {
        return zonaDeLCuerpoId;
    }

}
