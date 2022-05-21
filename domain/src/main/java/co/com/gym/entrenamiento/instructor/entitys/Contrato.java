package co.com.gym.entrenamiento.instructor.entitys;

import co.com.gym.entrenamiento.instructor.values.ContratoId;
import co.com.gym.entrenamiento.instructor.values.TipoDeContrato;
import co.com.sofka.domain.generic.Entity;
/**
 * Entidad Contrato
 *
 * @version 1.0.0
 * @Autor Juan Pablo Toro HUrtado
 * @Since 1.0.0
 */

public class Contrato extends Entity<ContratoId> {
    /**
     * caracteristicas
     */

    protected String nombreContrato;
    protected TipoDeContrato tipoDeContrato;

    /**
     * Construsctor Contrato
     * @param entityId
     */

    public Contrato(ContratoId entityId) {
        super(entityId);
    }

    /**
     * Constructor Contrato
     * @param entityId
     * @param nombreContrato
     * @param tipoDeContrato
     */

    public Contrato(ContratoId entityId, String nombreContrato, TipoDeContrato tipoDeContrato) {
        super(entityId);
        this.nombreContrato = nombreContrato;
        this.tipoDeContrato = tipoDeContrato;
    }

    /**
     * crear contrato
     * @param nombreContrato
     * @param tipoDeContrato
     */

    public void crearContrato(String nombreContrato, String tipoDeContrato) {
        this.tipoDeContrato = new TipoDeContrato(nombreContrato, tipoDeContrato);
    }


}
