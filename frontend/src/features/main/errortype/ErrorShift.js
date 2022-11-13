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
        <hr />
        <h4>1. prettyRes</h4>
        <div className="sub-content">
          <p>prettyRes 속성(기본 : true)은 결과를 가독성 있게 만들어 줍니다.</p>
          <Code
            codeString={`// java
@ErrorShift(exception = NullPointerException.class, prettyRes = true)`}
          />
          결과값 여기 넣기
        </div>
        <hr />
        <h4>2. message</h4>
        <div className="sub-content">
          <p>
            message 속성은 예외 발생 시, 사용자에게 보여줄 메시지를 설정할 수
            있습니다.
          </p>
          <Code
            codeString={`// java
@ErrorShift(exception = NullPointerException.class, message = "My Message")`}
          />
          <Code
            codeString={`
// json
{
  "요약": "com.example.test.controller.GetController클래스의 83째 줄 test메소드 에서 null예외가 발생했습니다.",
  "상세": {
      "에러 메시지": "NullPointerException",
      "에러 발생 위치": {
          "클래스 이름": "com.example.test.controller.GetController",
          "줄 번호": 83,
          "메소드 이름": "test",
          "파일 이름": "GetController.java"
      }
  },
  "사용자 메시지": "My Message",
  "요청 URL": "/api/v1/get-api/test",
  "타임스탬프": "2022-11-11T01:04:58.605+00:00",
  "메시지": "No message available",
  "HTTP 상태 코드": 500,
  "에러 종류": "Internal Server Error"
}`}
          />
        </div>
        <hr />
        <h4>3. logging</h4>
        <div className="sub-content">
          <p>
            logging 속성을 true로 주면(기본 : false) 로그를 정제해서 보여줍니다.
          </p>
          <Code
            codeString={`// java
@ErrorShift(exception = NullPointerException.class, logging = true)`}
          />
          사진사진 어쩌고 저쩌고 코드넣고 결과넣고
        </div>
        <hr />
        <h4>4. trace</h4>
        <div className="sub-content">
          <p>trace 속성을 true로 주면(기본 : false) stackTrace를 표시합니다.</p>
          <Code
            codeString={`// java
@ErrorShift(exception = NullPointerException.class, trace = true)`}
          />
          사진사진 어쩌고 저쩌고 코드넣고 결과넣고
        </div>
        <hr />
        <h4>5. httpStatus</h4>
        <div className="sub-content">
          <p>
            httpStatus 속성은 예외 발생 시, 사용자에게 보여줄 HTTP 상태 코드를
            설정할 수 있습니다. <br />미 설정시 기본 httpStatus를 따릅니다.
          </p>
          <Code
            codeString={`// java
@ErrorShift(exception = NullPointerException.class, httpStatus = HttpStatus.BAD_REQUEST)`}
          />
          여기다가 사진사진
        </div>
        <h4>6. userResPackage</h4>
        <div className="sub-content">
          <p>
            userResPackage 속성은 사용자가 원하는 결과값을 설정할 수 있습니다.
            <br />
            CommonResponse를 구현한 클래스를 만들어서 사용하면 됩니다.
            <Code
              codeString={`// java
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements CommonResponse {

  public Map<String, Object> details;
  public StackTraceElement[] stackTrace;

  UserResponse(HashMap<String, Object> map) {
    this.details = map;
  }

  @Override
  public CommonResponse of(Exception e) {
    ArithmeticException arithmeticException = (ArithmeticException) e;
    HashMap<String, Object> map = new HashMap<>();
    map.put("이런", "결과값이 나왔어요");
    setStackTrace(arithmeticException.getStackTrace());
    return new UserResponse(map);
  }
}`}
            ></Code>
          </p>
        </div>
      </div>
    </div>
  );
}
export default ErrorShift;
