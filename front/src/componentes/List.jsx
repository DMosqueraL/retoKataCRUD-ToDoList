import React, { Fragment, useContext, useEffect } from "react";
import { Store } from "../hooks/Store";
import { HOST_API } from "../conexiones/HOST_API";
import Form from "../componentes/Form";

export const List = () => {
  const {
    dispatch,
    state: { todo, listas },
  } = useContext(Store);
  const currentTodos = todo.list;
  const currentList = listas.list;

  useEffect(() => {
    fetch(HOST_API + "tareas")
      .then((response) => response.json())
      .then((list) => {
        dispatch({ type: "update-list", list });
      });
  }, [dispatch]);

  const onDelete = (id) => {
    fetch(HOST_API + id + "/tarea", {
      method: "DELETE",
    }).then((list) => {
      dispatch({ type: "delete-item", id });
    });
  };

  const onEdit = (todo) => {
    dispatch({ type: "edit-item", item: todo });
  };

  const onChange = (event, todo, idTareas) => {
    const request = {
      name: todo.name,
      id: todo.id,
      completado: event.target.checked,
      idTareas: idTareas,
    };
    fetch(HOST_API + "tarea", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((todo) => {
        dispatch({ type: "update-item", item: todo });
      });
  };

  useEffect(() => {
    fetch(HOST_API + "todos")
      .then((response) => response.json())
      .then((list) => {
        dispatch({ type: "update-listOfList", list });
      });
  }, [dispatch]);

  const onDeleteList = (id) => {
    const deleteAllListItem = todo.list.map((item) => {
      if (item.idTareas === id) {
        onDelete(item.id);
      }
    });

    fetch(HOST_API + id + "/todo", {
      method: "DELETE",
    }).then((list) => {
      dispatch({ type: "delete-list", id });
    });
  };

  const decorationDone = {
    textDecoration: "line-through",
  };
  return (
    <>
      <table cellspacing="0">
        <tbody>
          {currentList.map((list) => {
            return (
              <Fragment key={list.id}>
                <div className="listDiv">
                  <tr>
                    <td id="TitleText">{list.name}</td>
                    <td>
                      <button
                        className="deleteListButton"
                        onClick={() => onDeleteList(list.id)}
                      >
                        Eliminar
                      </button>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <Form idTareas={list.id} />
                    </td>
                  </tr>
                  <tr>
                    <td>Tarea</td>
                    <td>¿Completado?</td>
                  </tr>
                  {currentTodos.map((todo) => {
                    if (todo.idTareas === list.id) {
                      return (
                        <tr
                          key={todo.id}
                          style={todo.completado ? decorationDone : {}}
                        >
                          <td>{todo.name}</td>
                          <td>
                            <input
                              type="checkbox"
                              defaultChecked={todo.completado}
                              onChange={(event) =>
                                onChange(event, todo, list.id)
                              }
                            ></input>
                          </td>
                          <td>
                            <button
                              className="DeleteButton"
                              onClick={() => onDelete(todo.id)}
                            >
                              Eliminar
                            </button>
                          </td>
                          <td>
                            <button
                              className="EditButton"
                              onClick={() => onEdit(todo)}
                            >
                              Editar
                            </button>
                          </td>
                        </tr>
                      );
                    }
                    return;
                  })}
                </div>
              </Fragment>
            );
          })}
        </tbody>
      </table>
    </>
  );
};

export default List;
