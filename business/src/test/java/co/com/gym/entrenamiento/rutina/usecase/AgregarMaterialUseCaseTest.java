package co.com.gym.entrenamiento.rutina.usecase;

import co.com.gym.entrenamiento.rutina.commands.AgregarMaterial;
import co.com.gym.entrenamiento.rutina.events.MaterialAgregado;
import co.com.gym.entrenamiento.rutina.values.Detalle;
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

@ExtendWith(MockitoExtension.class)
class AgregarMaterialUseCaseTest {

    @InjectMocks
    private AgregarMaterialUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void AgregarMaterialUseCaseTestHappyPass() {
        //arrange
        var rutinaId = RutinaId.of("1");
        var detalle = new Detalle("detalle", 5D);
        var command = new AgregarMaterial(rutinaId, "nombreMaterial", detalle);
        //assert
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRutinaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (MaterialAgregado) events.get(0);
        Assertions.assertEquals("1", event.aggregateRootId());
        Assertions.assertEquals(rutinaId, event.getRutinaId());


    }

    private List<DomainEvent> history() {
        var rutinaId = RutinaId.of("1");
        var detalle = new Detalle("detalle", 5D);
        var event = new MaterialAgregado(rutinaId, "nombreMaterial", detalle);

        event.setAggregateRootId("xxx");
        return List.of(event);

    }
}