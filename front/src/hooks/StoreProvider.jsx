import React, { useReducer } from "react";
import { Store, initialState } from "./Store";
import { Reducer } from "./Reducer";

/*
- Suministra todo el contexto de la aplicación a todos los elementos del mismo
*/

export const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(Reducer, initialState);

  return (
    <Store.Provider value={{ state, dispatch }}>{children}</Store.Provider>
  );
};
