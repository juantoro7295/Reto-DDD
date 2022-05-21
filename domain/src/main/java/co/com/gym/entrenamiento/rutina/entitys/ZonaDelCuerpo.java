package co.com.gym.entrenamiento.rutina.entitys;

import co.com.gym.entrenamiento.rutina.values.Calentamiento;
import co.com.gym.entrenamiento.rutina.values.ZonaCuerpo;
import co.com.gym.entrenamiento.rutina.values.ZonaDeLCuerpoId;
import co.com.sofka.domain.generic.Entity;

/**
 * Entidad ZonaDelCuerpo
 *
 * @version 1.0.0
 * @Autor Juan Pablo Toro Hurtado
 * @Since 1.0.0
 */

public class ZonaDelCuerpo extends Entity<ZonaDeLCuerpoId> {
    /**
     * caracteristicas
     */

    protected Calentamiento calentamiento;
    protected ZonaCuerpo zonaCuerpo;

    /**
     * Constructor ZonaDelCuerpo
     *
     * @param entityId
     */
    public ZonaDelCuerpo(ZonaDeLCuerpoId entityId) {
        super(entityId);
    }

    /**
     * Constructor ZonaDelCuerpo
     *
     * @param entityId
     * @param calentamiento
     * @param zonaCuerpo
     */
    public ZonaDelCuerpo(ZonaDeLCuerpoId entityId, Calentamiento calentamiento, ZonaCuerpo zonaCuerpo) {
        super(entityId);
        this.calentamiento = calentamiento;
        this.zonaCuerpo = zonaCuerpo;
    }

    /**
     * crear Zona del Cuerpo
     *
     * @param tipoDeCalentamiento
     * @param tiempo
     * @param zonaDelCuerpo
     * @param caracteritica
     */

    public void crearZonaDelCuerpo(String tipoDeCalentamiento, String tiempo, String zonaDelCuerpo, String caracteritica) {
        this.calentamiento = new Calentamiento(tipoDeCalentamiento, tiempo);
        this.zonaCuerpo = new ZonaCuerpo(zonaDelCuerpo, caracteritica);
    }
}
