package co.com.gym.entrenamiento.rutina.usecase;

import co.com.gym.entrenamiento.rutina.Rutina;
import co.com.gym.entrenamiento.rutina.commands.AgregarMaterial;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarMaterialUseCase extends UseCase<RequestCommand<AgregarMaterial>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMaterial> agregarMaterialRequestCommand) {
        var command = agregarMaterialRequestCommand.getCommand();
        var rutina = Rutina.from(command.getRutinaId(), repository().getEventsBy(command.getRutinaId().value())
        );
        rutina.agregarMaterial(command.getRutinaId(),command.getNombreMaterial(),command.getDetalle());

        emit().onResponse(new ResponseEvents(rutina.getUncommittedChanges()));
    }
}
