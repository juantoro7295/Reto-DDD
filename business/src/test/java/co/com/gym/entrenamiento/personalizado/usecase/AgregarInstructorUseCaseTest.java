package co.com.gym.entrenamiento.personalizado.usecase;

import co.com.gym.entrenamiento.instructor.entitys.Area;
import co.com.gym.entrenamiento.instructor.entitys.Contrato;
import co.com.gym.entrenamiento.instructor.entitys.Especializacion;
import co.com.gym.entrenamiento.instructor.events.InstructorCreado;
import co.com.gym.entrenamiento.instructor.values.*;
import co.com.gym.entrenamiento.personalizado.commands.AgregarInstructor;
import co.com.gym.entrenamiento.personalizado.values.PersonalizadoId;
import co.com.gym.generic.values.Apellido;
import co.com.gym.generic.values.Descripcion;
import co.com.gym.generic.values.Nombre;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class AgregarInstructorUseCaseTest {
    @InjectMocks
    private AgregarInstructorUseCase useCase;

    @Mock
    private DomainEventRepository repository;


    @Test
    void agregarInstructorHappyPass() {

        //arrange
        var personalizadoId = PersonalizadoId.of("per");
        var nombre = new Nombre("Juan");
        var apellido = new Apellido("Toro");
        var contratoId = ContratoId.of("con");
        var contrato = new Contrato(contratoId,"contrato",
                new TipoDeContrato("tipo1","detalles"));
        var areaId = AreaId.of("are");
        var area = new Area(areaId,"nombreArea",new Descripcion("descripcion"));
        var especializacionId = EspecializacionId.of("esp");
        var especializacion = new Especializacion(especializacionId,"especia",new Descripcion("descrip"));
        var command = new AgregarInstructor(personalizadoId,nombre,apellido,contrato,area,especializacion);

        when(repository.getEventsBy("per")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPersonalizadoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert

//        var event =(InstructorCreado)events.get(0);
//        Assertions.assertEquals("juan", event.getNombre().value());







    }
    private List<DomainEvent> history(){
        var instructorId = InstructorId.of("per");
        var nombre1 = new Nombre("Juan");
        var apellido1 = new Apellido("Toro");
        var contratoId1 = ContratoId.of("con");
        var contrato1 = new Contrato(contratoId1,"contrato",
                new TipoDeContrato("tipo1","detalles"));
        var areaId1 = AreaId.of("are");
        var area1 = new Area(areaId1,"nombreArea",new Descripcion("descripcion"));
        var especializacionId1 = EspecializacionId.of("esp");
        var especializacion1 = new Especializacion(especializacionId1,"especia",new Descripcion("descrip"));
        var event = new InstructorCreado(
                nombre1,
                apellido1,
                contrato1,
                area1,
                especializacion1
        );
        event.setAggregateRootId("xxxxx");
        return List.of(event);

    }
}