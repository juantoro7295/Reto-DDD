package co.com.gym.entrenamiento.rutina;

import co.com.gym.entrenamiento.rutina.entitys.Ejercicio;
import co.com.gym.entrenamiento.rutina.entitys.Material;
import co.com.gym.entrenamiento.rutina.entitys.ZonaDelCuerpo;
import co.com.gym.entrenamiento.rutina.events.EjercicioAgregado;
import co.com.gym.entrenamiento.rutina.events.MaterialAgregado;
import co.com.gym.entrenamiento.rutina.events.RutinaCreada;
import co.com.gym.entrenamiento.rutina.events.ZonaDelCuerpoAgregada;
import co.com.gym.entrenamiento.rutina.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Rutina extends AggregateEvent<RutinaId> {
    protected String nombreRutina;

    protected Ejercicio ejercicio;
    protected ZonaDelCuerpo zonaDelCuerpo;
    protected Material material;

    public Rutina(RutinaId entityId, String nombreRutina, Ejercicio ejercicio, ZonaDelCuerpo zonaDelCuerpo, Material material) {
        super(entityId);
        appendChange(new RutinaCreada(nombreRutina, ejercicio, zonaDelCuerpo, material)).apply();
        subscribe(new RutinaEventChange(this));
    }

    public Rutina(RutinaId entityId) {
        super(entityId);
        subscribe(new RutinaEventChange(this));
    }

    public static Rutina from(RutinaId rutinaId, List<DomainEvent> events) {
        var rutina = new Rutina(rutinaId);
        events.forEach(rutina::applyEvent);
        return rutina;
    }

    public void agregarEjericio(RutinaId rutinaId, String nombreEjercicio, DetalleEjercicio detalleEjercicio,
                                Intensidad intensidad) {
        appendChange(new EjercicioAgregado(rutinaId, nombreEjercicio, detalleEjercicio, intensidad)).apply();
    }

    public void agregarMaterial(RutinaId rutinaId, String nombreMaterial, Detalle detalle) {
        appendChange(new MaterialAgregado(rutinaId, nombreMaterial, detalle)).apply();
    }

    public void agregarZonaDelCuerpo(RutinaId rutinaId, Calentamiento calentamiento,
                                     ZonaCuerpo zonaCuerpo) {
        appendChange(new ZonaDelCuerpoAgregada(rutinaId, calentamiento, zonaCuerpo)).apply();

    }

    public String nombreRutina() {
        return nombreRutina;
    }

    public Ejercicio ejercicio() {
        return ejercicio;
    }

    public ZonaDelCuerpo zonaDelCuerpo() {
        return zonaDelCuerpo;
    }

    public Material material() {
        return material;
    }
}
