import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import "./App.css";
import Main from "../features/main/home/Home";
import Adv from "../features/main/adv/Adv";
import ErrorType from "../features/main/errortype/ErrorType";

import MethodArgumentNotValid from "../features/errorpage/MethodArgumentNotValid";
import TypeMismatch from "../features/errorpage/TypeMismatch";
import NoHandlerFound from "../features/errorpage/NoHandlerFound";
import HttpRequestMethodNotSupported from "../features/errorpage/HttpRequestMethodNotSupported";
import HttpMediaTypeNotSupported from "../features/errorpage/HttpMediaTypeNotSupported";
import NullPointer from "../features/errorpage/NullPointer";
import Arithmetic from "../features/errorpage/Arithmetic";
import ArrayIndexOutOfBounds from "../features/errorpage/ArrayIndexOutOfBounds";
import IndexOutOfBounds from "../features/errorpage/IndexOutOfBounds";
import IllegalArgument from "../features/errorpage/IllegalArgument";
import NavBar from "../common/navbar/NavBar";

function App() {
  return (
    <Router>
      <NavBar></NavBar>
      <Routes style={{ marginTop: "80px" }}>
        <Route exact path="/" element={<Main />} />
        <Route exact path="/adv" element={<Adv />} />
        <Route exact path="/errortype" element={<ErrorType />} />

        <Route
          exact
          path="/errortype/MethodArgumentNotValid"
          element={<MethodArgumentNotValid />}
        />
        <Route
          exact
          path="/errortype/TypeMismatch"
          element={<TypeMismatch />}
        />
        <Route
          exact
          path="/errortype/NoHandlerFound"
          element={<NoHandlerFound />}
        />
        <Route
          exact
          path="/errortype/HttpRequestMethodNotSupported"
          element={<HttpRequestMethodNotSupported />}
        />
        <Route
          exact
          path="/errortype/HttpMediaTypeNotSupported"
          element={<HttpMediaTypeNotSupported />}
        />
        <Route exact path="/errortype/NullPointer" element={<NullPointer />} />
        <Route exact path="/errortype/Arithmetic" element={<Arithmetic />} />
        <Route
          exact
          path="/errortype/ArrayIndexOutOfBounds"
          element={<ArrayIndexOutOfBounds />}
        />
        <Route
          exact
          path="/errortype/IndexOutOfBounds"
          element={<IndexOutOfBounds />}
        />
        <Route
          exact
          path="/errortype/IllegalArgument"
          element={<IllegalArgument />}
        />
      </Routes>
    </Router>
  );
}
export default App;
