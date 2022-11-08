import NavBar from "../../../common/navbar/NavBar"
import Footer from "../../../common/footer/Footer"
import SideBar from "../../../common/sidebar/SideBar"

import './ErrorType.css'

function ErrorType(){
    return(
        <div>
            <NavBar></NavBar>
            <div className="overall-screen">
                <div>
                    <SideBar></SideBar>
                </div>
                <div className="content" style={{height:500}}>
                </div>
            </div>
            <Footer></Footer>
        </div>
    )
}
export default ErrorType;