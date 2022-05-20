package co.com.gym.entrenamiento.rutina.events;

import co.com.gym.entrenamiento.rutina.values.MaterialId;
import co.com.sofka.domain.generic.DomainEvent;

public class MaterialEliminado extends DomainEvent {

    private final MaterialId materialId;

    public MaterialEliminado(String type, MaterialId materialId) {
        super("co.com.gym.entrenamiento.MaterialEliminado");
        this.materialId = materialId;
    }

    public MaterialId getMaterialId() {
        return materialId;
    }
}
