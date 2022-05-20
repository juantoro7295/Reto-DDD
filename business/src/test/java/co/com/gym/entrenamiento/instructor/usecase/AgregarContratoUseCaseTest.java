package co.com.gym.entrenamiento.instructor.usecase;

import co.com.gym.entrenamiento.instructor.commands.AgregarContrato;
import co.com.gym.entrenamiento.instructor.events.AreaAgregada;
import co.com.gym.entrenamiento.instructor.events.ContratoAgregado;
import co.com.gym.entrenamiento.instructor.values.InstructorId;
import co.com.gym.entrenamiento.instructor.values.TipoDeContrato;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarContratoUseCaseTest {
    @InjectMocks
    private AgregarContratoUseCase useCase;

    @Mock
    private DomainEventRepository repository;


    @Test
    void executeUseCase() {
        //arrange
        var instructorId = InstructorId.of("1");
        var tipoDeContrato = new TipoDeContrato("tipo", "detalle");
        var command = new AgregarContrato(instructorId, "contra", tipoDeContrato);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getInstructorId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ContratoAgregado) events.get(0);
        Assertions.assertEquals("1", event.aggregateRootId());
        Assertions.assertEquals(instructorId, event.getInstructorId());

    }

    private List<DomainEvent> history() {
        var instructorId = InstructorId.of("1");
        var tipoDeContrato = new TipoDeContrato("tipo", "detalle");
        var event = new ContratoAgregado(instructorId,
                "contra",
                tipoDeContrato);

        event.setAggregateRootId("xxx");
        return List.of(event);
    }
}