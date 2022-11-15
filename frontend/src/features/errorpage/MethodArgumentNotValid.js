import SideBar from "../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import "./ErrorPage.css";
function MethodArgumentNotValid() {
  return (
    <div>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div style={{ height: 500, marginTop: 80 }}>
          <h1>MethodArgumentNotValid</h1>
        </div>
      </div>
    </div>
  );
}
export default MethodArgumentNotValid;
