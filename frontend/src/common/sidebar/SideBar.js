import { Sidebar, Menu, MenuItem } from "react-pro-sidebar";
import { Link } from "react-router-dom";

function SideBar() {
  return (
    <div>
      <Sidebar style={{ marginTop: 80 }}>
        <Menu>
          <MenuItem
            routerLink={<Link to="/errortype" />}
          >
            {" "}
            Home{" "}
          </MenuItem>
          <MenuItem
            routerLink={<Link to="/errortype/MethodArgumentNotValid" />}
          >
            {" "}
            MethodArgumentNotValid{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/TypeMismatch" />}>
            {" "}
            TypeMismatch{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/NoHandlerFound" />}>
            {" "}
            NoHandlerFound{" "}
          </MenuItem>
          <MenuItem
            routerLink={<Link to="/errortype/HttpRequestMethodNotSupported" />}
          >
            {" "}
            HttpRequestMethodNotSupported{" "}
          </MenuItem>
          <MenuItem
            routerLink={<Link to="/errortype/HttpMediaTypeNotSupported" />}
          >
            {" "}
            HttpMediaTypeNotSupported{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/NullPointer" />}>
            {" "}
            NullPointer{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/Arithmetic" />}>
            {" "}
            Arithmetic{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/ArrayIndexOutOfBounds" />}>
            {" "}
            ArrayIndexOutOfBounds{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/IndexOutOfBounds" />}>
            {" "}
            IndexOutOfBounds{" "}
          </MenuItem>
          <MenuItem routerLink={<Link to="/errortype/IllegalArgument" />}>
            {" "}
            IllegalArgument{" "}
          </MenuItem>
        </Menu>
      </Sidebar>
    </div>
  );
}
export default SideBar;
