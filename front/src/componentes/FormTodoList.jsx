import { useContext, useState, useRef, Fragment } from "react";
import { HOST_API } from "../conexiones/HOST_API";
import { Store } from "../hooks/Store";


export const FormTodoList = () => {
  const formRef = useRef(null);
  const {
    dispatch,
    state: { todoList },
  } = useContext(Store);
  
  const item = todoList.item;
  const [state, setState] = useState(item);
  const [isDisabled, setIsDisabled] = useState(true);
  const [hasWritten, sethasWritten] = useState(false);

  const onAdd = (event) => {
    event.preventDefault();
    setIsDisabled(true);
    sethasWritten(false);
    const request = {
      id: null,
      name: state.name,      
    };

    fetch(HOST_API + "/todoList", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((list) => {
        dispatch({ type: "add-list", item: list });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  return (
    <Fragment>
      <form className="form1" ref={formRef}>
        <h6 id="">¡Qué esperas para enlistar tus PROYECTOS!</h6>
        <input
          className="w3-input"
          // className="form-control"
          type="text"
          name="name"
          placeholder="Nombre del proyecto"          
          defaultValue={item.name}
          required
          id="listForms"
          onChange={(event) => {
            sethasWritten(true);
            setIsDisabled(event.target.value.length ? false : true);
            setState({ ...state, name: event.target.value });
          }}
        ></input>
        {!item.id && (
          <button
            disabled={isDisabled}
            className="custom-btn btn-7"
            onClick={onAdd}
          >
            Crear
          </button>
        )}

        {isDisabled && hasWritten && (
          <p className="desactivado">Este campo es obligatorio</p>          
        )}
        {/* required; */}
      </form>
    </Fragment>
  );
};


export default FormTodoList;
