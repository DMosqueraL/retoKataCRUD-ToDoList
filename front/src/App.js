import React from "react";
import { FormLista } from "./componentes/FormLista.jsx";
import { List } from "./componentes/List";
import { StoreProvider } from "./hooks/StoreProvider";

function App() {
  return (
    <StoreProvider>
      <h3>To-Do List Doris</h3>
      <FormLista />
      <List />
    </StoreProvider>
  );
}

export default App;
