package co.com.gym.entrenamiento.personalizado.commands;

import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.sofka.domain.generic.Command;

public class EliminarRutina extends Command {
    private final RutinaId rutinaId;

    public EliminarRutina(RutinaId rutinaId) {
        this.rutinaId = rutinaId;
    }

    public RutinaId getRutinaId() {
        return rutinaId;
    }
}
