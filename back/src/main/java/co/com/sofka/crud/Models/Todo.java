package co.com.sofka.crud.Models;

import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Builder(toBuilder = true)
@Table (name = "todo_lista")
public class Todo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="id_todo")
    private ArrayList<Tarea> grupoTareas;

    public Todo() {
    }

    public Todo(String name) {
        this.name = name;
    }

    public Todo(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public ArrayList<Tarea> getGrupoTareas() {
        return grupoTareas;
    }

    public void setGrupoTareas(ArrayList<Tarea> grupoTareas) {
        this.grupoTareas = grupoTareas;
    }
}
