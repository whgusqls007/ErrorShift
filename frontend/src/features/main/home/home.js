import NavBar from "../../../common/navbar/NavBar"
import "bootstrap/dist/css/bootstrap.min.css"
import 'bootstrap/dist/js/bootstrap.bundle.min'
import img from "../../../assets/img/img1.jpg"

function Home(){
    return(
        <div>
            <NavBar></NavBar>
            <div className="Home">
                <div className="main1">
                    <h1>ErrorShift</h1>
                    <h5>에러를 더 쉽게, 더 빠르게</h5>
                    <div>
                        <img src={img} />
                    </div>
                </div>
            </div>
        </div>
    )
}
export default Home;