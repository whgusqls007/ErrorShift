import { Sidebar, Menu, MenuItem } from "react-pro-sidebar";
import { Link } from "react-router-dom";
import home from "../../assets/img/home.png";
import arrow from "../../assets/img/arrow.png";

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
          <MenuItem
            routerLink={<Link to="/errortype/MethodArgumentNotValid" />}
          >
            <img src={arrow} alt="home" style={{ width: 12, height: 12 }}></img>{" "}
            MethodArgumentNotValid{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/TypeMismatch" />}>
            <img src={arrow} alt="home" style={{ width: 12, height: 12 }}></img>{" "}
            TypeMismatch{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/NoHandlerFound" />}>
            <img src={arrow} alt="home" style={{ width: 12, height: 12 }}></img>{" "}
            NoHandlerFound{" "}
          </MenuItem>
          <MenuItem
            routerLink={<Link to="/errortype/HttpRequestMethodNotSupported" />}
          >
            <img src={arrow} alt="home" style={{ width: 12, height: 12 }}></img>{" "}
            HttpRequestMethodNotSupported{" "}
          </MenuItem>
          <MenuItem
            routerLink={<Link to="/errortype/HttpMediaTypeNotSupported" />}
          >
            <img src={arrow} alt="home" style={{ width: 12, height: 12 }}></img>{" "}
            HttpMediaTypeNotSupported{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/NullPointer" />}>
            <img src={arrow} alt="home" style={{ width: 12, height: 12 }}></img>{" "}
            NullPointer{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/Arithmetic" />}>
            <img src={arrow} alt="home" style={{ width: 12, height: 12 }}></img>{" "}
            Arithmetic{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/ArrayIndexOutOfBounds" />}>
            <img src={arrow} alt="home" style={{ width: 12, height: 12 }}></img>{" "}
            ArrayIndexOutOfBounds{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/IndexOutOfBounds" />}>
            <img src={arrow} alt="home" style={{ width: 12, height: 12 }}></img>{" "}
            IndexOutOfBounds{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/IllegalArgument" />}>
            <img src={arrow} alt="home" style={{ width: 12, height: 12 }}></img>{" "}
            IllegalArgument{" "}
          </MenuItem>
        </Menu>
      </Sidebar>
    </div>
  );
}
export default SideBar;
