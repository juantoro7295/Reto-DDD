package co.com.gym.entrenamiento.instructor.entitys;

import co.com.gym.entrenamiento.instructor.values.EspecializacionId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.Entity;

public class Especializacion extends Entity<EspecializacionId> {
    protected String especializacion;
    protected Descripcion descripcion;

    public Especializacion(EspecializacionId entityId) {
        super(entityId);
    }

    public Especializacion(EspecializacionId entityId, String especializacion, Descripcion descripcion) {
        super(entityId);
        this.especializacion = especializacion;
        this.descripcion = descripcion;
    }

    public void crearEspecializacion(String especializacion,String descripcion){
        this.especializacion = especializacion;
        this.descripcion = new Descripcion(descripcion);
    }
}
