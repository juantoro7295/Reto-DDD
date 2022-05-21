package co.com.gym.entrenamiento.instructor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeContrato implements ValueObject<String> {
    private final String tipoDeContrato;
    private final String detalles;

    public TipoDeContrato(String tipoDeContrato, String detalles) {
        this.tipoDeContrato = Objects.requireNonNull(tipoDeContrato);
        if (this.tipoDeContrato.isBlank()) {
            throw new IllegalArgumentException("el tipo de contrato no puede estar en blanco");
        }
        this.detalles = Objects.requireNonNull(detalles);
        if (this.detalles.isBlank()) {
            throw new IllegalArgumentException("Los detalles no pueden estar vacios");
        }
    }

    @Override
    public String value() {
        return tipoDeContrato;
    }
}
