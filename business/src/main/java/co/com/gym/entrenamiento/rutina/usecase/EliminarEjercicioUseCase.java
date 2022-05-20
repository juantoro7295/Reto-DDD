package co.com.gym.entrenamiento.rutina.usecase;

import co.com.gym.entrenamiento.rutina.Rutina;
import co.com.gym.entrenamiento.rutina.commands.EliminarEjercicio;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class EliminarEjercicioUseCase extends UseCase<RequestCommand<EliminarEjercicio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<EliminarEjercicio> eliminarEjercicioRequestCommand) {
        var command = eliminarEjercicioRequestCommand.getCommand();
        var rutina = Rutina.from(command.getRutinaId(), repository().getEventsBy(command.getRutinaId().value()));
        rutina.eliminarEjericio(command.getRutinaId());

        emit().onResponse(new ResponseEvents(rutina.getUncommittedChanges()));
    }


}
