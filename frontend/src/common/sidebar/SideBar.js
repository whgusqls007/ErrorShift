import { Sidebar, Menu, MenuItem, SubMenu } from 'react-pro-sidebar';
import { Link } from 'react-router-dom';

function SideBar(){
    return(
        <div>
            <Sidebar style={{marginTop:80}}>
                <Menu>
                    <SubMenu label="4XX 에러">
                        <MenuItem routerLink={<Link to="/errortype/400" />}> 400 </MenuItem>
                        <MenuItem routerLink={<Link to="/errortype/401" />}> 401 </MenuItem>
                        <MenuItem routerLink={<Link to="/errortype/402" />}> 402 </MenuItem>
                    </SubMenu>
                    <SubMenu label="5XX 에러">
                        <MenuItem routerLink={<Link to="/errortype/500" />}> 500 </MenuItem>
                        <MenuItem routerLink={<Link to="/errortype/501" />}> 501 </MenuItem>
                        <MenuItem routerLink={<Link to="/errortype/502" />}> 502 </MenuItem>
                    </SubMenu>
                </Menu>
            </Sidebar>
        </div>
    )
}
export default SideBar;