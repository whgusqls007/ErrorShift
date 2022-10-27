import NavBar from "../../../common/navbar/NavBar"
import Footer from "../../../common/footer/Footer"
import "bootstrap/dist/css/bootstrap.min.css"
import 'bootstrap/dist/js/bootstrap.bundle.min'
import img from "../../../assets/img/img1.jpg"

import './Home.css';

function Home(){
    return(
        <div>
            <NavBar></NavBar>
            <div className="Home">
                <div className="main1">
                    <div className="word">
                        <h1>ErrorShift</h1>
                        <h5 style={{marginTop:15}}>에러를 더 쉽게, 더 빠르게</h5> 
                    </div>    
                    <div>
                        <img style={{width:'60rem', height:'40rem'}} alt="babyImg" src={img} />
                    </div>
                </div>
            </div>
            <Footer></Footer>
        </div>
    )
}
export default Home;