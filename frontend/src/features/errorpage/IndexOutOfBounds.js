import Footer from '../../common/footer/Footer'
import SideBar from '../../common/sidebar/SideBar'

function IndexOutOfBounds(){
    return(
        <div>

            <div className="overall-screen">
                <div>
                    <SideBar></SideBar>
                </div>
                <div style={{height:500, marginTop:80}}>
                    <h1>IndexOutOfBounds</h1>
                </div>
            </div>
        </div>
    )
}
export default IndexOutOfBounds;