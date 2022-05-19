package co.com.gym.entrenamiento.personalizado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Edad implements ValueObject<Integer> {
    private final Integer edad;

    public Edad(Integer edad) {
        this.edad = Objects.requireNonNull(edad);
        if(this.edad < 0){
            throw  new IllegalArgumentException("la edad debe ser mayor a cero");
        }
    }

    @Override
    public Integer value() {
        return edad;
    }
}
