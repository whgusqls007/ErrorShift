import NavBar from "../../../common/navbar/NavBar"
import Footer from "../../../common/footer/Footer"
import "bootstrap/dist/css/bootstrap.min.css"
import 'bootstrap/dist/js/bootstrap.bundle.min'

import img from "../../../assets/img/img1.jpg"
import easy from "../../../assets/img/easy.png"
import contribute from "../../../assets/img/contribute.png"
import customize from "../../../assets/img/customize.png"
import lamp from "../../../assets/img/lamp.png"
import check from "../../../assets/img/check.png"

import './Home.css';

function Home(){
    return(
        <div>
            <NavBar></NavBar>
            <div className="Home">
                <div className="main1">
                    <div className="word">
                        <h1>ErrorShift</h1>
                        <p className="more-easy" style={{marginTop:15}}>에러를 더 쉽게, 더 빠르게</p> 
                    </div>    
                    <div>
                        <img style={{width:'60rem', height:'40rem'}} alt="babyImg" src={img} />
                    </div>
                </div>
                <div className="main2">
                    <div>
                        <div className="main2_1">
                            <img style={{width:'2rem', height:'2rem'}} alt="lamp" src={lamp} />
                            <p style={{marginLeft:5}}>저희는 이러한 생각을 가지고 출발했습니다</p>
                        </div>
                    </div>
                    <div>
                        <div className="main2_2">
                            <img style={{width:'1.5rem', height:'1.5rem'}} alt="check" src={check} />
                            <p style={{marginLeft:10}}>기본 에러 핸들러의 내용은 한눈에 파악하기 어렵다</p>
                        </div>
                        <div className="main2_3">
                            <img style={{width:'1.5rem', height:'1.5rem'}} alt="check" src={check} />
                            <p style={{marginLeft:10}}>복잡하지만 해결 못할 정도는 아니기 때문에 굳이 핸들링하지 않는다</p>
                        </div>
                        <div className="main2_4">
                            <img style={{width:'1.5rem', height:'1.5rem'}} alt="check" src={check} />
                            <p style={{marginLeft:10}}>좀 더 보기 편하면 좋지만 이걸 만드는 시간, 비용이 아깝다</p>
                        </div>
                    </div>
                </div>
                <div className="main3">
                    <div className="img-one">
                        <img style={{width:'10rem', height:'10rem'}} alt="easy" src={easy} />
                        <p className="main3-text" style={{marginTop: 20}}>쉽고 빠른 에러 핸들링</p>
                        <p style={{marginTop:'2rem'}}>초보 개발자들도 쉽고 빠르게</p>
                        <p>에러를 찾을 수 있습니다</p>
                    </div>
                    <div className="img-two">
                        <img style={{width:'10rem', height:'10rem'}} alt="contribute" src={contribute} />
                        <p className="main3-text" style={{marginTop: 20}}>쉬운 컨트리뷰트</p>
                        <p style={{marginTop:'2rem'}}>누구나 컨트리뷰터가 될 수 있도록 </p>
                        <p>간단하고 가독성 좋게 구성하였습니다</p>
                    </div>
                    <div className="img-three">
                        <img style={{width:'10rem', height:'10rem'}} alt="customize" src={customize} />
                        <p className="main3-text" style={{marginTop: 20}}>사용자 커스터마이징</p>
                        <p style={{marginTop:'2rem'}}>각 유저마다 커스터마이즈 할 수 있도록</p>
                        <p>구성하였습니다</p>
                    </div>
                </div>
            </div>
            <Footer></Footer>
        </div>
    )
}
export default Home;