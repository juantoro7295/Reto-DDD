package co.com.gym.entrenamiento.personalizado;

import co.com.sofka.domain.generic.Identity;

public class PersonalizadoId extends Identity {

    public PersonalizadoId(String id) {
        super(id);
    }

    public static PersonalizadoId of(String id){
        return new PersonalizadoId(id);
    }

}
