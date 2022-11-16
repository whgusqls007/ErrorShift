import { Sidebar, Menu, MenuItem, SubMenu } from "react-pro-sidebar";
import { Link } from "react-router-dom";
import home from "../../assets/img/home.png";
import { useSelector, useDispatch } from "react-redux";
import { changeState } from "../../store";

const arr = [
  "ArithmeticException",
  "ArrayIndexOutOfBoundsException",
  "ClassCastException",
  "HttpMediaTypeNotSupportedException",
  "HttpRequestMethodNotSupportedException",
  "IllegalArgumentException",
  "IndexOutOfBoundsException",
  // "MethodArgumentNotValidException",
  "NoHandlerFoundException",
  "NullPointerException",
  "NumberFormatException",
  "TypeMismatchException",
];

function SideBar() {
  const state = useSelector((state) => {
    return state.state;
  });
  const dispatch = useDispatch();
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
          <Menu
            renderExpandIcon={({ open }) => <span>{open ? "-" : "+"}</span>}
            onClick={() => dispatch(changeState())}
          >
            <SubMenu label="Exception" open={state.state}>
              {arr.map((e, i) => {
                return (
                  <MenuItem
                    key={i}
                    routerLink={<Link to={"/errortype/" + e} />}
                  >
                    {e}
                  </MenuItem>
                );
              })}
            </SubMenu>
          </Menu>
        </Menu>
      </Sidebar>
    </div>
  );
}
export default SideBar;
