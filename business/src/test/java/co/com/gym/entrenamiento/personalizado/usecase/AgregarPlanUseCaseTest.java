package co.com.gym.entrenamiento.personalizado.usecase;

import co.com.gym.entrenamiento.personalizado.Personalizado;
import co.com.gym.entrenamiento.personalizado.commands.AgregarPlan;
import co.com.gym.entrenamiento.personalizado.entitys.Plan;
import co.com.gym.entrenamiento.personalizado.events.PlanAgregado;
import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
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
class AgregarPlanUseCaseTest {

    @InjectMocks
    private AgregarPlanUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarPlanHappyPass() {
        //arrange
        var personalizadoId = PersonalizadoId.of("1");
        var descripcion = new Descripcion("descri");
        var command = new AgregarPlan(personalizadoId, "nombre", descripcion);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPersonalizadoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (PlanAgregado) events.get(0);
        Assertions.assertEquals("1", event.aggregateRootId());
        Assertions.assertEquals(personalizadoId, event.getPersonalizadoId());
        Assertions.assertEquals(descripcion, event.getDescripcion());


    }


    private List<DomainEvent> history() {
        var personalizadoId = PersonalizadoId.of("1");
        var descripcion = new Descripcion("descri");
        var event = new PlanAgregado(personalizadoId,
                "nombre",
                descripcion);
        event.setAggregateRootId("xxx");
        return List.of(event);

    }
}