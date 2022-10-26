import NavBar from "../../../common/navbar/NavBar"
import { Sidebar, Menu, MenuItem, SubMenu } from 'react-pro-sidebar';

function ErrorType(){
    return(
        <div>
            <NavBar></NavBar>
            <Sidebar>
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
            </Sidebar>;
        </div>
    )
}
export default ErrorType;