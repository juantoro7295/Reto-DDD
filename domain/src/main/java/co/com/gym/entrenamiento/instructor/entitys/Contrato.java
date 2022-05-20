package co.com.gym.entrenamiento.instructor.entitys;

import co.com.gym.entrenamiento.instructor.values.ContratoId;
import co.com.gym.entrenamiento.instructor.values.TipoDeContrato;
import co.com.sofka.domain.generic.Entity;

public class Contrato extends Entity<ContratoId> {

    protected String nombreContrato;
    protected TipoDeContrato tipoDeContrato;

    public Contrato(ContratoId entityId) {
        super(entityId);
    }

    public Contrato(ContratoId entityId, String nombreContrato, TipoDeContrato tipoDeContrato) {
        super(entityId);
        this.nombreContrato = nombreContrato;
        this.tipoDeContrato = tipoDeContrato;
    }

    public void crearContrato(String nombreContrato, String tipoDeContrato) {
        this.tipoDeContrato = new TipoDeContrato(nombreContrato, tipoDeContrato);
    }


}
