import { configureStore, createSlice } from "@reduxjs/toolkit";

const initialState = {
  state: true,
};

let state = createSlice({
  name: "isOpen", // state 이름
  initialState: initialState, // state 값
  reducers: {
    changeState(state) {
      if (state.state === true) {
        state.state = false;
      } else {
        state.state = true;
      }
    },
  },
});

export let { changeState } = state.actions;

export default configureStore({
  reducer: {
    state: state.reducer,
  },
});
