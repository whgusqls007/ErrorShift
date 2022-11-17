import { configureStore, createSlice } from "@reduxjs/toolkit";

const initialState = {
  state: false,
  home: true,
  errorShift: false,
  openIndex: -1,
  exceptions: false,
  contribute: false,
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
      state.home = false;
      state.errorShift = false;
      state.exceptions = false;
      state.contribute = false;
    },

    setIsHome(state) {
      state.home = true;
      state.state = false;
      state.errorShift = false;
      state.openIndex = -1;
      state.exceptions = false;
      state.contribute = false;
    },

    setIsErrorShift(state) {
      state.home = false;
      state.state = false;
      state.errorShift = true;
      state.openIndex = -1;
      state.exceptions = false;
      state.contribute = false;
    },

    setOpenIndex(state, payload) {
      state.home = false;
      state.state = false;
      state.errorShift = false;
      state.openIndex = payload.payload;
      state.exceptions = false;
      state.contribute = false;
    },

    setIsExceptions(state) {
      state.home = false;
      state.state = false;
      state.errorShift = false;
      state.openIndex = -1;
      state.exceptions = true;
      state.contribute = false;
    },

    setIsContribute(state) {
      state.home = false;
      state.state = false;
      state.errorShift = false;
      state.openIndex = -1;
      state.exceptions = false;
      state.contribute = true;
    },
  },
});

export let {
  changeState,
  setIsHome,
  setIsErrorShift,
  setOpenIndex,
  setIsExceptions,
  setIsContribute,
} = state.actions;

export default configureStore({
  reducer: {
    state: state.reducer,
  },
});
