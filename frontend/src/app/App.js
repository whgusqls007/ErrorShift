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
import ClassCast from "../features/errorpage/ClassCast";
import NavBar from "../common/navbar/NavBar";
import Footer from "../common/footer/Footer";
import ErrorShift from "../features/main/errortype/ErrorShift";
import NumberFormat from "../features/errorpage/NumberFormat";

function App() {
  return (
    <Router>
      <NavBar></NavBar>
      <Routes style={{ marginTop: "80px" }}>
        <Route exact path="/" element={<Main />} />
        <Route exact path="/adv" element={<Adv />} />
        <Route exact path="/errortype" element={<ErrorType />} />
        <Route exact path="/errortype/annotation" element={<ErrorShift />} />
        <Route
          exact
          path="/errortype/MethodArgumentNotValidException"
          element={<MethodArgumentNotValid />}
        />
        <Route
          exact
          path="/errortype/TypeMismatchException"
          element={<TypeMismatch />}
        />
        <Route
          exact
          path="/errortype/NoHandlerFoundException"
          element={<NoHandlerFound />}
        />
        <Route
          exact
          path="/errortype/HttpRequestMethodNotSupportedException"
          element={<HttpRequestMethodNotSupported />}
        />
        <Route
          exact
          path="/errortype/HttpMediaTypeNotSupportedException"
          element={<HttpMediaTypeNotSupported />}
        />
        <Route
          exact
          path="/errortype/NullPointerException"
          element={<NullPointer />}
        />
        <Route
          exact
          path="/errortype/ArithmeticException"
          element={<Arithmetic />}
        />
        <Route
          exact
          path="/errortype/ArrayIndexOutOfBoundsException"
          element={<ArrayIndexOutOfBounds />}
        />
        <Route
          exact
          path="/errortype/IndexOutOfBoundsException"
          element={<IndexOutOfBounds />}
        />
        <Route
          exact
          path="/errortype/IllegalArgumentException"
          element={<IllegalArgument />}
        />
        <Route
          exact
          path="/errortype/ClassCastException"
          element={<ClassCast />}
        />
        <Route
          exact
          path="/errortype/NumberFormatException"
          element={<NumberFormat />}
        />
      </Routes>
      <Footer></Footer>
    </Router>
  );
}
export default App;
