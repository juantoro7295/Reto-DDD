package co.com.gym.entrenamiento.rutina.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ZonaDelCuerpo implements ValueObject<String> {
    private final String zonaDelCuerpo;
    private final String caracteritica;

    public ZonaDelCuerpo(String zonaDelCuerpo, String caracteritica) {
        this.zonaDelCuerpo = Objects.requireNonNull(zonaDelCuerpo);
        if(this.zonaDelCuerpo.isBlank()){
            throw new IllegalArgumentException("la ZonaDelCuerpo no puede estar vacia");
        }
        this.caracteritica = Objects.requireNonNull(caracteritica);
        if(this.caracteritica.isBlank()){
            throw new IllegalArgumentException("la caracteristica no puede estar vacia");
        }
    }

    @Override
    public String value() {
        return zonaDelCuerpo;
    }
}
