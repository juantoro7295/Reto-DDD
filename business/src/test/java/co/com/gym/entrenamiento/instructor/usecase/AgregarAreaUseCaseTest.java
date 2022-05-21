package co.com.gym.entrenamiento.instructor.usecase;

import co.com.gym.entrenamiento.instructor.commands.AgregarArea;
import co.com.gym.entrenamiento.instructor.events.AreaAgregada;
import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.gym.generic.values.Descripcion;
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
class AgregarAreaUseCaseTest {

    @InjectMocks
    private AgregarAreaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarAreaHappyPass() {

        //arrange
        var instructorId = InstructorId.of("1");
        var descripcion = new Descripcion("descripcion");
        var command = new AgregarArea(instructorId, "area", descripcion);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getInstructorId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts

        var event = (AreaAgregada) events.get(0);
        Assertions.assertEquals("1", event.aggregateRootId());
        Assertions.assertEquals(instructorId, event.getInstructorId());


    }


    private List<DomainEvent> history() {

        var instructorId = InstructorId.of("1");
        var descripcion = new Descripcion("descripcion");
        var event = new AreaAgregada("area",
                descripcion,
                instructorId);

        event.setAggregateRootId("xxx");
        return List.of(event);
    }
}