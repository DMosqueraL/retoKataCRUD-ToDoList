import React from "react";
import { FormTodoList } from "./componentes/FormTodoList";
import { List } from "./componentes/List";
import { StoreProvider } from "./hooks/StoreProvider";

function App() {
  return (
    <StoreProvider>
      <div>
      <h3>To-Do List Doris</h3>
      <FormTodoList />
      </div>
      <div>
      <List />
      </div>
    </StoreProvider>
  );
}

export default App;
