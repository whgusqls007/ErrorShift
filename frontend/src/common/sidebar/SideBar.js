import { Sidebar, Menu, MenuItem, SubMenu } from "react-pro-sidebar";
import { Link } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import {
  changeState,
  setIsHome,
  setIsErrorShift,
  setOpenIndex,
  setIsExceptions,
  setIsContribute,
} from "../../store";
import { AiOutlineHome, AiTwotoneHome } from "react-icons/ai";

import {
  BsCaretRightFill,
  BsCaretRight,
  BsFillCaretDownFill,
} from "react-icons/bs";

const arr = [
  "ArithmeticException",
  "ArrayIndexOutOfBoundsException",
  "ClassCastException",
  "HttpMediaTypeNotSupportedException",
  "HttpRequestMethodNotSupportedException",
  "IllegalArgumentException",
  "IndexOutOfBoundsException",
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
          <MenuItem
            routerLink={<Link to="/errortype" />}
            onClick={() => dispatch(setIsHome())}
          >
            {state.home ? <AiTwotoneHome /> : <AiOutlineHome />}
            &nbsp; Home{" "}
          </MenuItem>

          <MenuItem
            routerLink={<Link to="/errortype/annotation" />}
            onClick={() => dispatch(setIsErrorShift())}
          >
            {state.errorShift ? <BsCaretRightFill /> : <BsCaretRight />}
            &nbsp;ErrorShift{" "}
          </MenuItem>
          <Menu
            renderExpandIcon={({ open }) => (
              <span>{open ? <strong>-</strong> : <strong>+</strong>}</span>
            )}
            onClick={() => {
              dispatch(changeState());
            }}
          >
            <SubMenu
              label={
                state.state ? (
                  <>
                    <BsFillCaretDownFill />
                    &nbsp;Exceptions
                  </>
                ) : (
                  <>
                    <BsCaretRight />
                    &nbsp;Exceptions
                  </>
                )
              }
              open={state.state}
            >
              {arr.map((e, i) => {
                return (
                  <MenuItem
                    key={i}
                    routerLink={<Link to={"/errortype/" + e} />}
                    onClick={() => dispatch(setOpenIndex(i))}
                  >
                    {i === state.openIndex ? (
                      <BsCaretRightFill />
                    ) : (
                      <BsCaretRight />
                    )}
                    &nbsp;{e}
                  </MenuItem>
                );
              })}
            </SubMenu>
          </Menu>
          <MenuItem
            routerLink={<Link to="/errortype/MultipleExceptions" />}
            onClick={() => dispatch(setIsExceptions())}
          >
            {state.exceptions ? <BsCaretRightFill /> : <BsCaretRight />}
            &nbsp;MultipleExceptions{" "}
          </MenuItem>
          <MenuItem
            routerLink={<Link to="/errortype/contribute" />}
            onClick={() => dispatch(setIsContribute())}
          >
            {state.contribute ? <BsCaretRightFill /> : <BsCaretRight />}
            &nbsp;Contribute Guide{" "}
          </MenuItem>
        </Menu>
      </Sidebar>
    </div>
  );
}
export default SideBar;
