package co.com.gym.entrenamiento.instructor.values;

import co.com.sofka.domain.generic.Identity;

public class AreaId extends Identity {
    public AreaId(String id) {
        super(id);
    }
    public static AreaId of(String id){
        return new AreaId(id);
    }
}
