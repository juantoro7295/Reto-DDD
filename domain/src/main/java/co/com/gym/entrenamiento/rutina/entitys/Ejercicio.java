package co.com.gym.entrenamiento.rutina.entitys;

import co.com.gym.entrenamiento.rutina.values.DetalleEjercicio;
import co.com.gym.entrenamiento.rutina.values.EjercicioId;
import co.com.gym.entrenamiento.rutina.values.Intensidad;
import co.com.sofka.domain.generic.Entity;
/**
 * Entidad Ejercicio
 *
 * @version 1.0.0
 * @Autor Juan Pablo Toro Hurtado
 * @Since 1.0.0
 */
public class Ejercicio extends Entity<EjercicioId> {
    /**
     * caracteristicas
     */
    protected String nombreEjercicio;
    protected DetalleEjercicio detalleEjercicio;
    protected Intensidad intensidad;

    /**
     * Constructor Ejericicio
     * @param entityId
     */

    public Ejercicio(EjercicioId entityId) {
        super(entityId);
    }

    /**
     * Constructor Ejercicio
     * @param entityId
     * @param nombreEjercicio
     * @param detalleEjercicio
     * @param intensidad
     */

    public Ejercicio(EjercicioId entityId, String nombreEjercicio, DetalleEjercicio detalleEjercicio, Intensidad intensidad) {
        super(entityId);
        this.nombreEjercicio = nombreEjercicio;
        this.detalleEjercicio = detalleEjercicio;
        this.intensidad = intensidad;
    }

    /**
     * crear ejercicio
     * @param nombreEjercicio
     * @param repeticiones
     * @param series
     * @param descanso
     * @param progresion
     * @param frecuencia
     */

    public void crearEjercicio(String nombreEjercicio, String repeticiones,
                               String series, String descanso, String progresion, String frecuencia) {

        this.nombreEjercicio = nombreEjercicio;
        this.detalleEjercicio = new DetalleEjercicio(repeticiones, series, descanso);
        this.intensidad = new Intensidad(progresion, frecuencia);

    }
}
