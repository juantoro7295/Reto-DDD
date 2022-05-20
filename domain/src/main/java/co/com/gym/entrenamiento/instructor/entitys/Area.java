package co.com.gym.entrenamiento.instructor.entitys;

import co.com.gym.entrenamiento.instructor.values.AreaId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.Entity;

public class Area extends Entity<AreaId> {
    protected String nombreArea;
    protected Descripcion descripcion;

    public Area(AreaId entityId) {
        super(entityId);
    }

    public Area(AreaId entityId, String nombreArea, Descripcion descripcion) {
        super(entityId);
        this.nombreArea = nombreArea;
        this.descripcion = descripcion;
    }

    public void crearArea(String nombreArea, String descripcion){
        this.nombreArea = nombreArea;
        this.descripcion = new Descripcion(descripcion);
    }

}
