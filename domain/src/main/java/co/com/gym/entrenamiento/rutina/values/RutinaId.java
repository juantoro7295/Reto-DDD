package co.com.gym.entrenamiento.rutina.values;

import co.com.sofka.domain.generic.Identity;

public class RutinaId extends Identity {
    public RutinaId(String id) {
        super(id);
    }

    public static RutinaId of(String id){
        return new RutinaId(id);
    }
}
