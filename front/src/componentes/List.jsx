import React, { useContext, useEffect, Fragment  } from "react";
import { Store } from "../hooks/Store";
import { HOST_API } from "../conexiones/HOST_API";
import FormTodoTask from "../componentes/FormTodoTask"

export const List = () => {
  
  const {
    dispatch,
    state: { todoTask, todoList },
  } = useContext(Store);
  const currentTodos = todoTask.list;
  const currentList = todoList.list;

  useEffect(() => {
    fetch(HOST_API + "/todoTask")
      .then((response) => response.json())
      .then((list) => {
        dispatch({ type: "update-list", list });
      });
  }, [dispatch]);

  const onDelete = (id) => {
    fetch(HOST_API + "/todoTask/" + id, {
      method: "DELETE",
    }).then((list) => {
      dispatch({ type: "delete-item", id });
    });
  };

  const onDeleteTask = (id) => {
    fetch(HOST_API + "/todoTask/" + id, {
      method: "DELETE",
    }).then((list) => {
      dispatch({ type: "delete-task", id });
    });
  };

  const onEdit = (todoTask) => {
    dispatch({ type: "edit-item", item: todoTask });
  };

  const onChange = (event, todoTask, id_tareas) => {
    const request = {
      name: todoTask.name,
      id: todoTask.id,
      completed: event.target.checked,
      id_tareas: id_tareas,
    };
    
    fetch(HOST_API + "/todoTask", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((todoTask) => {
        dispatch({ type: "update-item", item: todoTask });
      });
  };

  useEffect(() => {
    fetch(HOST_API + "/todoList")
      .then((response) => response.json())
      .then((list) => {
        dispatch({ type: "update-listOfList", list });
      });
  }, [dispatch]);

  const onDeleteList = (id) => {
    const deleteAllListItem = todoList.list.map((item) => {
      if (item.id_tareas === id) {
        onDelete(item.id);
      }
    });

    fetch(HOST_API + "/todoList/" + id, {
      method: "DELETE",
    }).then((list) => {
      dispatch({ type: "delete-list", id });
    });
  };

  const decorationDone = {
    textDecoration: "line-through",
  };

  return (
    <Fragment>
      <table cellSpacing="0">
        <tbody>
          {currentList.map((list) => {
            return (
              <Fragment key={list.id}>
                <div className="listDiv">
                  <tr>
                    <td id="TitleText">{list.name}</td>
                    <td>
                      <button
                      className="eliminar"
                        onClick={() => onDeleteList(list.id)}
                      >
                        Eliminar
                      </button>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <FormTodoTask id_tareas={list.id} />
                    </td>
                  </tr>

                  <tr>
                    <td className="td">Id</td>
                    <td className="td">Tarea</td>
                    <td className="td">¿Completa?</td>
                  </tr>
                  {currentTodos.map((todo) => {
                    if (todo.id_tareas === list.id) {
                      return (
                        <tr
                          key={todo.id}
                          style={todo.completed ? decorationDone : {}}
                        >
                          <td>{todo.id}</td>
                          <td>{todo.name}</td>
                          <td>
                            <input
                              type="checkbox"
                              defaultChecked={todo.completed}
                              onChange={(event) =>
                                onChange(event, todo, list.id)
                              }
                            ></input>
                          </td>
                          <td>
                            <button
                              className="eliminar"
                              onClick={() => onDeleteTask(todo.id)}
                            >
                              Eliminar
                            </button>
                          </td>
                          <td>
                            <button
                              onClick={() => onEdit(todo)}
                              className="editar"
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
    </Fragment>
  );
};

export default List;
