package co.com.gym.entrenamiento.rutina.usecase.event;

import co.com.gym.entrenamiento.rutina.Rutina;
import co.com.gym.entrenamiento.rutina.events.Rutinafinalizada;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class ActualizarRutinaUseCase extends UseCase<TriggeredEvent<Rutinafinalizada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<Rutinafinalizada> ejercicioFinalizadoTriggeredEvent) {
        var event = ejercicioFinalizadoTriggeredEvent.getDomainEvent();
        var rutina = Rutina.from(event.getRutinaId(), repository().getEventsBy(event.getRutinaId().value()));
        rutina.actualizarRutina(event.getRutinaId());

        emit().onResponse(new ResponseEvents(rutina.getUncommittedChanges()));
    }
}
