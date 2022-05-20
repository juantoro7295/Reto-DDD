package co.com.gym.entrenamiento.rutina.entitys;

import co.com.gym.entrenamiento.rutina.values.Calentamiento;
import co.com.gym.entrenamiento.rutina.values.ZonaCuerpo;
import co.com.gym.entrenamiento.rutina.values.ZonaDeLCuerpoId;
import co.com.sofka.domain.generic.Entity;

public class ZonaDelCuerpo extends Entity<ZonaDeLCuerpoId> {

    protected Calentamiento calentamiento;
    protected ZonaCuerpo zonaCuerpo;


    public ZonaDelCuerpo(ZonaDeLCuerpoId entityId) {
        super(entityId);
    }

    public ZonaDelCuerpo(ZonaDeLCuerpoId entityId, Calentamiento calentamiento, ZonaCuerpo zonaCuerpo) {
        super(entityId);
        this.calentamiento = calentamiento;
        this.zonaCuerpo = zonaCuerpo;
    }

    public void crearZonaDelCuerpo(String tipoDeCalentamiento, String tiempo, String zonaDelCuerpo, String caracteritica) {
        this.calentamiento = new Calentamiento(tipoDeCalentamiento, tiempo);
        this.zonaCuerpo = new ZonaCuerpo(zonaDelCuerpo, caracteritica);
    }
}
