package co.com.gym.entrenamiento.rutina.commands;

import co.com.gym.entrenamiento.rutina.values.ZonaDeLCuerpoId;
import co.com.sofka.domain.generic.Command;

public class EliminarZonaDelCuerpo extends Command {

    private final ZonaDeLCuerpoId zonaDeLCuerpoId;

    public EliminarZonaDelCuerpo(ZonaDeLCuerpoId zonaDeLCuerpoId) {
        this.zonaDeLCuerpoId = zonaDeLCuerpoId;
    }

    public ZonaDeLCuerpoId getZonaDeLCuerpoId() {
        return zonaDeLCuerpoId;
    }


}
