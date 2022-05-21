package co.com.gym.entrenamiento.personalizado.event;

import co.com.gym.entrenamiento.personalizado.events.PersonalizadoActualizado;
import co.com.gym.entrenamiento.personalizado.events.PersonalizadoFinalizado;
import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarPersonalizadoUseCaseTest {
    @InjectMocks
    private ActualizarPersonalizadoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void personalizadoActualizadoHappyPass() {
        //arrange
        var personalizadoId = PersonalizadoId.of("1");
        var event = new PersonalizadoFinalizado(personalizadoId);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var personalizadoActualizado = (PersonalizadoActualizado) events.get(0);
        Assertions.assertEquals("1",personalizadoActualizado.getPersonalizadoId().value());

    }

    private List<DomainEvent> history() {
        var personalizadoId = PersonalizadoId.of("1");
        var event = new PersonalizadoActualizado(personalizadoId);
        return List.of(event);
    }
}