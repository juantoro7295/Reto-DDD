package co.com.gym.entrenamiento.personalizado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Medida implements ValueObject<String> {
    private final String medida;
    private final Double altura;
    private final Double peso;

    public Medida(String medida, Double altura, Double peso) {
        this.medida = Objects.requireNonNull(medida);
        if (this.medida.isBlank()) {
            throw new IllegalArgumentException("la medida no puede estar vacia");
        }
        this.altura = Objects.requireNonNull(altura);
        if (this.altura.isNaN()) {
            throw new IllegalArgumentException("la altura no puede estar vacia");
        }
        this.peso = Objects.requireNonNull(peso);
        if (this.peso.isNaN()) {
            throw new IllegalArgumentException("el peso no puede estar vacio");
        }
    }

    @Override
    public String value() {
        return medida;
    }
}
