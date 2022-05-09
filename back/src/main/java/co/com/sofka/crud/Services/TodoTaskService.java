package co.com.sofka.crud.Services;

import co.com.sofka.crud.Dtos.TodoTaskDto;
import co.com.sofka.crud.Mappers.TodoTaskMapper;
import co.com.sofka.crud.Models.TodoTask;
import co.com.sofka.crud.Repositories.TodoTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoTaskService {

    TodoTaskMapper todoTaskMapper = new TodoTaskMapper();
    @Autowired
    private TodoTaskRepository todoTaskRepository;

    /**
     * Métodos para aplicar el CRUD -> Guardar (Crear), Ver (Read), Actualizar (Update), Borrar (Delete)
     * Se hacen uso de los métodos propios de la CRUD Repository
     *  @return DTO's
     *  @Autor: Doris Mosquera
     *  @versión: 1.0.0
     */
    public Iterable<TodoTaskDto> listasTareas() {
        Iterable<TodoTask> listaTareas = todoTaskRepository.findAll();
        ArrayList<TodoTaskDto> listaTareasDtos = new ArrayList<>();
        listaTareas.forEach(tarea ->
                listaTareasDtos.add(todoTaskMapper.deEntidadATodoTaskDto(tarea)));
        Iterable<TodoTaskDto> iterableTareasDtos = listaTareasDtos;
        return listaTareasDtos;
    }

    public TodoTaskDto guardarTarea(TodoTaskDto todoTaskDto) {
        TodoTask todoTask = todoTaskMapper.deTodoTaskDtoAEntidad(todoTaskDto);
        if (todoTask.getName().length() > 0) {
            todoTask = todoTaskRepository.save(todoTask);
        }
        todoTaskDto.setId(todoTask.getId());
        return todoTaskDto;
    }

    public void borrarTarea(Long id) {
        if (!todoTaskRepository.existsById(id)) {
            throw new RuntimeException("La tarea con id " + id +
                    " no se encuentra en nuestra base de datos.");
        }
        todoTaskRepository.deleteById(id);
    }

    public TodoTask obtener(Long id) {
        return todoTaskRepository.findById(id).orElseThrow();
    }

    public boolean existeEnBD(Long id) {
        return todoTaskRepository.existsById(id);
    }


}
