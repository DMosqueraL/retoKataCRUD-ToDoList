package co.com.sofka.crud.Services;

import co.com.sofka.crud.Models.Todo;
import co.com.sofka.crud.Repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Iterable<Todo> listasTodos() { return todoRepository.findAll(); }

    public Todo save(Todo todo){
        return todoRepository.save(todo);
    }

    public void delete(Long id, ArrayList<Long> idTareas){
        todoRepository.delete(get(id));
    }

    public Todo get(Long id){
         return todoRepository.findById(id).orElseThrow();
    }


}
