package co.com.gym.entrenamiento.personalizado.commands;

import co.com.gym.entrenamiento.personalizado.values.TipoServicioId;
import co.com.sofka.domain.generic.Command;

public class EliminarTipoDeServicio extends Command {
    private final TipoServicioId tipoServicioId;

    public EliminarTipoDeServicio(TipoServicioId tipoServicioId) {
        this.tipoServicioId = tipoServicioId;
    }

    public TipoServicioId getTipoServicioId() {
        return tipoServicioId;
    }

}
