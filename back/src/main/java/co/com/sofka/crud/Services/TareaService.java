package co.com.sofka.crud.Services;

import co.com.sofka.crud.Dtos.TareaDto;
import co.com.sofka.crud.Mappers.TareaMapper;
import co.com.sofka.crud.Models.Tarea;
import co.com.sofka.crud.Repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TareaService {

    TareaMapper tareaMapper = new TareaMapper();
    @Autowired
    private TareaRepository tareaRepository;

    public Iterable<TareaDto> listasTareas() {
        Iterable<Tarea> listaTareas = tareaRepository.findAll();
        ArrayList<TareaDto> listaTareasDtos = new ArrayList<>();
        listaTareas.forEach(tarea ->
                listaTareasDtos.add(tareaMapper.deEntidadADto(tarea)));
        Iterable<TareaDto> iterableTareasDtos = listaTareasDtos;
        return listaTareasDtos;
    }

    public TareaDto guardarTarea(TareaDto tareaDto) {
        Tarea tarea = tareaMapper.deTareaDtoAEntidad(tareaDto);
        if (tarea.getName().length() > 0) {
            tarea = tareaRepository.save(tarea);
        }
        tareaDto.setId(tarea.getId());
        return tareaDto;
    }

    public void borrarTarea(Long id) {
        if (!tareaRepository.existsById(id)) {
            throw new RuntimeException("La tarea con id " + id +
                    " no se encuentra en nuestra base de datos.");
        }
        tareaRepository.deleteById(id);
    }

    public Tarea obtener(Long id) {
        return tareaRepository.findById(id).orElseThrow();
    }

    public boolean existeEnBD(Long id) {
        return tareaRepository.existsById(id);
    }







    /*public TareaDto actualizarTarea(TareaDto tareaDto) {
        if (tareaRepository.existsById(tareaDto.getId())) {
            return tareaRepository.save(tarea);
        }
        throw new RuntimeException("Id no encontrado en la base de datos");
    }*/


}
