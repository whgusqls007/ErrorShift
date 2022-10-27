import NavBar from "../../../common/navbar/NavBar"
import Footer from "../../../common/footer/Footer"
import { Sidebar, Menu, MenuItem, SubMenu } from 'react-pro-sidebar';

import './ErrorType.css'

function ErrorType(){
    return(
        <div>
            <NavBar></NavBar>
            <div className="overall-screen">
                <div>
                    <Sidebar style={{marginTop:80}}>
                        <Menu>
                            <SubMenu label="4XX 에러">
                                <MenuItem> 401 </MenuItem>
                                <MenuItem> 402 </MenuItem>
                                <MenuItem> 403 </MenuItem>
                            </SubMenu>
                            <SubMenu label="5XX 에러">
                                <MenuItem> 501 </MenuItem>
                                <MenuItem> 502 </MenuItem>
                                <MenuItem> 503 </MenuItem>
                            </SubMenu>
                        </Menu>
                    </Sidebar>
                </div>
                <div className="content" style={{height:500}}>

                </div>
            </div>
            <Footer></Footer>
        </div>
    )
}
export default ErrorType;