import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import logo from "../../assets/img/logo.png";
import { NavLink } from "react-router-dom";

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
            <Nav.Link
              className="nav-link"
              href="/adv"
              style={{ marginRight: "3rem" }}
            >
              홍보 및 시연
            </Nav.Link>
            <Nav.Link
              className="nav-link"
              href="/errortype"
              style={{ marginRight: "3rem" }}
            >
              문서
            </Nav.Link>
            <Nav.Link className="nav-link" href="#pricing">
              깃허브
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </div>
  );
}
export default NavBar;
