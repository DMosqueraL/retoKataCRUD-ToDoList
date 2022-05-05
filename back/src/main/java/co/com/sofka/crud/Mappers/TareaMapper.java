package co.com.sofka.crud.Mappers;

import co.com.sofka.crud.Dtos.TareaDto;
import co.com.sofka.crud.Models.Tarea;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;



public class TareaMapper {

    public Tarea deTareaDtoAEntidad(TareaDto tareaDto) {
        Tarea tarea = new Tarea();
        tarea.setId(tareaDto.getId());
        tarea.setName(tareaDto.getName());
        tarea.setCompletado(tareaDto.getCompletado());
        tarea.setIdTareas(tareaDto.getIdTareas());

        return tarea;
        /*return Tarea.builder()
                .id(tareaDto.getId())
                .name(tareaDto.getName())
                .completado(tareaDto.getCompletado())
                .idTareas(tareaDto.getIdTareas())
                .build();*/
    }

    public TareaDto deEntidadADto(Tarea tarea) {
        TareaDto tareaDto = new TareaDto();
        tareaDto.setId(tarea.getId());
        tareaDto.setName(tarea.getName());
        tareaDto.setCompletado(tarea.getCompletado());
        tareaDto.setIdTareas(tarea.getIdTareas());

        return tareaDto;
        /*return TareaDto.builder()
                .id(tarea.getId())
                .name(tarea.getName())
                .completado((tarea.getCompletado()))
                .idTareas(tarea.getIdTareas())
                .build();*/
    }
}
