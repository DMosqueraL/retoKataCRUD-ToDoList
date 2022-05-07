package co.com.sofka.crud.Dtos;

import co.com.sofka.crud.Models.TodoTask;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class TodoListDto {

    private Long id;

    private String name;

    private List<TodoTask> groupTodoTasks;

}
