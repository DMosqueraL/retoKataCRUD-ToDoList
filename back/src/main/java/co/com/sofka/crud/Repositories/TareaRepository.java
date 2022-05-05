package co.com.sofka.crud.Repositories;

import co.com.sofka.crud.Dtos.TodoDto;
import co.com.sofka.crud.Models.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends CrudRepository<Tarea, Long> {

}
