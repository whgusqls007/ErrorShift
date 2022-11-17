import SideBar from "../../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import img0 from "../../../assets/img/img0.png";
import img1 from "../../../assets/img/img1.png";
import img2 from "../../../assets/img/img2.png";
import img3 from "../../../assets/img/img3.png";
import "./ErrorType.css";

function Contribute() {
  return (
    <strong>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div className="content">
          <h2>Contribute Guide</h2>
          <div className="sub-content">
            <p>
              ErrorShift는 올바른 오픈소스 컨트리뷰트 문화를 지향합니다.{" "}
              <a
                href="https://www.contributor-covenant.org/ko/version/1/4/code-of-conduct/"
                target="_blank"
                rel="noreferrer"
              >
                컨트리뷰트 행동강령
              </a>
              을 참고하여 진행해 주세요!
            </p>
            <br />
            <h4>0. ErrorShift</h4>
            <p>
              ErrorShift의 개발 버전은 다음과 같아요. 컨트리뷰트시에 참고하여
              진행해 주세요.
            </p>
            <div style={{ fontSize: "20px" }}>
              <Code
                codeString={`
Java        -- openjdk version "1.8.0_332" 
SpringBoot  -- org.springframework.boot version "2.7.4"
Gradle      -- gradle "7.5.1"
`}
              />
            </div>
            <br />
            <hr />

            <h4>1. ErrorShift Github 들어가기</h4>
            <br />
            <p>
              우측 상단의 깃허브를 클릭, 또는{" "}
              <a
                href="https://github.com/S07P31E206/ErrorShift"
                target="_blank"
                rel="noreferrer"
              >
                여기
              </a>
              를 눌러 깃허브를 들어가세요
            </p>
            <img className="img" src={img0} width="100%" />
            <br />
            <hr />

            <h4>2. Repository fork 하기 </h4>
            <br />
            <p>우측 상단의 fork 버튼을 눌러 Repository를 복제하세요.</p>
            <img className="img" src={img1} width="100%" />
            <br />
            <hr />

            <h4>3. Repository clone 하기</h4>
            <br />
            <p>
              fork한 Repository를 로컬에 clone 해주세요.
              <div style={{ fontSize: "20px" }}>
                <Code codeString={`git clone "URL"`} />
              </div>
            </p>
            <img className="img" src={img2} width="100%" />
            <br />
            <hr />

            <h4>4. 작업</h4>
            <br />
            <p>
              <a
                href="https://github.com/S07P31E206/ErrorShift/blob/main/contribute.md"
                target="_blank"
                rel="noreferrer"
              >
                컨벤션
              </a>
              을 참고하여 새로운 브랜치를 생성, 작업을 한 후, commit, push
              해주세요.
              <div style={{ fontSize: "20px" }}>
                <Code
                  codeString={`
git checkout -b "branch name"
git add .
git commit -m "commit message"
git push origin "branch name"
`}
                />
              </div>
            </p>
            <br />
            <hr />

            <h4>5. Pull Request</h4>
            <br />
            <p>
              작업이 완료되면, pull request를 보내주세요. Pull request시에는{" "}
              <a
                href="https://github.com/S07P31E206/ErrorShift/blob/main/contribute.md"
                target="_blank"
                rel="noreferrer"
              >
                컨벤션
              </a>
              을 참고 해 주세요.
            </p>
            <img className="img" src={img3} width="100%" />
          </div>
        </div>
      </div>
    </strong>
  );
}
export default Contribute;
