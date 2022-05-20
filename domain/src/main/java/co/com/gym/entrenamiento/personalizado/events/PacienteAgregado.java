package co.com.gym.entrenamiento.personalizado.events;

import co.com.gym.entrenamiento.personalizado.values.Edad;
import co.com.gym.entrenamiento.personalizado.values.Medida;
import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
import co.com.gym.generic.values.Apellido;
import co.com.gym.generic.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class PacienteAgregado extends DomainEvent {

    private final PersonalizadoId personalizadoId;
    private final Nombre nombre;
    private final Apellido apellido;
    private final Edad edad;
    private final Medida medida;


    public PacienteAgregado(PersonalizadoId personalizadoId, Nombre nombre, Apellido apellido, Edad edad, Medida medida) {
        super("co.com.gym.entrenamiento.PacienteAgregado");
        this.personalizadoId = personalizadoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.medida = medida;
    }

    public PersonalizadoId getPersonalizadoId() {
        return personalizadoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Apellido getApellido() {
        return apellido;
    }

    public Edad getEdad() {
        return edad;
    }

    public Medida getMedida() {
        return medida;
    }


}
