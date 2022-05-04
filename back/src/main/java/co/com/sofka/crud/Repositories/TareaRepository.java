package co.com.sofka.crud.Repositories;

import co.com.sofka.crud.Models.Tarea;
import org.springframework.data.repository.CrudRepository;

public interface TareaRepository extends CrudRepository <Tarea, Long> {
}
