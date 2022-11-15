import { Sidebar, Menu, MenuItem, SubMenu, useProSidebar } from "react-pro-sidebar";
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
            ErrorShift{" "}
          </MenuItem>

          <SubMenu defaultOpen label="Exception">
            <MenuItem
              routerLink={<Link to="/errortype/MethodArgumentNotValid" />}
            >
              MethodArgumentNotValid{" "}
            </MenuItem>
            <MenuItem routerLink={<Link to="/errortype/TypeMismatch" />}>
              TypeMismatch{" "}
            </MenuItem>
            <MenuItem routerLink={<Link to="/errortype/NoHandlerFound" />}>
              NoHandlerFound{" "}
            </MenuItem>
            <MenuItem
              routerLink={<Link to="/errortype/HttpRequestMethodNotSupported" />}
            >
              HttpRequestMethodNotSupported{" "}
            </MenuItem>
            <MenuItem
              routerLink={<Link to="/errortype/HttpMediaTypeNotSupported" />}
            >
              HttpMediaTypeNotSupported{" "}
            </MenuItem>
            <MenuItem routerLink={<Link to="/errortype/NullPointer" />}>
              NullPointer{" "}
            </MenuItem>
            <MenuItem routerLink={<Link to="/errortype/Arithmetic" />}>
              Arithmetic{" "}
            </MenuItem>
            <MenuItem routerLink={<Link to="/errortype/ArrayIndexOutOfBounds" />}>
              ArrayIndexOutOfBounds{" "}
            </MenuItem>
            <MenuItem routerLink={<Link to="/errortype/IndexOutOfBounds" />}>
              IndexOutOfBounds{" "}
            </MenuItem>
            <MenuItem routerLink={<Link to="/errortype/IllegalArgument" />}>
              IllegalArgument{" "}
            </MenuItem>

          </SubMenu>



          
        </Menu>
      </Sidebar>
    </div>
  );
}
export default SideBar;
