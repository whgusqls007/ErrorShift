import { Sidebar, Menu, MenuItem } from "react-pro-sidebar";
import { Link } from "react-router-dom";
import home from "../../assets/img/home.png";
import arrow from "../../assets/img/arrow.png";

const arr = [
  "ArithmeticException",
  "ArrayIndexOutOfBoundsException",
  "ClassCastException",
  "HttpMediaTypeNotSupportedException",
  "HttpRequestMethodNotSupportedException",
  "IllegalArgumentException",
  "IndexOutOfBoundsException",
  "MethodArgumentNotValidException",
  "NoHandlerFoundException",
  "NullPointerException",
  "NumberFormatException",
  "TypeMismatchException",
];

function SideBar() {
  return (
    <div>
      <Sidebar style={{ marginTop: 80 }}>
        <Menu>
          <MenuItem routerLink={<Link to="/errortype" />}>
            <img
              src={home}
              alt="home"
              style={{ width: 16, height: 16, paddingBottom: 2 }}
            ></img>{" "}
            Home{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/annotation" />}>
            <img src={arrow} alt="home" style={{ width: 12, height: 12 }}></img>{" "}
            ErrorShift{" "}
          </MenuItem>
          {arr.map((e, i) => {
            return (
              <MenuItem key={i} routerLink={<Link to={"/errortype/" + e} />}>
                <img
                  src={arrow}
                  alt="home"
                  style={{ width: 12, height: 12 }}
                ></img>{" "}
                {e}
              </MenuItem>
            );
          })}
        </Menu>
      </Sidebar>
    </div>
  );
}
export default SideBar;
