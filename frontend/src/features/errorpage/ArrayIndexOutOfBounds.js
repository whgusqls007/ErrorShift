import NavBar from '../../common/navbar/NavBar'
import Footer from '../../common/footer/Footer'
import SideBar from '../../common/sidebar/SideBar'

function ArrayIndexOutOfBounds(){
    return(
        <div>
            <NavBar></NavBar>
            <div className="overall-screen">
                <div>
                    <SideBar></SideBar>
                </div>
                <div style={{height:500, marginTop:80}}>
                    <h1>ArrayIndexOutOfBounds</h1>
                </div>
            </div>
            <Footer></Footer>
        </div>
    )
}
export default ArrayIndexOutOfBounds;