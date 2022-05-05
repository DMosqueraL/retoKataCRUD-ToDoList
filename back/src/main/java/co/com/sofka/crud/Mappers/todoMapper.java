package co.com.sofka.crud.Mappers;

import co.com.sofka.crud.Dtos.TodoDto;
import co.com.sofka.crud.Models.Todo;
import org.springframework.stereotype.Component;

@Component
public class todoMapper {

    public Todo deTodoDtoAEntidad(TodoDto todoDto) {
        return Todo.builder().id(todoDto.getId())
                .name(todoDto.getName()).build();

    }

    public Todo deEntidadADto(Todo todo) {
        return Todo.builder().id(todo.getId())
                .name(todo.getName())
                .build();
    }
}
