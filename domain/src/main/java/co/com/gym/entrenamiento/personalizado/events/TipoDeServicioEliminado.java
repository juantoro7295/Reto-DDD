package co.com.gym.entrenamiento.personalizado.events;

import co.com.gym.entrenamiento.personalizado.values.TipoServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoDeServicioEliminado extends DomainEvent {

    private final TipoServicioId tipoServicioId;

    public TipoDeServicioEliminado(String type, TipoServicioId tipoServicioId) {
        super("co.com.gym.entrenamiento.TipoDeServicioEliminado");
        this.tipoServicioId = tipoServicioId;
    }

    public TipoServicioId getTipoServicioId() {
        return tipoServicioId;
    }
}
