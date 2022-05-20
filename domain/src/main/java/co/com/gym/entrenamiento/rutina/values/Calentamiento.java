package co.com.gym.entrenamiento.rutina.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Calentamiento implements ValueObject<String> {
    private final String tipoCalentamiento;
    private final String tiempo;

    public Calentamiento(String tipoCalentamiento, String tiempo) {
        this.tipoCalentamiento = Objects.requireNonNull(tipoCalentamiento);
        if(this.tipoCalentamiento.isBlank()){
            throw new IllegalArgumentException("El tipoCalentamiento no puede estar  vacia");
        }
        this.tiempo = Objects.requireNonNull(tiempo);
        if(this.tiempo.isBlank()){
            throw new IllegalArgumentException("El tiempo no puede estar vacio");
        }
    }

    @Override
    public String value() {
        return tipoCalentamiento;
    }
}
