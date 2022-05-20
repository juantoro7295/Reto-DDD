package co.com.gym.entrenamiento.rutina.events;

import co.com.gym.entrenamiento.rutina.values.Detalle;
import co.com.gym.entrenamiento.rutina.values.MaterialId;
import co.com.sofka.domain.generic.DomainEvent;

public class MaterialAgregado extends DomainEvent {

    private final MaterialId materialId;
    private final String nombreMaterial;
    private final Detalle detalle;

    public MaterialAgregado(String type, MaterialId materialId, String nombreMaterial, Detalle detalle) {
        super("co.com.gym.entrenamiento.MaterialAgregado");
        this.materialId = materialId;
        this.nombreMaterial = nombreMaterial;
        this.detalle = detalle;
    }

    public MaterialId getMaterialId() {
        return materialId;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public Detalle getDetalle() {
        return detalle;
    }
}
