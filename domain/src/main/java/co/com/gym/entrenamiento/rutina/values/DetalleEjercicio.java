package co.com.gym.entrenamiento.rutina.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DetalleEjercicio implements ValueObject<String> {
    private final String repeticiones;
    private final String series;
    private final String descanso;

    public DetalleEjercicio(String repeticiones, String series, String descanso) {
        this.repeticiones = Objects.requireNonNull(repeticiones);
        if(this.repeticiones.isBlank()){
            throw  new IllegalArgumentException("Las repeticiones no pueden estar vacias");
        }
        this.series = Objects.requireNonNull(series);
        if(this.series.isBlank()){
            throw  new IllegalArgumentException("Las series no pueden estar vacias");
        }

        this.descanso = Objects.requireNonNull(descanso);
        if(this.descanso.isBlank()){
            throw  new IllegalArgumentException("El descanso no puede estar vacio");
        }
    }

    @Override
    public String value() {
        return repeticiones;
    }
}
