import NavBar from "../../../common/navbar/NavBar"
import Footer from "../../../common/footer/Footer"

import "./Adv.css"

function Adv(){
    return(
        <div>
            <NavBar></NavBar>
            <div style={{height:580}}>
                <div className="adv-main">
                    <p className="adv-title">ErrorShift 영상</p>
                    <div className="adv-video">
                        영상 들어갈 자리
                    </div>
                </div>  
            </div>
            <Footer></Footer>
        </div>
    )
}
export default Adv;