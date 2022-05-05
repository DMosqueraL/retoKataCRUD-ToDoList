package co.com.sofka.crud.Mappers;

import co.com.sofka.crud.Dtos.TodoDto;
import co.com.sofka.crud.Models.Todo;
import org.springframework.stereotype.Component;



public class TodoMapper {

    public Todo deTodoDtoAEntidad(TodoDto todoDto) {
        /*Todo todo = new Todo();
        todo.setId(todoDto.getId());
        todo.setName(todo.getName());
        todo.setGrupoTareas(todoDto.getGrupoTareas());

        return  todo;*/
        return Todo.builder().id(todoDto.getId())
                .name(todoDto.getName()).build();

    }

    public TodoDto deEntidadADto(Todo todo) {
        /*TodoDto todoDto = new TodoDto();
        todoDto.setId(todo.getId());
        todoDto.setName(todo.getName());
        todoDto.setGrupoTareas(todo.getGrupoTareas());

        return todoDto;*/
        return TodoDto.builder().id(todo.getId())
                .name(todo.getName())
                .build();
    }
}
