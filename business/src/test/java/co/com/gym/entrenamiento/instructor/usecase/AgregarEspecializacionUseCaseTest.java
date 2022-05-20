package co.com.gym.entrenamiento.instructor.usecase;


import co.com.gym.entrenamiento.instructor.commands.AgregarEspecializacion;
import co.com.gym.entrenamiento.instructor.events.EspecializacionAgregada;
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
class AgregarEspecializacionUseCaseTest {

    @InjectMocks
    private AgregarEspecializacionUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarEspecializacionHappyPass() {
        //arrange
        var instructorId = InstructorId.of("1");
        var descripcion = new Descripcion("descri");
        var command = new AgregarEspecializacion(instructorId, "espec", descripcion);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);


        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getInstructorId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EspecializacionAgregada) events.get(0);
        Assertions.assertEquals("1", event.aggregateRootId());
        Assertions.assertEquals(instructorId, event.getInstructorId());
        Assertions.assertEquals(descripcion, event.getDescripcion());


    }

    private List<DomainEvent> history() {
        var instructorId = InstructorId.of("1");
        var descripcion = new Descripcion("descri");
        var event = new EspecializacionAgregada(instructorId,
                "espec",
                descripcion);

        event.setAggregateRootId("xxx");
        return List.of(event);
    }
}