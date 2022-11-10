import SideBar from '../../common/sidebar/SideBar'

function HttpRequestMethodNotSupported(){
    return(
        <div>
            <div className="overall-screen">
                <div>
                    <SideBar></SideBar>
                </div>
                <div style={{height:500, marginTop:80}}>
                    <h1>HttpRequestMethodNotSupported.</h1>
                </div>
            </div>
        </div>
    )
}
export default HttpRequestMethodNotSupported;