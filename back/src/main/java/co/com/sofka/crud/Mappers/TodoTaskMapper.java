package co.com.sofka.crud.Mappers;

import co.com.sofka.crud.Dtos.TodoTaskDto;
import co.com.sofka.crud.Models.TodoTask;


public class TodoTaskMapper {

    public TodoTask deTodoTaskDtoAEntidad(TodoTaskDto todoTaskDto) {

        return TodoTask.builder()
                .id(todoTaskDto.getId())
                .name(todoTaskDto.getName())
                .completed(todoTaskDto.getCompleted())
                .id_tareas(todoTaskDto.getId_tareas())
                .build();
    }

    public TodoTaskDto deEntidadATodoTaskDto(TodoTask todoTask) {

        return TodoTaskDto.builder()
                .id(todoTask.getId())
                .name(todoTask.getName())
                .completed((todoTask.getCompleted()))
                .id_tareas(todoTask.getId_tareas())
                .build();
    }
}
