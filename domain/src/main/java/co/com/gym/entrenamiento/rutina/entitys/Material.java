package co.com.gym.entrenamiento.rutina.entitys;

import co.com.gym.entrenamiento.rutina.values.Detalle;
import co.com.gym.entrenamiento.rutina.values.MaterialId;
import co.com.sofka.domain.generic.Entity;

public class Material extends Entity<MaterialId> {

    protected String nombreMaterial;
    protected Detalle detalle;

    public Material(MaterialId entityId) {
        super(entityId);
    }

    public Material(MaterialId entityId, String nombreMaterial, Detalle detalle) {
        super(entityId);
        this.nombreMaterial = nombreMaterial;
        this.detalle = detalle;
    }

    public void crearMaterial(String nombreMaterial, String detalle, Double peso){
        this.nombreMaterial = nombreMaterial;
        this.detalle = new Detalle(detalle,peso);
    }
}
