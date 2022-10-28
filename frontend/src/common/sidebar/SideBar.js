import { Sidebar, Menu, MenuItem, SubMenu } from 'react-pro-sidebar';
import { Link } from 'react-router-dom';

function SideBar(){
    
    return(
        <div>
            <Sidebar style={{marginTop:80}}>
                <Menu>
                    <MenuItem routerLink={<Link to="/errortype/errortype1"/>}> 에러타입1 </MenuItem>
                    <MenuItem routerLink={<Link to="/errortype/errortype2"/>}> 에러타입2 </MenuItem>
                    <MenuItem routerLink={<Link to="/errortype/errortype3"/>}> 에러타입3 </MenuItem>
                </Menu>
            </Sidebar>
        </div>
    )
}
export default SideBar;