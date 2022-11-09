import NavBar from "../../../common/navbar/NavBar";
import Footer from "../../../common/footer/Footer";
import SideBar from "../../../common/sidebar/SideBar";

import "./ErrorType.css";

function ErrorType() {
  return (
    <div>
      <NavBar></NavBar>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div className="content">
          <h1>시작하기</h1>
          <p>ErrorShift는 빠르게 원하는 에러를 핸들링 할 수 있습니다.</p>
          <a href="http://localhost:3001/download" download>
            aa
          </a>
        </div>
      </div>
      <Footer></Footer>
    </div>
  );
}
export default ErrorType;
