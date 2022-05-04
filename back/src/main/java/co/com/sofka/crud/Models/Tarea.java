package co.com.sofka.crud.Models;

import lombok.Builder;

import javax.persistence.*;

@Builder(toBuilder = true)
@Table(name="tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="Completado")
    private Boolean completado;

    @Column(name="id_todo")
    private Long idTodo;

    public Tarea() {
    }

    public Tarea(Long id, String name, Boolean completado, Long idTodo) {
        this.id = id;
        this.name = name;
        this.completado = completado;
        this.idTodo = idTodo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    public Long getIdTodo() {
        return idTodo;
    }

    public void setIdTodo(Long idTodo) {
        this.idTodo = idTodo;
    }
}
