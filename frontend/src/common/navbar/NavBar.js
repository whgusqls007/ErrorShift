import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

import "./NavBar.css"

function NavBar(){
    return(
        <div>
            <Navbar className="navbar-box" bg="light" variant="light" fixed="top">
                <Container>
                <Navbar.Brand className="item-name" href="/" style={{fontSize:28}} >ErrorShift</Navbar.Brand>
                <Nav>
                    <Nav.Link href="/adv" style={{marginRight:"3rem"}}>홍보 및 시연</Nav.Link>
                    <Nav.Link href="/errortype" style={{marginRight:"3rem"}}>에러 분류</Nav.Link>
                    <Nav.Link href="#pricing">깃허브</Nav.Link>
                </Nav>
                </Container>
            </Navbar>
        </div>
    )
}
export default NavBar;