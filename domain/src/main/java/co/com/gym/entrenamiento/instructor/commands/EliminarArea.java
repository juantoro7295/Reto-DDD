package co.com.gym.entrenamiento.instructor.commands;

import co.com.gym.entrenamiento.instructor.values.AreaId;
import co.com.sofka.domain.generic.Command;

public class EliminarArea extends Command {

    private AreaId areaId;

    public EliminarArea(AreaId areaId) {
        this.areaId = areaId;
    }

    public AreaId getAreaId() {
        return areaId;
    }
}
