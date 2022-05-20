package co.com.gym.entrenamiento.rutina.events;

import co.com.gym.entrenamiento.rutina.entitys.Ejercicio;
import co.com.gym.entrenamiento.rutina.entitys.Material;
import co.com.gym.entrenamiento.rutina.entitys.ZonaDelCuerpo;
import co.com.sofka.domain.generic.DomainEvent;

public class RutinaCreada extends DomainEvent {
    private final String nombreRutina;
    private final Ejercicio ejercicio;
    private final ZonaDelCuerpo zonaDelCuerpo;
    private final Material material;
    public RutinaCreada(String nombreRutina, Ejercicio ejercicio, ZonaDelCuerpo zonaDelCuerpo, Material material) {
        super("co.com.gym.entrenamieto.RutinaCreada");
        this.nombreRutina = nombreRutina;
        this.ejercicio = ejercicio;
        this.zonaDelCuerpo = zonaDelCuerpo;
        this.material = material;

    }

    public String getNombreRutina() {
        return nombreRutina;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public ZonaDelCuerpo getZonaDelCuerpo() {
        return zonaDelCuerpo;
    }

    public Material getMaterial() {
        return material;
    }
}
