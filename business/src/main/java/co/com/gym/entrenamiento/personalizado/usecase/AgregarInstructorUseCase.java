package co.com.gym.entrenamiento.personalizado.usecase;

import co.com.gym.entrenamiento.personalizado.Personalizado;
import co.com.gym.entrenamiento.personalizado.commands.AgregarInstructor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarInstructorUseCase extends UseCase<RequestCommand<AgregarInstructor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarInstructor> agregarInstructorRequestCommand) {
        var command = agregarInstructorRequestCommand.getCommand();
        var personalizado = Personalizado.from(
                command.getPersonalizadoId(), repository().getEventsBy(command.getPersonalizadoId().value())
        );
        personalizado.agregarInstructor(command.getPersonalizadoId(), command.getNombre(), command.getApellido(),
                command.getContrato(), command.getArea(), command.getEspecializacion());
        emit().onResponse(new ResponseEvents(personalizado.getUncommittedChanges()));

    }
}
