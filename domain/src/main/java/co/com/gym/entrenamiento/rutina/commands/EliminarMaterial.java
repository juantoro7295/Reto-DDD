package co.com.gym.entrenamiento.rutina.commands;

import co.com.gym.entrenamiento.rutina.values.MaterialId;
import co.com.sofka.domain.generic.Command;

public class EliminarMaterial extends Command {
    private MaterialId materialId;

    public EliminarMaterial(MaterialId materialId) {
        this.materialId = materialId;
    }

    public MaterialId getMaterialId() {
        return materialId;
    }
}
