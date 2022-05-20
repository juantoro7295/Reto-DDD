package co.com.gym.entrenamiento.personalizado;

import co.com.gym.entrenamiento.personalizado.events.PersonalizadoCreado;
import co.com.sofka.domain.generic.EventChange;

public class PersonalizadoEventChange extends EventChange {
    public PersonalizadoEventChange(Personalizado personalizado) {
        apply((PersonalizadoCreado event) -> {
            personalizado.instructorId = event.getInstructorId();
            personalizado.rutinaId = event.getRutinaId();
            personalizado.fecha = event.getFecha();
            personalizado.paciente = event.getPaciente();
            personalizado.plan = event.getPlan();
            personalizado.tipoServicio = event.getTipoServicio();
        });
    }
}
