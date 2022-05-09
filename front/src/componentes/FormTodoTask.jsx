import { useContext, useRef, useState } from "react";
import { HOST_API } from "../conexiones/HOST_API";
import { Store } from "../hooks/Store";

/*
- Acciones o funciones de la entidad TodoTask (La que se identica en la interfaz
  como tareas)
*/

export const FormTodoTask = ({ id_tareas }) => {
  const formRef = useRef(null);
  const {
    dispatch,
    state: { todoTask },
  } = useContext(Store);
  const item = todoTask.item;
  const [state, setState] = useState(item);
  const [isDisabled, setIsDisabled] = useState(true);
  const [hasWritten, setHasWritten] = useState(false);

  const onAdd = (event) => {
    event.preventDefault();
    setIsDisabled(true);
    setHasWritten(false);

    const request = {
      name: state.name,
      id: null,
      completed: false,
      id_tareas: id_tareas,
    };

    fetch(HOST_API + "/todoTask", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((todoTask) => {
        dispatch({ type: "add-item", item: todoTask });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  const onEdit = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: item.id,
      isCompleted: item.isCompleted,
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
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  return (
    <div>
      <form ref={formRef}>
        <div class="w3-table">
          <span className="contenedor-boton">
          <input
            id="nombre-tabla"
            className="w3-input w3-animate-input"
            // style="width:30%"
            // className="form-control"
            type="text"
            name="name"
            placeholder="Tarea Nueva"
            required="required"
            defaultValue={item.id_tareas === id_tareas ? item.name : ""}
            onChange={(event) => {
              setHasWritten(true);
              setIsDisabled(event.target.value.length ? false : true);
              setState({ ...state, name: event.target.value });
            }}
          />
          </span>
          {item.id && item.id_tareas === id_tareas && (
            <span className="contenedor-boton">
              <button className="custom-btn btn-7" onClick={onEdit}>
                Actualizar
              </button>
            </span>
          )}
        </div>
        <span className="contenedor-boton">
          {!item.id && (
            <button
              dissbled={isDisabled}
              className="custom-btn btn-7 "
              onClick={onAdd}
            >
              Agregar
            </button>
          )}
        </span>
      </form>
      {isDisabled && hasWritten && (
        <span className="campo-obligatorio">Este campo es obligatorio</span>
      )}
    </div>
  );
};
export default FormTodoTask;
