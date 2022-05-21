package co.com.gym.entrenamiento.rutina.usecase;

import co.com.gym.entrenamiento.rutina.commands.EliminarEjercicio;
import co.com.gym.entrenamiento.rutina.events.EjercicioEliminado;
import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
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
class EliminarEjercicioUseCaseTest {

    @InjectMocks
    private EliminarEjercicioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void EliminarEjercicioHappyPass() {
        //arrange
        var rutinaId = RutinaId.of("1");
        var command = new EliminarEjercicio(rutinaId);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRutinaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var event = (EjercicioEliminado) events.get(0);
        Assertions.assertEquals("1", event.aggregateRootId());
        Assertions.assertEquals(rutinaId,event.getRutinaId());

    }

    private List<DomainEvent> history() {
        var rutinaId = RutinaId.of("1");
        var event = new EjercicioEliminado(rutinaId);
        event.setAggregateRootId("xxx");
        return List.of(event);


    }


}