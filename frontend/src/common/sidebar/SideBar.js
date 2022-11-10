import { Sidebar, Menu, MenuItem } from "react-pro-sidebar";
import { Link } from "react-router-dom";
import home from "../../assets/img/home.png"
import error from "../../assets/img/error.png"

function SideBar() {
  return (
    <div>
      <Sidebar style={{ marginTop: 80 }}>
        <Menu>
          <MenuItem
            routerLink={<Link to="/errortype" />}
          >
            <img src={home} alt="home" style={{width: 16, height: 15}}></img>
            {" "}
            Home{" "}
          </MenuItem>
          <MenuItem
            routerLink={<Link to="/errortype/MethodArgumentNotValid" />}
          >
            <img src={error} alt="home" style={{width: 16, height: 16}}></img>
            {" "}
            MethodArgumentNotValid{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/TypeMismatch" />}>
          <img src={error} alt="home" style={{width: 16, height: 16}}></img>
            {" "}
            TypeMismatch{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/NoHandlerFound" />}>
            <img src={error} alt="home" style={{width: 16, height: 16}}></img>
            {" "}
            NoHandlerFound{" "}
          </MenuItem>
          <MenuItem
            routerLink={<Link to="/errortype/HttpRequestMethodNotSupported" />}
          >
            <img src={error} alt="home" style={{width: 16, height: 16}}></img>
            {" "}
            HttpRequestMethodNotSupported{" "}
          </MenuItem>
          <MenuItem
            routerLink={<Link to="/errortype/HttpMediaTypeNotSupported" />}
          >
            <img src={error} alt="home" style={{width: 16, height: 16}}></img>
            {" "}
            HttpMediaTypeNotSupported{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/NullPointer" />}>
          <img src={error} alt="home" style={{width: 16, height: 16}}></img>
            {" "}
            NullPointer{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/Arithmetic" />}>
          <img src={error} alt="home" style={{width: 16, height: 16}}></img>
            {" "}
            Arithmetic{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/ArrayIndexOutOfBounds" />}>
          <img src={error} alt="home" style={{width: 16, height: 16}}></img>
            {" "}
            ArrayIndexOutOfBounds{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/IndexOutOfBounds" />}>
          <img src={error} alt="home" style={{width: 16, height: 16}}></img>
            {" "}
            IndexOutOfBounds{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/IllegalArgument" />}>
          <img src={error} alt="home" style={{width: 16, height: 16}}></img>
            {" "}
            IllegalArgument{" "}
          </MenuItem>
        </Menu>
      </Sidebar>
    </div>
  );
}
export default SideBar;
