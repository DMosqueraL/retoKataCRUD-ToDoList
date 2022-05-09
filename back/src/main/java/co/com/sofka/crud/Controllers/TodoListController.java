package co.com.sofka.crud.Controllers;

import co.com.sofka.crud.Dtos.TodoListDto;
import co.com.sofka.crud.Models.TodoList;
import co.com.sofka.crud.Services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Clase controladora, recibe todas los métodos de petición HTTP del front y
 * da respuesta a ellos por medio de DTO's
 * @Autor: Doris Mosquera Lozano
 * @versión: 1.0.0
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @GetMapping(value = "/todoList")
    public Iterable<TodoListDto> listaTodos() {
        return this.todoListService.listasTodos();
    }

    @PostMapping(value = "/todoList")
    public TodoListDto guardarTodo(@RequestBody TodoListDto todoListDto) {
        if (!todoListDto.getName().isEmpty()) {
            return this.todoListService.guardarTodo(todoListDto);
        }
        throw new RuntimeException("No se permiten nombres de listas vacías");
    }

    @PutMapping(value = "/todoList")
    public TodoListDto actualizar(@RequestBody TodoListDto todoListDto) {
        if (todoListDto.getId() != null && !todoListDto.getName().isEmpty()) {
            return todoListService.guardarTodo(todoListDto);
        }
        throw new RuntimeException("Id no encontrado en nuestra base de datos.");
    }

    @DeleteMapping(value = "/todoList/{id}")
    public void borrarTodo(@PathVariable("id") Long id) {
        if (!todoListService.existsById(id)) {
            throw new RuntimeException("La lista con el id " + id +
                    " no se encuentra en nuestra base de datos.");
        }
        todoListService.deleteById(id);
    }

    @GetMapping(value = "/todoList/{id}")
    public TodoList obtenerTodo(@PathVariable("id") Long id) {
        if (todoListService.existsById(id)) {
            return todoListService.obtenerTodo(id);
        }
        throw new RuntimeException("La lista con el id " + id +
                " no se encuentra en nuestra base de datos.");
    }
}
