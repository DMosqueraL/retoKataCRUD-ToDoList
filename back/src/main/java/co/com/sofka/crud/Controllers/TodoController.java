package co.com.sofka.crud.Controllers;

import co.com.sofka.crud.Dtos.TodoDto;
import co.com.sofka.crud.Models.Todo;
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
    public TodoDto guardarTodo(@RequestBody TodoDto todoDto) {
        if (todoDto.getName().isEmpty()) {
            return this.todoService.guardarTodo(todoDto);
        }
        throw new RuntimeException("No se permiten nombres de listas vacías");
    }

    @PutMapping(value = "api/todo")
    public TodoDto actualizar(@RequestBody TodoDto todoDto) {
        if (todoDto.getId() != null && !todoDto.getName().isEmpty()) {
            return todoService.guardarTodo(todoDto);
        }
        throw new RuntimeException("Id no encontrado en nuestra base de datos.");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void borrarTodo(@PathVariable("id") Long id) {
        if (!todoService.existsById(id)) {
            throw new RuntimeException("La lista con el id " + id +
                    " no se encuentra en nuestra base de datos.");
        }
        todoService.deleteById(id);
    }

    @GetMapping(value="api/{id}/todo")
    public Todo obtenerTodo(@PathVariable("id") Long id){
        if (todoService.existsById(id)){
            return todoService.obtenerTodo(id);
        }
        throw new RuntimeException("La lista con el id " + id +
                " no se encuentra en nuestra base de datos.");
    }
}
