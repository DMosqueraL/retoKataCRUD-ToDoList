package co.com.sofka.crud.Mappers;

import co.com.sofka.crud.Dtos.TareaDto;
import co.com.sofka.crud.Models.Tarea;


public class TareaMapper {

    public Tarea deTareaDtoAEntidad(TareaDto tareaDto) {

        return Tarea.builder()
                .id(tareaDto.getId())
                .name(tareaDto.getName())
                .completed(tareaDto.getCompleted())
                .idTareas(tareaDto.getIdTareas())
                .build();
    }

    public TareaDto deEntidadADto(Tarea tarea) {

        return TareaDto.builder()
                .id(tarea.getId())
                .name(tarea.getName())
                .completed((tarea.getCompleted()))
                .idTareas(tarea.getIdTareas())
                .build();
    }
}
