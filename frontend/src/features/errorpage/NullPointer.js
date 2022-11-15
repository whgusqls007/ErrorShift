import SideBar from "../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import "./ErrorPage.css";
function NullPointer() {
  return (
    <div>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div className="content">
          <h2>NullPointerException</h2>
          <div className="sub-content">
            <p>
              NullPointerException 핸들링 하기 위해선 다음 코드를 작성하면
              됩니다.
            </p>
            <Code
              codeString={`// java
@ErrorShift(exception = NullPointerException.class)
public class GlobalExceptionHandler {
}`}
            />
            <p>응답은 다음과 같습니다.</p>
            <Code
              codeString={`// json
{
    "Summary": "NullPointerException is occurred at com.example.test.controller.GetController Class 83 line test method.",
    "Details": {
        "Error Message": "NullPointerException",
        "Location": {
            "File Name  ": "GetController.java",
            "Class Name ": "com.example.test.controller.GetController",
            "Line Number": 83,
            "Method Name": "test"
        }
    },
    "More Info": {
        "Request URL": "/api/v1/get-api/test",
        "Message": "No message available",
        "Timestamp": "2022-11-15T06:09:28.663+00:00"
    },
    "HTTP": {
        "Http Status": 500,
        "Error": "Internal Server Error"
    }
}`}
            />
            <hr />
            <p>한글 응답은 다음과 같습니다.</p>
            <Code
              codeString={`// java
@ErrorShift(exception = NullPointerException.class, language = "ko")
public class GlobalExceptionHandler {
}
`}
            />
            <Code
              codeString={`// json
{
    "요약": "com.example.test.controller.GetController 클래스 83째 줄 test 메소드에서 NullPointerException이 발생했습니다.",
    "상세": {
        "에러 메시지": "NullPointerException",
        "에러 발생 위치": {
            "파일 이름": "GetController.java",
            "클래스 이름": "com.example.test.controller.GetController",
            "발생 라인": 83,
            "메소드 이름": "test"
        }
    },
    "추가 정보": {
        "요청 URL": "/api/v1/get-api/test",
        "발생 시각": "2022-11-15T06:09:05.035+00:00",
        "메시지": "No message available"
    },
    "HTTP": {
        "에러 종류": "Internal Server Error",
        "HTTP 상태 코드": 500
    }
}`}
            />
          </div>
        </div>
      </div>
    </div>
  );
}
export default NullPointer;
