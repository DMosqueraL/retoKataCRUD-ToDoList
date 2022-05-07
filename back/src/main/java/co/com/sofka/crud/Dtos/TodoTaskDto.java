package co.com.sofka.crud.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class TodoTaskDto {

    @Id
    private Long id;

    private String name;

    private Boolean completed;

    private Long id_tareas;
}
