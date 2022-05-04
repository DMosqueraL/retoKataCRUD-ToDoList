package co.com.sofka.crud.Controllers;

import co.com.sofka.crud.Models.Todo;
import co.com.sofka.crud.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "api/todos")
    public Iterable<Todo> listaTodos(){
        return todoService.listasTodos();
    }
    
    @PostMapping(value = "api/todo")
    public Todo saveTodo(@RequestBody Todo todo){
        return todoService.save(todo);
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void deleteTodo(@PathVariable("id")Long id, @RequestBody ArrayList<Long> idTareas){
        todoService.delete(id, idTareas);
    }

    @GetMapping(value = "api/{id}/todo")
    public Todo get(@PathVariable("id") Long id){
        return todoService.get(id);
    }

}
