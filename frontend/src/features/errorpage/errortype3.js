import NavBar from '../../common/navbar/NavBar'
import Footer from '../../common/footer/Footer'
import SideBar from '../../common/sidebar/SideBar'

function FourZeroTwo(){
    return(
        <div>
            <NavBar></NavBar>
            <div className="overall-screen">
                <div>
                    <SideBar></SideBar>
                </div>
                <div style={{height:500, marginTop:80}}>
                    <h1>에러타입3</h1>
                </div>
            </div>
            <Footer></Footer>
        </div>
    )
}
export default FourZeroTwo;