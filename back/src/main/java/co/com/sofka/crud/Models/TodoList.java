package co.com.sofka.crud.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Anotaciones para identificar que es una entidad - Spring Boot (@Entity)
 * La creación de la tabla - Spring Boot (@Table)
 * Las demás anotaciones las suministra Lombok para el ahorro de código
 * (@NoArgsConstructor -  @AllArgsConstructor) -> Crea dos constructores, el primero vacío y
 * el segundo con todos los atributos respectivamente.
 * (@Data) Crea los getters/setters/toString de la entidad
 *
 * @Autor: Doris Mosquera
 * @versión: 1.0.0
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@Table(name = "todo_listas")
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    /**
     * Relación entre las dos entidades del proyecto
     * 1 proyecto (lista) tiene muchas tareas
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tareas")
    private List<TodoTask> groupTodoTasks;


}
