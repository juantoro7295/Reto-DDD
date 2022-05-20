package co.com.gym.entrenamiento.personalizado.events;

import co.com.gym.entrenamiento.personalizado.values.TipoServicioId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoDeServicioAgregado extends DomainEvent {

    private final TipoServicioId tipoServicioId;
    private final String tipoDeServicio;
    private final Descripcion descripcion;


    public TipoDeServicioAgregado(String type, TipoServicioId tipoServicioId, String tipoDeServicio, Descripcion descripcion) {
        super("co.com.gym.entrenamiento.TipoDeServicioAgregado");
        this.tipoServicioId = tipoServicioId;
        this.tipoDeServicio = tipoDeServicio;
        this.descripcion = descripcion;
    }

    public TipoServicioId getTipoServicioId() {
        return tipoServicioId;
    }

    public String getTipoDeServicio() {
        return tipoDeServicio;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
