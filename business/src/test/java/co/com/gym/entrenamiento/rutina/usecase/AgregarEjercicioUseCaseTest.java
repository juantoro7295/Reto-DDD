package co.com.gym.entrenamiento.rutina.usecase;

import co.com.gym.entrenamiento.personalizado.usecase.AgregarInstructorUseCase;
import co.com.gym.entrenamiento.rutina.Rutina;
import co.com.gym.entrenamiento.rutina.commands.AgregarEjercicio;
import co.com.gym.entrenamiento.rutina.events.EjercicioCreado;
import co.com.gym.entrenamiento.rutina.values.DetalleEjercicio;
import co.com.gym.entrenamiento.rutina.values.Intensidad;
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
class AgregarEjercicioUseCaseTest {

    @InjectMocks
    private AgregarEjercicioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarEjericicioHappyPass() {
        var rutinaId = RutinaId.of("1");
        var detalleEjercicio = new DetalleEjercicio("5","4","60");
        var intensidad = new Intensidad("10","5");
        var command = new AgregarEjercicio(rutinaId,"ejercicio1",detalleEjercicio,intensidad);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRutinaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (EjercicioCreado) events.get(0);
        Assertions.assertEquals("1",event.aggregateRootId());
        Assertions.assertEquals(rutinaId,event.getRutinaId());


    }

    private List<DomainEvent> history(){
        var rutinaId = RutinaId.of("1");
        var detalleEjercicio = new DetalleEjercicio("5","4","60");
        var intensidad = new Intensidad("10","5");
        var event = new EjercicioCreado(rutinaId,
                "ejercicio1",
                detalleEjercicio,
                intensidad);
        event.setAggregateRootId("xxx");
        return List.of(event);
    }
}