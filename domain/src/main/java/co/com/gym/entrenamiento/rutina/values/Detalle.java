package co.com.gym.entrenamiento.rutina.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Detalle implements ValueObject<String> {
    private final String detalle;
    private final Double peso;

    public Detalle(String detalle, Double peso) {
        this.detalle = Objects.requireNonNull(detalle);
        if(this.detalle.isBlank()){
            throw new IllegalArgumentException("El detalle no puede estar vacio");
        }
        this.peso = Objects.requireNonNull(peso);
    }

    @Override
    public String value() {
        return detalle;
    }
}
