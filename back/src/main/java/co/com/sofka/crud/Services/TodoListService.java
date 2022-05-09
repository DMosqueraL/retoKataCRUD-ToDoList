package co.com.sofka.crud.Services;

import co.com.sofka.crud.Dtos.TodoListDto;
import co.com.sofka.crud.Mappers.TodoListMapper;
import co.com.sofka.crud.Models.TodoList;
import co.com.sofka.crud.Repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoListService {

    TodoListMapper todoListMapper = new TodoListMapper();
    @Autowired
    private TodoListRepository todoListRepository;

    /**
     * Métodos para aplicar el CRUD -> Guardar (Crear), Ver (Read), Actualizar (Update), Borrar (Delete)
     * Se hacen uso de los métodos propios de la CRUD Repository
     * @return DTO's
     * @Autor: Doris Mosquera
     * @versión: 1.0.0
     */
    public Iterable<TodoListDto> listasTodos() {
        Iterable<TodoList> listaTodos = todoListRepository.findAll();
        ArrayList<TodoListDto> listaTodosDtos = new ArrayList<>();
        listaTodos.forEach(lista ->
                listaTodosDtos.add(todoListMapper.deEntidadADto(lista)));
        Iterable<TodoListDto> iterableListaDtos = listaTodosDtos;
        return listaTodosDtos;
    }

    public TodoListDto guardarTodo(TodoListDto todoListDto) {
        TodoList todoList = todoListMapper.deTodoDtoAEntidad(todoListDto);
        if (!todoList.getName().isEmpty()) {
            todoList = todoListRepository.save(todoList);
        }
        todoListDto.setId(todoList.getId());
        return todoListDto;
    }

    public boolean existsById(Long id) {
        return todoListRepository.existsById(id);
    }

    public void deleteById(Long id) {
        todoListRepository.deleteById(id);
    }

    public TodoList obtenerTodo(Long id) {
        return todoListRepository.findById(id).orElseThrow();
    }
}
