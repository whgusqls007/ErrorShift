import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import logo from "../../assets/img/logo.png";
import { NavLink } from "react-router-dom";
import { Link } from "react-router-dom";

import "./NavBar.css";

function NavBar() {
  return (
    <div>
      <Navbar className="navbar-box" bg="light" variant="light" fixed="top">
        <Container>
          <div>
            <NavLink to="/">
              <img
                style={{ marginBottom: 10 }}
                alt="logo"
                src={logo}
                href="/"
              />
            </NavLink>
            <Navbar.Brand
              className="item-name"
              href="/"
              style={{ fontSize: 28, marginLeft: 8 }}
            >
              ErrorShift
            </Navbar.Brand>
          </div>
          <Nav className="gnb-menu">
            <Link
              className="nav-link link"
              to={"/adv"}
              style={{ marginRight: "3rem" }}
            >
              홍보 및 시연
            </Link>
            <Link
              className="nav-link link"
              to={"/errortype"}
              style={{ marginRight: "3rem" }}
            >
              문서
            </Link>
            <Link
              className="nav-link link"
              to={"#github"}
              style={{ marginRight: "3rem" }}
            >
              깃허브
            </Link>
          </Nav>
        </Container>
      </Navbar>
    </div>
  );
}
export default NavBar;
