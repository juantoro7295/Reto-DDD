package co.com.gym.entrenamiento.rutina.commands;

import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.sofka.domain.generic.Command;

public class EliminarEjercicio extends Command {

    private final RutinaId rutinaId;

    public EliminarEjercicio(RutinaId rutinaId) {
        this.rutinaId = rutinaId;
    }

    public RutinaId getRutinaId() {
        return rutinaId;
    }
}
