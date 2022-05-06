package co.com.sofka.crud.Mappers;

import co.com.sofka.crud.Dtos.TodoDto;
import co.com.sofka.crud.Models.Todo;


public class TodoMapper {

    public Todo deTodoDtoAEntidad(TodoDto todoDto) {

        return Todo.builder()
                .id(todoDto.getId())
                .name(todoDto.getName())
                .groupTareas(todoDto.getGroupTareas())
                .build();

    }

    public TodoDto deEntidadADto(Todo todo) {

        return TodoDto.builder()
                .id(todo.getId())
                .name(todo.getName())
                .groupTareas(todo.getGroupTareas())
                .build();
    }
}
