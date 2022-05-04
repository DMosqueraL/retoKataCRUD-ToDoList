package co.com.sofka.crud.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class TareaDTO {

    @NotBlank
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private Boolean completado;

    @NotBlank
    private Long idTodo;
}
