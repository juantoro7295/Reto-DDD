package co.com.gym.entrenamiento.rutina.events;

import co.com.gym.entrenamiento.rutina.values.Detalle;
import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.sofka.domain.generic.DomainEvent;

public class MaterialAgregado extends DomainEvent {

    private final RutinaId rutinaId;
    private final String nombreMaterial;
    private final Detalle detalle;

    public MaterialAgregado(RutinaId rutinaId, String nombreMaterial, Detalle detalle) {
        super("co.com.gym.entrenamiento.MaterialAgregado");
        this.rutinaId = rutinaId;
        this.nombreMaterial = nombreMaterial;
        this.detalle = detalle;
    }

    public RutinaId getRutinaId() {
        return rutinaId;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public Detalle getDetalle() {
        return detalle;
    }
}
