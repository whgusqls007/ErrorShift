import SideBar from "../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import "./ErrorPage.css";
function TypeMismatch() {
  return (
    <div>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div className="content">
          <h2>TypeMismatchException</h2>
          <div className="sub-content">
            <p>
              TypeMismatchException 핸들링 하기 위해선 다음 코드를 작성하면
              됩니다.
            </p>
            <Code
              codeString={`// java
@ErrorShift(exception = TypeMismatchException.class)
public class GlobalExceptionHandler {
}`}
            />
            <p>응답은 다음과 같습니다.</p>
            <Code
              codeString={`// json
{
    "Summary": "TypeMismatchException is occurred at com.example.test.controller.GetController Class 155 line getTypeMisatchException method.The required type is class java.lang.String",
    "Details": {
        "Error Message": "Failed to convert value of type 'com.example.test.service.HelloService' to required type 'java.lang.String'",
        "Location": {
            "File Name": "GetController.java",
            "Class Name": "com.example.test.controller.GetController",
            "Line Number": 155,
            "Method Name": "getTypeMisatchException"
        },
        "Type": {
            "Required Type": "java.lang.String",
            "Value": {},
            "Property Name": null,
            "Error Code": "typeMismatch"
        }
    },
    "More Info": {
        "Request URL": "/api/v1/get-api/typemis",
        "Message": "Failed to convert value of type 'com.example.test.service.HelloService' to required type 'java.lang.String'",
        "Timestamp": "2022-11-15T07:04:05.739+00:00"
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
@ErrorShift(exception = TypeMismatchException.class, language = "ko")
public class GlobalExceptionHandler {
}
`}
            />
            <Code
              codeString={`// json
{
    "요약": "com.example.test.controller.GetController 클래스155째 줄 getTypeMisatchException 메소드에서 TypeMismatchException이 발생했습니다.요구되는 타입은 'class java.lang.String' 입니다",
    "상세": {
        "에러 메시지": "Failed to convert value of type 'com.example.test.service.HelloService' to required type 'java.lang.String'",
        "에러 발생 위치": {
            "파일 이름": "GetController.java",
            "클래스 이름": "com.example.test.controller.GetController",
            "발생 라인": 155,
            "메소드 이름": "getTypeMisatchException"
        },
        "타입": {
            "요구되는 타입": "java.lang.String",
            "값": {},
            "속성 이름": null,
            "에러 코드": "typeMismatch"
        }
    },
    "추가 정보": {
        "요청 URL": "/api/v1/get-api/typemis",
        "발생 시각": "2022-11-15T07:01:28.449+00:00",
        "메시지": "Failed to convert value of type 'com.example.test.service.HelloService' to required type 'java.lang.String'"
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
export default TypeMismatch;
