import { useContext, useState, useRef, Fragment } from "react";
import { HOST_API } from "../conexiones/HOST_API";
import { Store } from "../hooks/Store";

export const FormLista = () => {
  const formRef = useRef(null);
  const {
    dispatch,
    state: { listas },
  } = useContext(Store);
  const item = listas.item;
  const [state, setState] = useState(item);
  const [isDisabled, setIsDisabled] = useState(true);
  const [hasWritten, sethasWritten] = useState(false);

  const onAdd = (event) => {
    event.preventDefault();
    setIsDisabled(true);
    sethasWritten(false);
    const request = {
      name: state.name,
      id: null,
    };

    fetch(HOST_API + "todo", {
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
      <form ref={formRef}>
        <h3 id="Listas">Listas</h3>
        <input
          type="text"
          name="name"
          placeholder="Nombre de tu lista"
          defaultValue={item.name}
          id="listForms"
          onChange={(event) => {
            sethasWritten(true);
            setIsDisabled(event.target.value.length > 0 ? false : true);
            setState({ ...state, name: event.target.value });
          }}
        ></input>
        {!item.id && (
          <button
            disabled={isDisabled}
            className="Ccear-boton"
            onClick={onAdd}
          >
            Crear
          </button>
        )}

        {isDisabled && hasWritten && (
          <p className="MinimunLength">Este campo es obligatorio</p>          
        )}
        {/* required; */}
      </form>
    </Fragment>
  );
};

export default FormLista;
