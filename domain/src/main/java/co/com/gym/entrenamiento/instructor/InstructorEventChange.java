package co.com.gym.entrenamiento.instructor;

import co.com.gym.entrenamiento.instructor.events.InstructorCreado;
import co.com.sofka.domain.generic.EventChange;

public class InstructorEventChange extends EventChange {
    public InstructorEventChange(Instructor instructor) {
        apply((InstructorCreado event) -> {
            instructor.nombre = event.getNombre();
            instructor.apellido = event.getApellido();
            instructor.contrato = event.getContrato();
            instructor.area = event.getArea();
            instructor.especializacion = event.getEspecializacion();
        });
    }
}
