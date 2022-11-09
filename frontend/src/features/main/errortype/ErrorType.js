import Footer from "../../../common/footer/Footer";
import SideBar from "../../../common/sidebar/SideBar";

import "./ErrorType.css";

function ErrorType() {
  return (
    <div>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div className="content"></div>
      </div>
      <Footer></Footer>
    </div>
  );
}
export default ErrorType;
