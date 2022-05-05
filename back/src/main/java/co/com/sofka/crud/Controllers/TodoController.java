package co.com.sofka.crud.Controllers;

import co.com.sofka.crud.Dtos.TodoDto;
import co.com.sofka.crud.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "api/todos")
    public Iterable<TodoDto> listaTodos() {
        return this.todoService.listasTodos();
    }

    @PostMapping(value = "api/todo")
    public TodoDto guardarTodo(@RequestBody TodoDto todoDto){
        return this.todoService.guardarTodo(todoDto);
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void borrarTodo(@PathVariable("id") Long id) {
        if(!todoService.existsById(id)) {
            throw new RuntimeException("La lista con el id " + id +
                    " no se encuentra en nuestra base de datos.");
        }
        todoService.deleteById(id);
    }
}
