package co.com.gym.entrenamiento.personalizado.usecase;

import co.com.gym.entrenamiento.personalizado.commands.AgregarPaciente;
import co.com.gym.entrenamiento.personalizado.events.PacienteAgregado;
import co.com.gym.entrenamiento.personalizado.values.Edad;
import co.com.gym.entrenamiento.personalizado.values.Medida;
import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
import co.com.gym.generic.values.Apellido;
import co.com.gym.generic.values.Nombre;
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
class AgregarPacienteUseCaseTest {

    @InjectMocks
    private AgregarPacienteUseCase useCase;

    @Mock
    private DomainEventRepository repository;


    @Test
    void agregarPacienteHappyPass() {
        //arrange
        var personalizadoId = PersonalizadoId.of("1");
        var nombre = new Nombre("juan");
        var apellido = new Apellido("toro");
        var edad = new Edad(50);
        var medida = new Medida("medida", 15D, 25D);

        var command = new AgregarPaciente(personalizadoId, nombre, apellido, edad, medida);
        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);


        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPersonalizadoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (PacienteAgregado) events.get(0);
        Assertions.assertEquals("1", event.aggregateRootId());
        Assertions.assertEquals(personalizadoId, event.getPersonalizadoId());
        Assertions.assertEquals(nombre,event.getNombre());
        Assertions.assertEquals(edad, event.getEdad());



    }


    private List<DomainEvent> history() {
        var personalizadoId = PersonalizadoId.of("1");
        var nombre = new Nombre("juan");
        var apellido = new Apellido("toro");
        var edad = new Edad(50);
        var medida = new Medida("medida", 15D, 25D);

        var event = new PacienteAgregado(personalizadoId,
                nombre,
                apellido,
                edad,
                medida);
        event.setAggregateRootId("xxx");
        return List.of(event);

    }
}