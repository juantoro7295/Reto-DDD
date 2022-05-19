package co.com.gym.entrenamiento.instructor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.gym.entrenamiento.instructor.events.ProgramaCreado;
import co.com.gym.entrenamiento.instructor.events.PromedioActualizado;
import co.com.gym.entrenamiento.instructor.values.ProgramaId;
import co.com.gym.generic.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarPromedioProgramaUseCaseTest {

    @Mock
    private DomainEventRepository repository;


    @InjectMocks
    private ActualizarPromedioProgramaUseCase useCase;

    @Test
    void actualizarPromedioDelPrograma(){
        var event = new CursoFinalizado(new Promedio(80D), ProgramaId.of("ddddd"));
        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var promedioActualizado = (PromedioActualizado)events.get(0);
        Assertions.assertEquals(80D,promedioActualizado.getPromedio().value());
    }

    private List<DomainEvent> history() {
        var nombre = new Nombre("C2");
        var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        var event = new ProgramaCreado(nombre,fecha);
        return List.of(event);
    }

}