package co.com.sofka.crud.Repositories;

import co.com.sofka.crud.Models.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList, Long> {

}
