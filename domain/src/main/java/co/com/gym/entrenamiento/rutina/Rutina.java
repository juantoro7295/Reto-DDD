package co.com.gym.entrenamiento.rutina;

import co.com.gym.entrenamiento.rutina.entitys.Ejercicio;
import co.com.gym.entrenamiento.rutina.entitys.Material;
import co.com.gym.entrenamiento.rutina.entitys.ZonaDelCuerpo;
import co.com.gym.entrenamiento.rutina.events.RutinaCreada;
import co.com.gym.entrenamiento.rutina.values.RutinaId;
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
       appendChange(new RutinaCreada(nombreRutina,ejercicio,zonaDelCuerpo,material)).apply();
       subscribe(new RutinaEventChange(this));
    }

    public Rutina(RutinaId entityId) {
        super(entityId);
        subscribe(new RutinaEventChange(this));
    }

    public static Rutina from(RutinaId rutinaId, List<DomainEvent> events){
        var rutina = new Rutina(rutinaId);
        events.forEach(rutina::applyEvent);
        return rutina;
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
