import React from "react";
import { Form } from "./componentes/Form";
import { List } from "./componentes/List";
import { StoreProvider } from "./hooks/StoreProvider";

export const HOST_API = "http://localhost:8080/api";

function App() {
  return (
    <StoreProvider>
      <h3>To-Do List Doris</h3>
      <Form />
      <List />
    </StoreProvider>
  );
}

export default App;
