package co.com.gym.entrenamiento.personalizado.values;

import co.com.sofka.domain.generic.Identity;

public class TipoServicioId extends Identity {

    public TipoServicioId(String id) {
        super(id);
    }

    public static TipoServicioId of(String id){
        return new TipoServicioId(id);
    }
}
