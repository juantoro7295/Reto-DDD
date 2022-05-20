package co.com.gym.entrenamiento.rutina.usecase;

import co.com.gym.entrenamiento.rutina.Rutina;
import co.com.gym.entrenamiento.rutina.commands.AgregarZonaDelCuerpo;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarZonaDelCuerpoUseCase extends UseCase<RequestCommand<AgregarZonaDelCuerpo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarZonaDelCuerpo> agregarZonaDelCuerpoRequestCommand) {
        var command = agregarZonaDelCuerpoRequestCommand.getCommand();
        var rutina = Rutina.from(command.getRutinaId(), repository().getEventsBy(command.getRutinaId().value())
        );
        rutina.agregarZonaDelCuerpo(command.getRutinaId(), command.getCalentamiento(), command.getZonaCuerpo());

        emit().onResponse(new ResponseEvents(rutina.getUncommittedChanges()));

    }
}
