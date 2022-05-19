package co.com.gym.entrenamiento.curso;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.gym.entrenamiento.instructor.values.ProgramaId;
import co.com.gym.generic.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearCursoUseCaseTest {

    private CrearCursoUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearCursoUseCase();
    }

    @Test
    public void crearCursoHappyPass(){
        //arrange
        var coursoId = CursoId.of("xxxxx");
        var nombre = new Nombre("DDD");
        var programaId = ProgramaId.of("dssss");
        var descripcion = new Descripcion("Curso complementario para el training");
        var command = new CrearCurso( coursoId, programaId, nombre,  descripcion);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var cursoCreado = (CursoCreado)events.get(0);
        Assertions.assertEquals("xxxxx", cursoCreado.aggregateRootId());
        Assertions.assertEquals("DDD", cursoCreado.getNombre().value());
        Assertions.assertEquals("Curso complementario para el training", cursoCreado.getDescripcion().value());

    }
}