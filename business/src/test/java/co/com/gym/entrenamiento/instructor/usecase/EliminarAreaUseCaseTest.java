package co.com.gym.entrenamiento.instructor.usecase;

import co.com.gym.entrenamiento.instructor.commands.EliminarArea;
import co.com.gym.entrenamiento.instructor.events.AreaEliminada;
import co.com.gym.entrenamiento.instructor.values.InstructorId;
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

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class EliminarAreaUseCaseTest {
    @InjectMocks
    private EliminarAreaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void eliminarAreaHappyPass() {
        var instructorId = InstructorId.of("1");
        var command = new EliminarArea(instructorId);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);


        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getInstructorId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (AreaEliminada) events.get(0);
        Assertions.assertEquals("1", event.aggregateRootId());
        Assertions.assertEquals(instructorId, event.instructorId());
    }

    private List<DomainEvent> history() {
        var instructorId = InstructorId.of("1");
        var event = new AreaEliminada(instructorId);
        event.setAggregateRootId("xxx");
        return List.of(event);

    }
}