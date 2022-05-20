package co.com.gym.entrenamiento.instructor.values;

import co.com.sofka.domain.generic.Identity;

public class EspecializacionId extends Identity {

    public EspecializacionId(String id) {
        super(id);
    }

    public static EspecializacionId of(String id){
        return new EspecializacionId(id);
    }
}
