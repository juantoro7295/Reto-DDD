package co.com.gym.entrenamiento.rutina.usecase.event;

import co.com.gym.entrenamiento.rutina.events.RutinaActualizada;
import co.com.gym.entrenamiento.rutina.events.Rutinafinalizada;
import co.com.gym.entrenamiento.rutina.values.RutinaId;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarRutinaUseCaseTest {
    @InjectMocks
    private ActualizarRutinaUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void rutinaFinalizadaHappyPass() {
        //arrange
        var rutinaId = RutinaId.of("1");
        var event = new Rutinafinalizada(rutinaId);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var rutinaActualizada = (RutinaActualizada) events.get(0);
        Assertions.assertEquals("1", rutinaActualizada.getRutinaId().value());


    }

    private List<DomainEvent> history() {
        var rutinaId = RutinaId.of("1");
        var event = new RutinaActualizada(rutinaId);

        return List.of(event);

    }
}