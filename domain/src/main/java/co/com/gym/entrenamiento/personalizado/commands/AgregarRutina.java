package co.com.gym.entrenamiento.personalizado.commands;

import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
import co.com.gym.entrenamiento.rutina.entitys.Ejercicio;
import co.com.gym.entrenamiento.rutina.entitys.Material;
import co.com.gym.entrenamiento.rutina.entitys.ZonaDelCuerpo;
import co.com.sofka.domain.generic.Command;

public class AgregarRutina extends Command {

    private final PersonalizadoId personalizadoId;
    private final String nombreRutina;
    private final Ejercicio ejercicio;
    private final ZonaDelCuerpo zonaDelCuerpo;
    private final Material material;

    public AgregarRutina(PersonalizadoId personalizadoId, String nombreRutina, Ejercicio ejercicio,
                         ZonaDelCuerpo zonaDelCuerpo, Material material) {
        this.personalizadoId = personalizadoId;
        this.nombreRutina = nombreRutina;
        this.ejercicio = ejercicio;
        this.zonaDelCuerpo = zonaDelCuerpo;
        this.material = material;
    }

    public PersonalizadoId getPersonalizadoId() {
        return personalizadoId;
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
