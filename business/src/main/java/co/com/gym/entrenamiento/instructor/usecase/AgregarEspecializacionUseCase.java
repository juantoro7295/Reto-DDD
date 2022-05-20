package co.com.gym.entrenamiento.instructor.usecase;


import co.com.gym.entrenamiento.instructor.Instructor;
import co.com.gym.entrenamiento.instructor.commands.AgregarEspecializacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarEspecializacionUseCase extends UseCase<RequestCommand<AgregarEspecializacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEspecializacion> agregarEspecializacionRequestCommand) {
        var command = agregarEspecializacionRequestCommand.getCommand();
        var instructor = Instructor.from(command.getInstructorId(),
                repository().getEventsBy(command.getInstructorId().value()));
        instructor.agregarEspecializacion(command.getInstructorId(), command.getEspecializacion(), command.getDescripcion());

        emit().onResponse(new ResponseEvents(instructor.getUncommittedChanges()));

    }
}
