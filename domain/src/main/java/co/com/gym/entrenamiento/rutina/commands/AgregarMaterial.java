package co.com.gym.entrenamiento.rutina.commands;

import co.com.gym.entrenamiento.rutina.values.Detalle;
import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.sofka.domain.generic.Command;

public class AgregarMaterial extends Command {

    private final RutinaId rutinaId;
    private final String nombreMaterial;
    private final Detalle detalle;

    public AgregarMaterial(RutinaId rutinaId, String nombreMaterial, Detalle detalle) {
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
