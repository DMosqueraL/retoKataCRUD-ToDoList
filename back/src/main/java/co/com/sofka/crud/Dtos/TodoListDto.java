package co.com.sofka.crud.Dtos;

import co.com.sofka.crud.Models.TodoTask;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Clase que permitirá la transferencia de datos entre el front y el back
 * Anotaciones de la librería Lombok
 * (@AllArgsConstructor) -> Crea un constructor con todos los argumentos
 * (@NoArgsConstructor) -> Constructor vacío - por defecto
 * (@Data) -> Getters/Setters/ToString
 * (@Builder( )) -> Constructor del patrón de diseño Builder propio de la librería de Lombok
 * Facilitará el mapeo de las entidades
 * @Autor: Doris Mosquera
 * @versión: 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class TodoListDto {

    private Long id;

    private String name;

    private List<TodoTask> groupTodoTasks;

}
