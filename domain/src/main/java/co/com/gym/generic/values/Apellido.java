package co.com.gym.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Apellido implements ValueObject<String> {
    private final String apellido;

    public Apellido(String apellido) {
        this.apellido = Objects.requireNonNull(apellido);
        if(this.apellido.isBlank()){
            throw new IllegalArgumentException("El apellido no puede estar vacio");
        }
    }

    @Override
    public String value() {
        return apellido;
    }
}
