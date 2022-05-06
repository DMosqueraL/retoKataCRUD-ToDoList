import React from "react";
import { Form } from "./componentes/Form";
import { List } from "./List";
import { StoreProvider } from "./hooks/StoreProvider";

export const HOST_API = "http://localhost:8080/api";

function App() {
  return (
    <StoreProvider>
      <h3>To-Do List</h3>
      <Form />
      <List />
    </StoreProvider>
  );
}

export default App;
