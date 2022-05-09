import React from "react";
import { FormTodoList } from "./componentes/FormTodoList";
import { List } from "./componentes/List";
import { StoreProvider } from "./hooks/StoreProvider";
import "../src/estilosCSS/App.css";


function App() {
  return (
    <StoreProvider>
        <h1 className="w3-animate-left font-effect-shadow-multiple">Reto Final - ToDo List</h1>
        <FormTodoList />
        <List id="Listas-app"/>
    </StoreProvider>   
  );
}

export default App;
