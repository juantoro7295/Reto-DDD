package co.com.gym.entrenamiento.rutina.usecase;

import co.com.gym.entrenamiento.rutina.commands.AgregarZonaDelCuerpo;
import co.com.gym.entrenamiento.rutina.events.ZonaDelCuerpoAgregada;
import co.com.gym.entrenamiento.rutina.values.Calentamiento;
import co.com.gym.entrenamiento.rutina.values.RutinaId;
import co.com.gym.entrenamiento.rutina.values.ZonaCuerpo;
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


@ExtendWith(MockitoExtension.class)
class AgregarZonaDelCuerpoUseCaseTest {

    @InjectMocks
    private AgregarZonaDelCuerpoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarZonaDelCuerpoHappyPass() {
        //arrange
        var rutinaId = RutinaId.of("1");
        var calentamiento = new Calentamiento("cardio", "15");
        var zonaCuerpo = new ZonaCuerpo("pecho", "dato");

        var command = new AgregarZonaDelCuerpo(rutinaId, calentamiento, zonaCuerpo);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRutinaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert

        var event = (ZonaDelCuerpoAgregada) events.get(0);
        Assertions.assertEquals("1", event.aggregateRootId());
        Assertions.assertEquals(rutinaId, event.getRutinaId());
    }

    private List<DomainEvent> history() {
        var rutinaId = RutinaId.of("1");
        var calentamiento = new Calentamiento("cardio", "15");
        var zonaCuerpo = new ZonaCuerpo("pecho", "dato");
        var event = new ZonaDelCuerpoAgregada(rutinaId, calentamiento, zonaCuerpo);

        event.setAggregateRootId("xxx");
        return List.of(event);


    }
}