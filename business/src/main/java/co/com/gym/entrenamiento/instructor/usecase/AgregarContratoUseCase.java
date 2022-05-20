package co.com.gym.entrenamiento.instructor.usecase;

import co.com.gym.entrenamiento.instructor.Instructor;
import co.com.gym.entrenamiento.instructor.commands.AgregarContrato;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarContratoUseCase extends UseCase<RequestCommand<AgregarContrato>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarContrato> agregarContratoRequestCommand) {
        var command = agregarContratoRequestCommand.getCommand();
        var instructor = Instructor.from(command.getInstructorId(),
                repository().getEventsBy(command.getInstructorId().value()));

        instructor.agregarContrato(command.getInstructorId(), command.getNombreContrato(), command.getTipoDeContrato());

        emit().onResponse(new ResponseEvents(instructor.getUncommittedChanges()));

    }
}
