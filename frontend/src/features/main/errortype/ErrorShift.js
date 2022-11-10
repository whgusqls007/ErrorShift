import SideBar from "../../../common/sidebar/SideBar";
import Code from "react-code-prettify";

import "./ErrorType.css";

function ErrorShift() {
  return (
    <div className="overall-screen">
      <div>
        <SideBar></SideBar>
      </div>
      <div className="content">
        <h2>ErrorShift</h2>
        <div className="sub-content">
          <p>ErrorShift는 다음과 같은 ErrorShift 어노테이션을 제공합니다.</p>
          <Code codeString={`@ErrorShift`} />
          <p>
            ErrorShift 어노테이션에는 반드시 exception 값으로 예외 class가
            들어가야 합니다.
          </p>
          <Code codeString={`@ErrorShift(exception = Exception.class)`} />
          <p>
            ErrorShift에서 사용 가능한 속성들은 다음과 같이,
            <p style={{ marginBottom: 0 }}>
              message, logging, prettyRes, trace, httpStatus, userResPackage 가
              있습니다.
            </p>
          </p>
        </div>
        <h4>1. message</h4>
      </div>
    </div>
  );
}
export default ErrorShift;
