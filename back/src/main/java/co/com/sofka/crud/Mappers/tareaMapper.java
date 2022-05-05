package co.com.sofka.crud.Mappers;

import co.com.sofka.crud.Dtos.TareaDto;
import co.com.sofka.crud.Models.Tarea;
import org.springframework.stereotype.Component;

@Component
public class tareaMapper {

    public Tarea deTareaDtoAEntidad(TareaDto tareaDto) {
        return Tarea.builder()
                .id(tareaDto.getId())
                .name(tareaDto.getName())
                .completado(tareaDto.getCompletado())
                .idTareas(tareaDto.getIdTareas())
                .build();
    }

    public Tarea deEntidadADto(Tarea tarea) {
        return Tarea.builder()
                .id(tarea.getId())
                .name(tarea.getName())
                .completado((tarea.getCompletado()))
                .idTareas(tarea.getIdTareas())
                .build();
    }
}
