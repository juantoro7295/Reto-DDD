package co.com.gym.entrenamiento.rutina.commands;

import co.com.gym.entrenamiento.rutina.values.Calentamiento;
import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.gym.entrenamiento.rutina.values.ZonaCuerpo;
import co.com.sofka.domain.generic.Command;

public class AgregarZonaDelCuerpo extends Command {

    private final RutinaId rutinaId;
    private final Calentamiento calentamiento;
    private final ZonaCuerpo zonaCuerpo;

    public AgregarZonaDelCuerpo(RutinaId rutinaId, Calentamiento calentamiento, ZonaCuerpo zonaCuerpo) {
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
