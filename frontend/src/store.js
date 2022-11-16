import { configureStore, createSlice } from "@reduxjs/toolkit";

const initialState = {
  state: true,
  home: true,
  errorShift: false,
  openIndex: -1,
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

    setIsHome(state) {
      state.home = true;
      state.errorShift = false;
      state.openIndex = -1;
    },

    setIsErrorShift(state) {
      state.home = false;
      state.errorShift = true;
      state.openIndex = -1;
    },

    setOpenIndex(state, payload) {
      state.home = false;
      state.errorShift = false;
      state.openIndex = payload.payload;
    },
  },
});

export let { changeState, setIsHome, setIsErrorShift, setOpenIndex } =
  state.actions;

export default configureStore({
  reducer: {
    state: state.reducer,
  },
});
