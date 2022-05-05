package co.com.sofka.crud.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class TareaDto {

    @NotBlank
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private Boolean completado;

    @NotBlank
    private Long idTareas;
}
