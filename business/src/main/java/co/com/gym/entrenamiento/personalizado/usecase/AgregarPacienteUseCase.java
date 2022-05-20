package co.com.gym.entrenamiento.personalizado.usecase;

import co.com.gym.entrenamiento.personalizado.Personalizado;
import co.com.gym.entrenamiento.personalizado.commands.AgregarPaciente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarPacienteUseCase extends UseCase<RequestCommand<AgregarPaciente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPaciente> agregarPacienteRequestCommand) {
        var command = agregarPacienteRequestCommand.getCommand();
        var personalizado = Personalizado.from(command.getPersonalizadoId(),
                repository().getEventsBy(command.getPersonalizadoId().value()));
        personalizado.agregarPaciente(command.getPersonalizadoId(), command.getNombre(),
                command.getApellido(), command.getEdad(), command.getMedida());

        emit().onResponse(new ResponseEvents(personalizado.getUncommittedChanges()));

    }
}
