package co.com.gym.entrenamiento.rutina.values;

import co.com.sofka.domain.generic.Identity;

public class ZonaDeLCuerpoId extends Identity {

    public ZonaDeLCuerpoId(String id) {
        super(id);
    }

    public static ZonaDeLCuerpoId of(String id){
        return new ZonaDeLCuerpoId(id);
    }
}
