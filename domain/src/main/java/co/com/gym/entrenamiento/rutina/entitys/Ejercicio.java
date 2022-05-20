package co.com.gym.entrenamiento.rutina.entitys;

import co.com.gym.entrenamiento.rutina.values.DetalleEjercicio;
import co.com.gym.entrenamiento.rutina.values.EjercicioId;
import co.com.gym.entrenamiento.rutina.values.Intensidad;
import co.com.sofka.domain.generic.Entity;

public class Ejercicio extends Entity<EjercicioId> {
    protected String nombreEjercicio;
    protected DetalleEjercicio detalleEjercicio;
    protected Intensidad intensidad;


    public Ejercicio(EjercicioId entityId) {
        super(entityId);
    }

    public Ejercicio(EjercicioId entityId, String nombreEjercicio, DetalleEjercicio detalleEjercicio, Intensidad intensidad) {
        super(entityId);
        this.nombreEjercicio = nombreEjercicio;
        this.detalleEjercicio = detalleEjercicio;
        this.intensidad = intensidad;
    }

    public void crearEjercicio(String nombreEjercicio, String repeticiones,
                               String series, String descanso, String progresion, String frecuencia) {

        this.nombreEjercicio = nombreEjercicio;
        this.detalleEjercicio = new DetalleEjercicio(repeticiones, series, descanso);
        this.intensidad = new Intensidad(progresion, frecuencia);

    }
}
