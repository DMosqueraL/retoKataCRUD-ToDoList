package co.com.sofka.crud.Controllers;

import co.com.sofka.crud.Dtos.TodoTaskDto;
import co.com.sofka.crud.Models.TodoTask;
import co.com.sofka.crud.Services.TodoTaskService;
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
public class TodoTaskController {

    @Autowired
    private TodoTaskService todoTaskService;

    @GetMapping(value = "/todoTask")
    public Iterable<TodoTaskDto> listaTareas() {
        return todoTaskService.listasTareas();
    }

    @PostMapping(value = "/todoTask")
    public TodoTaskDto guardarTarea(@RequestBody TodoTaskDto todoTaskDto) {
        return todoTaskService.guardarTarea(todoTaskDto);
    }

    @PutMapping(value = "/todoTask")
    public TodoTaskDto actualizarTarea(@RequestBody TodoTaskDto todoTaskDto) {
        if (todoTaskService.existeEnBD(todoTaskDto.getId())) {
            return todoTaskService.guardarTarea(todoTaskDto);
        }
        throw new RuntimeException("Id no encontrado en nuestra base de datos");
    }

    @DeleteMapping(value = "/todoTask/{id}")
    public void borrarTarea(@PathVariable("id") Long id) {
        todoTaskService.borrarTarea(id);
    }

    @GetMapping(value = "/todoTask/{id}")
    public TodoTask obtenerTarea(@PathVariable("id") Long id) {
        if (todoTaskService.existeEnBD(id)) {
            return todoTaskService.obtener(id);
        }
        throw new RuntimeException("Id no encontrado en nuestra base de datos");
    }

}
