import Footer from "../../common/footer/Footer";
import SideBar from "../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import "./ErrorPage.css";
import img from "../../assets/img/img1.jpg";


function Arithmetic() {
  const code = `
  @TestAnnotation(exception = ArithmeticException.class, logging = true, httpStatus = HttpStatus.NOT_FOUND, trace = true)
  @ControllerAdvice
  public class GlobalExceptionHandler {
  }
  `;

  return (
    <div>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div className="content">
          <Code codeString={code} language="java" />
        </div>
      </div>
      <div className="content">
          <Code codeString={code} language="java" />
        </div>
        <div className="content">
          <Code codeString={code} language="java" />
        </div>
        <div className="content">
          <Code codeString={code} language="java" />
        </div>
        <div className="content">
          <Code codeString={code} language="java" />
        </div>
    </div>
  );
}
export default Arithmetic;
