package co.com.gym.entrenamiento.rutina.commands;

import co.com.gym.entrenamiento.rutina.values.EjercicioId;
import co.com.sofka.domain.generic.Command;

public class EliminarEjercicio extends Command {

    private final EjercicioId ejercicioId;

    public EliminarEjercicio(EjercicioId ejercicioId) {
        this.ejercicioId = ejercicioId;
    }

    public EjercicioId getEjercicioId() {
        return ejercicioId;
    }
}
