import { createContext } from "react";

export const initialState = {
  todoTask: { list: [], item: {} },
  todoList: { list: [], item: {}}
};
export const Store = createContext(initialState);
