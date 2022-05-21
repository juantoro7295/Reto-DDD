package co.com.gym.entrenamiento.instructor.usecase;

import co.com.gym.entrenamiento.instructor.Instructor;
import co.com.gym.entrenamiento.instructor.commands.EliminarArea;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class EliminarAreaUseCase extends UseCase<RequestCommand<EliminarArea>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<EliminarArea> eliminarAreaRequestCommand) {
        var command = eliminarAreaRequestCommand.getCommand();
        var instructor = Instructor.from(command.getInstructorId(),
                repository().getEventsBy(command.getInstructorId().value()));
        instructor.eliminarArea(command.getInstructorId());
        emit().onResponse(new ResponseEvents(instructor.getUncommittedChanges()));


    }
}
