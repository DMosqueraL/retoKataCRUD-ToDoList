package co.com.sofka.crud.Dtos;

import co.com.sofka.crud.Models.Tarea;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class TodoDto {

    @NotBlank
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private ArrayList<Tarea> grupoTareas;


}
