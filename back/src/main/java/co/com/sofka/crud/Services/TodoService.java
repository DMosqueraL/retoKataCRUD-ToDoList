package co.com.sofka.crud.Services;

import co.com.sofka.crud.Dtos.TodoDto;
import co.com.sofka.crud.Mappers.TodoMapper;
import co.com.sofka.crud.Models.Todo;
import co.com.sofka.crud.Repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    TodoMapper todoMapper = new TodoMapper();

   public Iterable<TodoDto> listasTodos(){
       Iterable<Todo> listaTodos = todoRepository.findAll();
       ArrayList<TodoDto> listaTodosDtos = new ArrayList<>();
       listaTodos.forEach(lista ->
               listaTodosDtos.add(todoMapper
                       .deEntidadADto(lista)));
       Iterable<TodoDto> iterableListaDtos = listaTodosDtos;
       return listaTodosDtos;
    }

    public TodoDto guardarTodo(TodoDto todoDto){
       Todo todo = todoMapper.deTodoDtoAEntidad(todoDto);
       if (todo.getName().length()>0){
           todo = todoRepository.save(todo);
       }
       todoDto.setId(todo.getId());
       return todoDto;
    }
    public boolean existsById(Long id) { return todoRepository.existsById(id);  }

    public void deleteById(Long id) { todoRepository.deleteById(id); }
}
