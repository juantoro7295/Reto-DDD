package co.com.gym.entrenamiento.rutina.values;

import co.com.sofka.domain.generic.Identity;

public class MaterialId extends Identity {

    public MaterialId(String id) {
        super(id);
    }

    public static  MaterialId of(String id){
        return new MaterialId(id);
    }
}
