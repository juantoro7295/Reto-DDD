package co.com.gym.entrenamiento.rutina.events;

import co.com.gym.entrenamiento.rutina.values.Calentamiento;
import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.gym.entrenamiento.rutina.values.ZonaCuerpo;
import co.com.gym.entrenamiento.rutina.values.ZonaDeLCuerpoId;
import co.com.sofka.domain.generic.DomainEvent;

public class ZonaDelCuerpoAgregada extends DomainEvent {

    private final RutinaId rutinaId;
    private final Calentamiento calentamiento;
    private final ZonaCuerpo zonaCuerpo;

    public ZonaDelCuerpoAgregada( RutinaId rutinaId, Calentamiento calentamiento,
                                 ZonaCuerpo zonaCuerpo) {
        super("co.com.gym.entrenamiento.ZonaDelCuerpoAgregada");
        this.rutinaId = rutinaId;
        this.calentamiento = calentamiento;
        this.zonaCuerpo = zonaCuerpo;
    }

    public RutinaId getRutinaId() {
        return rutinaId;
    }

    public Calentamiento getCalentamiento() {
        return calentamiento;
    }

    public ZonaCuerpo getZonaCuerpo() {
        return zonaCuerpo;
    }
}
