package co.com.gym.entrenamiento.rutina.values;

import co.com.sofka.domain.generic.Identity;

public class EjercicioId extends Identity {
    public EjercicioId(String id) {
        super(id);
    }

    public static EjercicioId of(String id){
        return new EjercicioId(id);
    }
}
