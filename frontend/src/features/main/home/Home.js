import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min";
import { useState } from "react";

import "./Home.css";

function Home() {
  const [click1, setClick1] = useState(false);
  const [click2, setClick2] = useState(false);
  const [click3, setClick3] = useState(false);

  return (
    <div>
      <div className="Home">
        <div className="main1"> </div>
        <div className="main2">
          <div>
            <div className="main2_1">
              <img id="title_sentence" alt="lamp" />
              <p style={{ marginLeft: 5 }}>
                저희는 이러한 생각을 가지고 출발했습니다
              </p>
            </div>
          </div>
          <div>
            <div className="main2_2">
              <img id="first_sentence" alt="check" />
              <p style={{ marginLeft: 10 }}>
                기본 에러 핸들러의 내용은 한눈에 파악하기 어렵다
              </p>
            </div>
            <div className="main2_3">
              <img id="second_sentence" alt="check" />
              <p style={{ marginLeft: 10 }}>
                복잡하지만 해결 못할 정도는 아니기 때문에 굳이 핸들링하지 않는다
              </p>
            </div>
            <div className="main2_4">
              <img id="third_sentence" alt="check" />
              <p style={{ marginLeft: 10 }}>
                좀 더 보기 편하면 좋지만 이걸 만드는 시간, 비용이 아깝다
              </p>
            </div>
          </div>
        </div>
        <div className="main3">
          <div
            className={click1 ? "card click1" : "card"}
            onClick={() => {
              setClick1(!click1);
            }}
          >
            <div className="face face1">
              <h2>쉽고 빠른 에러 핸들링</h2>
              <p>
                초보 개발자들도 쉽고 빠르게
                <br />
                에러를 찾을 수 있습니다
              </p>
            </div>
            <div className="face face2">
              <img id="image11" alt="easy" />
            </div>
          </div>
          <div
            className={click2 ? "card click2" : "card"}
            onClick={() => {
              setClick2(!click2);
            }}
          >
            <div className="face face1">
              <h2>쉬운 컨트리뷰트</h2>
              <p>
                누구나 컨트리뷰터가 될 수 있도록 간단하고 가독성 좋게
                구성하였습니다
              </p>
            </div>
            <div className="face face2">
              <img id="image12" alt="easy" />
            </div>
          </div>
          <div
            className={click3 ? "card click3" : "card"}
            onClick={() => {
              setClick3(!click3);
            }}
          >
            <div className="face face1">
              <h2>사용자 커스터마이징</h2>
              <p>각 유저마다 커스터마이즈 할 수 있도록 구성하였습니다</p>
            </div>
            <div className="face face2">
              <img id="image13" alt="easy" />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Home;
