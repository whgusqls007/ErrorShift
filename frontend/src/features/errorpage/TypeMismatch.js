import Footer from "../../common/footer/Footer";
import SideBar from "../../common/sidebar/SideBar";

function TypeMismatch() {
  return (
    <div>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div style={{ height: 500, marginTop: 80 }}>
          <h1>TypeMismatch</h1>
        </div>
      </div>
      <Footer></Footer>
    </div>
  );
}
export default TypeMismatch;
