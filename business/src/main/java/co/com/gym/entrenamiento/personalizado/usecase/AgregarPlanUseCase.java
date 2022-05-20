package co.com.gym.entrenamiento.personalizado.usecase;

import co.com.gym.entrenamiento.personalizado.Personalizado;
import co.com.gym.entrenamiento.personalizado.commands.AgregarPlan;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarPlanUseCase extends UseCase<RequestCommand<AgregarPlan>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPlan> agregarPlanRequestCommand) {
        var command = agregarPlanRequestCommand.getCommand();
        var personalizado = Personalizado.from(command.getPersonalizadoId(),
                repository().getEventsBy(command.getPersonalizadoId().value()));
        personalizado.agregarPlan(command.getPersonalizadoId(),command.getNombrePlan(),command.getDescripcion());

        emit().onResponse(new ResponseEvents(personalizado.getUncommittedChanges()));

    }
}
