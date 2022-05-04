package co.com.sofka.crud.Services;

import co.com.sofka.crud.Models.Tarea;
import co.com.sofka.crud.Repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public Tarea saveTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea updateTarea(Tarea tarea) {
        if (!tareaRepository.existsById(tarea.getId())) {
            throw new RuntimeException("La tarea con id " + tarea.getId() +
                    " se encuentra en nuestra base de datos.");
        }
        return tareaRepository.save(tarea);
    }

    public void deleteTarea(Long id) {
        if (!tareaRepository.existsById(id)) {
            throw new RuntimeException("La tarea con id " + id +
                    " se encuentra en nuestra base de datos.");
        }
        tareaRepository.deleteById(id);
    }
}
