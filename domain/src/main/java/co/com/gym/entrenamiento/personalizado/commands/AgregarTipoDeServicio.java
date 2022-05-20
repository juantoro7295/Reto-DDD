package co.com.gym.entrenamiento.personalizado.commands;

import co.com.gym.entrenamiento.personalizado.values.TipoServicioId;
import co.com.gym.generic.values.Descripcion;
import co.com.sofka.domain.generic.Command;

public class AgregarTipoDeServicio extends Command {

    private final TipoServicioId tipoServicioId;
    private final String tipoDeServicio;
    private final Descripcion descripcion;

    public AgregarTipoDeServicio(TipoServicioId tipoServicioId, String tipoDeServicio, Descripcion descripcion) {
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
