import { useContext, useEffect, Fragment } from "react";
import { Store } from "../hooks/Store";
import { HOST_API } from "../conexiones/HOST_API";
import FormTodoTask from "../componentes/FormTodoTask";
import { RiDeleteBin2Line } from "react-icons/ri";
import { FiEdit } from "react-icons/fi";
import { RiChatDeleteLine } from "react-icons/ri";

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
      <table className="w3-table">
        <tbody>
          {currentList.map((list) => {
            return (
              <Fragment key={list.id}>
                <div className="listDiv">
                  <tr>
                    <td  id="TitleText">
                      <h3>Proyecto: {list.name}</h3>
                    </td>
                    <td>
                      <button
                        // className="custom-btn btn-7"
                        onClick={() => onDeleteList(list.id)}
                      >
                        {/* Eliminar */}
                      <RiChatDeleteLine className="icono" border="0" />
                      </button>
                    </td>
                  </tr>
                  <tr>
                    <div>
                      <td>
                        <FormTodoTask id_tareas={list.id} />
                      </td>
                    </div>
                  </tr>

                  <tr>
                    {/* <td className="td">Id</td> */}
                    <th className="td-text">Tareas Programadas</th>
                    <th className="td-text">¿Completa?</th>
                    <th id="text-center" className="td-text"></th>
                  </tr>
                  {currentTodos.map((todo) => {
                    if (todo.id_tareas === list.id) {
                      return (
                        <tr
                          key={todo.id}
                          style={todo.completed ? decorationDone : {}}
                        >
                          {/* <td >{todo.id}</td> */}
                          <td>{todo.name}</td>
                          <td className="text-center">
                            <input
                              type="checkbox"
                              defaultChecked={todo.completed}
                              onChange={(event) =>
                                onChange(event, todo, list.id)
                              }
                            ></input>
                          </td>
                          {!todo.completed && (
                            <td className="text-center">
                              <button
                                onClick={() => onEdit(todo)}
                                className="icono-edit"
                              >
                                {/* Editar */}
                                <FiEdit className="icono" />
                              </button>
                            </td>
                          )}
                          <td>
                            <button
                              className="icono-delete"
                              onClick={() => onDeleteTask(todo.id)}
                            >
                              {/* Eliminar*/}
                              <RiDeleteBin2Line className="icono" />
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
