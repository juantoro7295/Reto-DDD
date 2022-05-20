package co.com.gym.entrenamiento.rutina.events;

import co.com.gym.entrenamiento.rutina.values.Calentamiento;
import co.com.gym.entrenamiento.rutina.values.ZonaCuerpo;
import co.com.gym.entrenamiento.rutina.values.ZonaDeLCuerpoId;
import co.com.sofka.domain.generic.DomainEvent;

public class ZonaDelCuerpoAgregada extends DomainEvent {

    private final ZonaDeLCuerpoId zonaDeLCuerpoId;
    private final Calentamiento calentamiento;
    private final ZonaCuerpo zonaCuerpo;

    public ZonaDelCuerpoAgregada(String type, ZonaDeLCuerpoId zonaDeLCuerpoId, Calentamiento calentamiento,
                                 ZonaCuerpo zonaCuerpo) {
        super("co.com.gym.entrenamiento.ZonaDelCuerpoAgregada");
        this.zonaDeLCuerpoId = zonaDeLCuerpoId;
        this.calentamiento = calentamiento;
        this.zonaCuerpo = zonaCuerpo;
    }

    public ZonaDeLCuerpoId getZonaDeLCuerpoId() {
        return zonaDeLCuerpoId;
    }

    public Calentamiento getCalentamiento() {
        return calentamiento;
    }

    public ZonaCuerpo getZonaCuerpo() {
        return zonaCuerpo;
    }
}
