import SideBar from "../../../common/sidebar/SideBar";
import Code from "react-code-prettify";

import "./ErrorType.css";

function ErrorType() {
  return (
    <strong>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div className="content">
          <h2>시작하기</h2>
          <p>ErrorShift는 빠르게 원하는 에러를 핸들링 할 수 있습니다.</p>
          <br />
          <h2>빠른 시작</h2>
          <h4>
            1. Maven (<strong>Not valid</strong>)
          </h4>
          <div className="sub-content">
            <p>
              Maven 프로젝트에서는 pom.xml에 다음과 같은 의존성을 추가해야
              합니다.
            </p>
            <Code
              codeString={`
&lt;groupId&gt;com.ssafy&lt;/groupId&gt;
&lt;artifactId&gt;e206&lt;/artifactId&gt;
&lt;version&gt;1.0.0&lt;/version&gt;`}
            />
          </div>
          <h4>
            2. Gradle (<strong>Not valid</strong>)
          </h4>
          <div className="sub-content">
            <p>
              Gradle 프로젝트에서는, 다음과 같은 의존성을 build.gradle 파일에
              추가해야 합니다.
            </p>
            <Code
              codeString={`implementation group: 'com.ssafy', name: 'e206', version: '1.0.0'`}
            />
            <p>또는 짧은 형식으로 다음과 같이 사용 할 수 있습니다.</p>
            <Code codeString={"implementation 'com.ssafy:e206:1.0.0'"} />
          </div>
          <h4>3. 외부 Jar 파일</h4>
          <div className="sub-content">
            <p>
              <a href="https://errorshift.com/file/download" download>
                여기
              </a>
              를 눌러 jar 파일을 다운 받을 수 있습니다.
            </p>
          </div>
          <br />
        </div>
      </div>
    </strong>
  );
}
export default ErrorType;
