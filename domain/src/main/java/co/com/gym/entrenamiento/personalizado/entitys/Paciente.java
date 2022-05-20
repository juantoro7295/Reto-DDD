package co.com.gym.entrenamiento.personalizado.entitys;

import co.com.gym.entrenamiento.personalizado.values.Edad;
import co.com.gym.entrenamiento.personalizado.values.Medida;
import co.com.gym.entrenamiento.personalizado.values.PacienteId;
import co.com.gym.generic.values.Apellido;
import co.com.gym.generic.values.Nombre;
import co.com.sofka.domain.generic.Entity;

public class Paciente extends Entity<PacienteId> {

    protected Nombre nombre;
    protected Apellido apellido;
    protected Edad edad;
    protected Medida medida;


    public Paciente(PacienteId entityId) {
        super(entityId);
    }

    public Paciente(PacienteId entityId, Nombre nombre, Apellido apellido, Edad edad, Medida medida) {
        super(entityId);
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.medida = medida;
    }

    public void crearPaciente(String nombre, String apellido, Integer edad,String medida, Double altura, Double peso ){
        this.nombre = new Nombre(nombre);
        this.apellido = new Apellido(apellido);
        this.edad = new Edad(edad);
        this.medida = new Medida(medida,altura,peso);

    }
}
