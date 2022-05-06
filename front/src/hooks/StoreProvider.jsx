import React, { useReducer } from "react";
import { Store, initialState } from "./InitialState";
import { reducer } from "./reducer";

export const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  return (
    <Store.Provider value={{ state, dispatch }}>{children}</Store.Provider>
  );
};
