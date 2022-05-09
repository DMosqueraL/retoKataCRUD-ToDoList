package co.com.sofka.crud.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "tareas")
public class TodoTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "completed")
    private Boolean completed;

    @Column(name = "id_tareas")
    private Long id_tareas;

}
