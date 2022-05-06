import React, { useContext, useRef, useState } from "react";
import { HOST_API } from "../conexiones/HOST_API";
import { Store } from "../hooks/Store";

export const Form = ({ idTareas }) => {
  const formRef = useRef(null);
  const {
    dispatch,
    state: { todo },
  } = useContext(Store);
  const item = todo.item;
  const [state, setState] = useState(item);
  const [estaDesactivado, setEstaDesactivado] = useState(true);
  const [haEscrito, setHasEscrito] = useState(false);

  const onAdd = (event) => {
    event.preventDefault();
    setEstaDesactivado(true);
    setHasEscrito(false);

    const request = {
      name: state.name,
      id: null,
      completado: false,
      idTareas: idTareas,
    };

    fetch(HOST_API + "api/todo/tarea", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((todo) => {
        dispatch({ type: "add-item", item: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  const onEdit = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: item.id,
      isCompletado: item.isCompleted,
      idTareas: idTareas,
    };

    fetch(HOST_API + "api/todo/tarea", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((todo) => {
        dispatch({ type: "update-item", item: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  return (
    <div>
      <form ref={formRef}>
        <input
          type="text"
          name="name"
          placeholder="¿Qué piensas hacer hoy?"
          defaultValue={item.idTareas === idTareas ? item.name : ""}
          onChange={(event) => {
            setState({ ...state, name: event.target.value });
            setHasEscrito(true);
            setEstaDesactivado(event.target.value.length > 0 ? false : true);
          }}
        />
        {item.id && item.idTareas === idTareas && (
          <button className="updateButton" onClick={onEdit}>
            Actualizar
          </button>
        )}
        {!item.id && (
          <button
            dissbled={estaDesactivado}
            className="CrearBoton"
            onClick={onAdd}
          >
            Crear
          </button>
        )}
      </form>
      {estaDesactivado && haEscrito && (
        <span className="campo-obligatorio">Este campo es obligatorio</span>
      )}
    </div>
  );
};
export default Form;
