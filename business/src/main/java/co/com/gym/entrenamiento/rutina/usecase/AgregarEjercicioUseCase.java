package co.com.gym.entrenamiento.rutina.usecase;

import co.com.gym.entrenamiento.rutina.Rutina;
import co.com.gym.entrenamiento.rutina.commands.AgregarEjercicio;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarEjercicioUseCase extends UseCase<RequestCommand<AgregarEjercicio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEjercicio> agregarEjercicioRequestCommand) {
        var command = agregarEjercicioRequestCommand.getCommand();
        var rutina = Rutina.from(command.getRutinaId(), repository().getEventsBy(command.getRutinaId().value())
        );
        rutina.agregarEjericio(command.getRutinaId(), command.getNombreEjercicio(), command.getDetalleEjercicio(),
                command.getIntensidad());

        emit().onResponse(new ResponseEvents(rutina.getUncommittedChanges()));

    }
}
