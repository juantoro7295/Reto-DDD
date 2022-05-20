package co.com.gym.entrenamiento.personalizado.events;

import co.com.gym.entrenamiento.rutina.entitys.Ejercicio;
import co.com.gym.entrenamiento.rutina.entitys.Material;
import co.com.gym.entrenamiento.rutina.entitys.ZonaDelCuerpo;
import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.sofka.domain.generic.DomainEvent;

public class RutinaAgregada extends DomainEvent {

    private final RutinaId rutinaId;
    private final String nombreRutina;
    private final Ejercicio ejercicio;
    private final ZonaDelCuerpo zonaDelCuerpo;
    private final Material material;

    public RutinaAgregada(String type, RutinaId rutinaId, String nombreRutina, Ejercicio ejercicio,
                          ZonaDelCuerpo zonaDelCuerpo, Material material) {
        super("co.com.gym.entrenamiento.RutinaAgregada");
        this.rutinaId = rutinaId;
        this.nombreRutina = nombreRutina;
        this.ejercicio = ejercicio;
        this.zonaDelCuerpo = zonaDelCuerpo;
        this.material = material;
    }

    public RutinaId getRutinaId() {
        return rutinaId;
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
