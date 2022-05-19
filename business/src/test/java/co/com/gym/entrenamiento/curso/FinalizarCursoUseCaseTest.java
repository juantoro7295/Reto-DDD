package co.com.gym.entrenamiento.curso;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.gym.entrenamiento.curso.services.ConsultarPromedioDeCurso;
import co.com.gym.entrenamiento.instructor.values.ProgramaId;
import co.com.gym.generic.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FinalizarCursoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Mock
    private ConsultarPromedioDeCurso service;

    @InjectMocks
    private FinalizarCursoUseCase useCase;

    @Test
    void finalizarCurso(){
        var programaId = ProgramaId.of("dddd");
        var command = new FinalizarCurso(CursoId.of("wwwww"), programaId);
        when(repository.getEventsBy("wwwww")).thenReturn(history());
        when(service.consultarPorCursoId(any(CursoId.class))).thenReturn(new Promedio(75D));
        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (CursoFinalizado)events.get(0);
        Assertions.assertEquals(75D, event.getPromedio().value());
    }

    private List<DomainEvent> history() {
        var nombre = new Nombre("DDD");
        var programaId = ProgramaId.of("dddd");
        var descripcion = new Descripcion("Curso complementario para el training");
        var event = new CursoCreado(
                nombre,
                descripcion,
                programaId);
        return List.of(event);
    }
}