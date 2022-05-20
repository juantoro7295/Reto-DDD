package co.com.gym.entrenamiento.instructor.values;

import co.com.sofka.domain.generic.Identity;

public class ContratoId extends Identity {
    public ContratoId(String value) {
        super(value);
    }

    public ContratoId(){

    }

    public static ContratoId of(String value){
        return new ContratoId(value);
    }

}
