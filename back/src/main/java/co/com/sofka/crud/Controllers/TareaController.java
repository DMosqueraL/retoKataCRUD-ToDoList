package co.com.sofka.crud.Controllers;

import co.com.sofka.crud.Dtos.TareaDto;
import co.com.sofka.crud.Models.Tarea;
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
        return tareaService.listasTareas();
    }

    @PostMapping(value = "api/tarea")
    public TareaDto guardarTarea(@RequestBody TareaDto tareaDto) {
        return tareaService.guardarTarea(tareaDto);
    }

    @PutMapping(value = "api/tarea")
    public TareaDto actualizarTarea(@RequestBody TareaDto tareaDto) {
        if (tareaService.existeEnBD(tareaDto.getId())) {
            return tareaService.guardarTarea(tareaDto);
        }
        throw new RuntimeException("Id no encontrado en nuestra base de datos");
    }

    @DeleteMapping(value = "api/{id}/tarea")
    public void borrarTarea(@PathVariable("id") Long id) {
        tareaService.borrarTarea(id);
    }

    @GetMapping(value = "api/[id}/tarea")
    public Tarea obtenerTarea(@PathVariable("id") Long id) {
        if (tareaService.existeEnBD(id)) {
            return tareaService.obtener(id);
        }
        throw new RuntimeException("Id no encontrado en nuestra base de datos");
    }

}
