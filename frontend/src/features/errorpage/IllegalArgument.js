import SideBar from "../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import "./ErrorPage.css";

function IllegalArgument() {
  return (
    <strong>
      <div>
        <div className="overall-screen">
          <div>
            <SideBar></SideBar>
          </div>
          <div className="content">
            <h2>IllegalArgumentException</h2>
            <div className="sub-content">
              <p>
                IllegalArgumentException 핸들링 하기 위해선 다음 코드를 작성하면
                됩니다.
              </p>
              <Code
                codeString={`// java
@ErrorShift(exception = IllegalArgumentException.class)
public class GlobalExceptionHandler {
}
`}
              />
              <p>응답은 다음과 같습니다.</p>
              <Code
                codeString={`// json
{
    "Summary": "IllegalArgumentException is occurred at com.example.test.service.HelloService Class 27 line IllegalError method.",
    "Details": {
        "Error Message": "IllegalArgumentException",
        "Location": {
            "Class Name": "com.example.test.service.HelloService",
            "Method Name": "IllegalError",
            "File Name": "HelloService.java",
            "Line Number": 27
        }
    },
    "More Info": {
        "Request URL": "/api/v1/get-api/Illegal",
        "Message": "No message available",
        "Timestamp": "2022-11-15T05:49:32.934+00:00"
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
    @ErrorShift(exception = IllegalArgumentException.class, language = "ko")
    public class GlobalExceptionHandler {
    }
    `}
              />
              <Code
                codeString={`// json
{
    "요약": "com.example.test.service.HelloService 클래스 27째 줄 IllegalError 메소드에서 IllegalArgumentException이 발생했습니다.",
    "상세": {
        "에러 메시지": "IllegalArgumentException",
        "에러 발생 위치": {
            "클래스 이름": "com.example.test.service.HelloService",
            "발생 라인": 27,
            "메소드 이름": "IllegalError",
            "파일 이름": "HelloService.java"
        }
    },
    "추가 정보": {
        "요청 URL": "/api/v1/get-api/Illegal",
        "발생 시각": "2022-11-15T05:48:27.358+00:00",
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
    </strong>
  );
}
export default IllegalArgument;
