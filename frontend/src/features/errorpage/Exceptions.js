import SideBar from "../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import "./ErrorPage.css";

function Exceptions() {
  return (
    <div>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div className="content">
          <h2>Multiple Exceptions</h2>
          <div className="sub-content">
            <p>
              ErrorShift 내부엔 Repeatable 어노테이션이 적용되어 있습니다. 즉,
              같은 어노테이션을 여러번 적용할 수 있습니다.
              <br />
              이를 이용하여, 여러개의 예외를 한번에 처리할 수 있습니다.
              <br />
              예를 들어, NullPointerException과 ArithmeticException을 처리하고
              싶다면, 아래와 같이 작성하면 됩니다.
              <br />
              <br />
              <Code
                codeString={`// java
@ErrorShift(exception = NullPointerException.class)
@ErrorShift(exception = ArithmeticException.class)
public class GlobalExceptionHandler {
}
`}
                language="java"
              />
              <br />
              이렇게 작성하면, NullPointerException과 ArithmeticException을
              처리할 수 있습니다.
              <br />
              또한, 각각의 예외에 대해 다른 처리를 하고 싶다면, 아래와 같이
              작성하면 됩니다.
              <br />
              <br />
              <Code
                codeString={`// java
@ErrorShift(exception = NullPointerException.class, message = "Null Pointer Exception", httpStatus = HttpStatus.BAD_REQUEST)
@ErrorShift(exception = ArithmeticException.class, message = "Arithmetic Exception", httpStatus = HttpStatus.NOT_FOUND, language = "ko")
public class GlobalExceptionHandler {
}
`}
                language="java"
              />
              <br />
              이렇게 작성하면, NullPointerException은 400에러와 사용자 메시지
              'Null Pointer Exception'을, ArithmeticException은 404에러와 사용자
              메시지 'Arithmetic Exception'을 한글로 반환합니다.
              <br />
              <br />
              응답은 다음과 같습니다
              <br />
              <br />
              <Code
                codeString={`// json
// Null Pointer Exception
{
    "Summary": "NullPointerException is occurred at com.example.test.controller.Error500RuntimeExceptionController Class 218 line getNullPointerException method.",
    "Details": {
        "Error Message": "NullPointerException",
        "Location": {
            "File Name  ": "Error500RuntimeExceptionController.java",
            "Class Name ": "com.example.test.controller.Error500RuntimeExceptionController",
            "Line Number": 218,
            "Method Name": "getNullPointerException"
        }
    },
    "User Message": "Null Pointer Exception",
    "More Info": {
        "Request URL": "/api/v1/re/null-pointer",
        "Message": "No message available",
        "Timestamp": "2022-11-17T00:14:11.770+00:00"
    },
    "HTTP": {
        "Http Status": 400,
        "Error": "Bad Request"
    }
}

// Arithmetic Exception
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
    "사용자 메시지": "Arithmetic Exception",
    "추가 정보": {
        "요청 URL": "/api/v1/re/arithmetic/0",
        "발생 시각": "2022-11-17T00:18:59.148+00:00",
        "메시지": "/ by zero"
    },
    "HTTP": {
        "에러 종류": "Not Found",
        "HTTP 상태 코드": 404
    }
}
`}
              />
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Exceptions;
