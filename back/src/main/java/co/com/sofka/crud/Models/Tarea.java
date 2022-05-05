package co.com.sofka.crud.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "Completado")
    @NotBlank
    private Boolean completado;

    @Column(name = "id_todoLista")
    @NotBlank
    private Long idTareas;

}
