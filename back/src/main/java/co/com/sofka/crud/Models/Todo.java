package co.com.sofka.crud.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@Table(name = "todo_listas")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_todoLista")
    @NotBlank
    private List<Tarea> grupoTareas;



}
