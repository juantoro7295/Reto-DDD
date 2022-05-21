package co.com.gym.entrenamiento.rutina.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Intensidad implements ValueObject<String> {
    private final String progresion;
    private final String frecuencia;

    public Intensidad(String progresion, String frecuencia) {
        this.progresion = Objects.requireNonNull(progresion);
        if (this.progresion.isBlank()) {
            throw new IllegalArgumentException("la progresion no puede estar vacia");
        }
        this.frecuencia = Objects.requireNonNull(frecuencia);
        if (this.frecuencia.isBlank()) {
            throw new IllegalArgumentException("la frecuencia no puede estar vacia");
        }
    }

    @Override
    public String value() {
        return progresion;
    }
}
