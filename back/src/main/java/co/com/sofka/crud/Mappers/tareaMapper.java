package co.com.sofka.crud.Mappers;

import co.com.sofka.crud.DTOs.TareaDTO;
import co.com.sofka.crud.Models.Tarea;
import org.springframework.stereotype.Component;

@Component
public class tareaMapper {

    public Tarea deTareaDTOAEntidad(TareaDTO tareaDto){
        return Tarea.builder()
                .id(tareaDto.getId())
                .name(tareaDto.getName())
                .completado(tareaDto.getCompletado())
                .idTodo(tareaDto.getIdTodo())
                .build();
    }
}
