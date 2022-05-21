package co.com.gym.entrenamiento.rutina;

import co.com.gym.entrenamiento.rutina.events.RutinaCreada;
import co.com.sofka.domain.generic.EventChange;

public class RutinaEventChange extends EventChange {
    public RutinaEventChange(Rutina rutina) {
        apply((RutinaCreada event) -> {
            rutina.nombreRutina = event.getNombreRutina();
            rutina.ejercicio = event.getEjercicio();
            rutina.zonaDelCuerpo = event.getZonaDelCuerpo();
            rutina.material = event.getMaterial();
        });
    }
}
