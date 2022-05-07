package co.com.sofka.crud.Repositories;

import co.com.sofka.crud.Models.TodoTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoTaskRepository extends CrudRepository<TodoTask, Long> {

}
