package co.com.gym.entrenamiento.instructor.usecase;

import co.com.gym.entrenamiento.instructor.Instructor;
import co.com.gym.entrenamiento.instructor.commands.AgregarArea;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarAreaUseCase extends UseCase<RequestCommand<AgregarArea>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarArea> agregarAreaRequestCommand) {
        var command = agregarAreaRequestCommand.getCommand();
        var instructor = Instructor.from(command.getInstructorId(),
                repository().getEventsBy(command.getInstructorId().value()));

        instructor.agregarArea(command.getNombreArea(), command.getDescripcion(), command.getInstructorId());

        emit().onResponse(new ResponseEvents(instructor.getUncommittedChanges()));

    }
}
