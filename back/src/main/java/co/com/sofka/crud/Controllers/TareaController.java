package co.com.sofka.crud.Controllers;

import co.com.sofka.crud.Models.Tarea;
import co.com.sofka.crud.Services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @PostMapping(value = "api/todo/tarea")
    public Tarea guardarTarea(@RequestBody Tarea tarea) {
        return tareaService.saveTarea(tarea);
    }

    @PutMapping(value = "api/todo/tarea")
    public Tarea actualizarTarea(@RequestBody Tarea tarea) {
        return tareaService.updateTarea(tarea);
    }

    @DeleteMapping(value = "api/todo/{id}/tarea")
    public void borrarTarea(@PathVariable("id") Long id) {
        tareaService.deleteTarea(id);
    }


}
