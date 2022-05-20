package co.com.gym.entrenamiento.personalizado.entitys;

import co.com.gym.entrenamiento.personalizado.values.TipoServicioId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.Entity;

public class TipoServicio extends Entity<TipoServicioId> {

    protected  String nombreTipoServicio;
    protected Descripcion descripcion;


    public TipoServicio(TipoServicioId entityId) {
        super(entityId);
    }

    public TipoServicio(TipoServicioId entityId, String nombreTipoServicio, Descripcion descripcion) {
        super(entityId);
        this.nombreTipoServicio = nombreTipoServicio;
        this.descripcion = descripcion;
    }

    public void crearTipoServicio(String nombreTipoServicio, String descripcion){
        this.nombreTipoServicio = nombreTipoServicio;
        this.descripcion = new Descripcion(descripcion);
    }
}
