import Footer from '../../common/footer/Footer'
import SideBar from '../../common/sidebar/SideBar'

function NullPointer(){
    return(
        <div>
            <div className="overall-screen">
                <div>
                    <SideBar></SideBar>
                </div>
                <div style={{height:500, marginTop:80}}>
                    <h1>NullPointer</h1>
                </div>
            </div>
        </div>
    )
}
export default NullPointer;