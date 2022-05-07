package co.com.sofka.crud.Mappers;

import co.com.sofka.crud.Dtos.TodoListDto;
import co.com.sofka.crud.Models.TodoList;


public class TodoListMapper {

    public TodoList deTodoDtoAEntidad(TodoListDto todoListDto) {

        return TodoList.builder()
                .id(todoListDto.getId())
                .name(todoListDto.getName())
                .groupTodoTasks(todoListDto.getGroupTodoTasks())
                .build();

    }

    public TodoListDto deEntidadADto(TodoList todoList) {

        return TodoListDto.builder()
                .id(todoList.getId())
                .name(todoList.getName())
                .groupTodoTasks(todoList.getGroupTodoTasks())
                .build();
    }
}
