import SideBar from "../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import "./ErrorPage.css";

function Arithmetic() {
  return (
    <strong>
      <div>
        <div className="overall-screen">
          <div>
            <SideBar></SideBar>
          </div>
          <div className="content">
            <h2>ArithmeticException</h2>
            <div className="sub-content">
              <p>
                ArithmeticException을 핸들링 하기 위해선 다음 코드를 작성하면
                됩니다.
              </p>
              <Code
                codeString={`// java
@ErrorShift(exception = ArithmeticException.class)
public class GlobalExceptionHandler {
}
`}
              />
              <p>응답은 다음과 같습니다.</p>
              <Code
                codeString={`// json
{
    "Summary": "ArithmeticException is occurred at com.example.test.controller.GetController Class 137 line getArithmeticException method.",
    "Details": {
        "Error Message": "/ by zero",
        "Location": {
            "Class Name": "com.example.test.controller.GetController",
            "Method Name": "getArithmeticException",
            "File Name": "GetController.java",
            "Line Number": 137
        }
    },
    "More Info": {
        "Request URL": "/api/v1/get-api/arithmetic/0",
        "Message": "/ by zero",
        "Timestamp": "2022-11-15T05:16:02.920+00:00"
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
    @ErrorShift(exception = ArithmeticException.class, language = "ko")
    public class GlobalExceptionHandler {
    }
    `}
              />
              <Code
                codeString={`// json
{
    "요약": "com.example.test.controller.Error500RuntimeExceptionController 클래스 43째 줄 getArithmeticException 메소드에서 ArithmeticException이 발생했습니다.",
    "상세": {
        "에러 메시지": "/ by zero",
        "에러 발생 위치": {
            "클래스 이름": "com.example.test.controller.Error500RuntimeExceptionController",
            "발생 라인": 43,
            "메소드 이름": "getArithmeticException",
            "파일 이름": "Error500RuntimeExceptionController.java"
        }
    },
    "추가 정보": {
        "요청 URL": "/api/v1/re/arithmetic/0",
        "발생 시각": "2022-11-15T05:58:31.960+00:00",
        "메시지": "/ by zero"
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
export default Arithmetic;
