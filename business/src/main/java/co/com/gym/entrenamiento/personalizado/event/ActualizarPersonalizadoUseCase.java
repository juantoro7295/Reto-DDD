package co.com.gym.entrenamiento.personalizado.event;

import co.com.gym.entrenamiento.personalizado.Personalizado;
import co.com.gym.entrenamiento.personalizado.events.PersonalizadoFinalizado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class ActualizarPersonalizadoUseCase extends UseCase<TriggeredEvent<PersonalizadoFinalizado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<PersonalizadoFinalizado> personalizadoFinalizadoTriggeredEvent) {
        var event = personalizadoFinalizadoTriggeredEvent.getDomainEvent();
        var personalizado = Personalizado.from(event.getPersonalizadoId(),
                repository().getEventsBy(event.getPersonalizadoId().value()));

        personalizado.actualizarPersonalizado(event.getPersonalizadoId());

        emit().onResponse(new ResponseEvents(personalizado.getUncommittedChanges()));
    }
}
