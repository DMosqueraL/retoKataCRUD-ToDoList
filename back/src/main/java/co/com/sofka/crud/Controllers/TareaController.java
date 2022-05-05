package co.com.sofka.crud.Controllers;

import co.com.sofka.crud.Dtos.TareaDto;
import co.com.sofka.crud.Dtos.TodoDto;
import co.com.sofka.crud.Services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping(value = "api/tareas")
    public Iterable<TareaDto> listaTareas() {
        return this.tareaService.listasTareas();
    }

    @PostMapping(value = "api/todo/tarea")
    public TareaDto guardarTarea(@RequestBody TareaDto tareaDto) {
        return tareaService.guardarTarea(tareaDto);
    }

    /*@PutMapping(value = "api/todo/tarea")
    public TareaDto actualizarTarea(@RequestBody TareaDto tareaDto) {
        return tareaService.actualizarTarea(tareaDto);
    }*/

    @DeleteMapping(value = "api/todo/{id}/tarea")
    public void borrarTarea(@PathVariable("id") Long id) {
        tareaService.borrarTarea(id);
    }


}
