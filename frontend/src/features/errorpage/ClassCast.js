import SideBar from "../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import "./ErrorPage.css";

function ClassCast() {
  return (
    <strong>
      <div>
        <div className="overall-screen">
          <div>
            <SideBar></SideBar>
          </div>
          <div className="content">
            <h2>ClassCastException</h2>
            <div className="sub-content">
              <p>
                ClassCastException 핸들링 하기 위해선 다음 코드를 작성하면
                됩니다.
              </p>
              <Code
                codeString={`// java
@ErrorShift(exception = ClassCastException.class)
public class GlobalExceptionHandler {
}
`}
              />
              <p>응답은 다음과 같습니다.</p>
              <Code
                codeString={`// json
{
    "Summary": "ClassCastException is occurred at com.example.test.controller.GetController Class 147 line getClassCastException method.",
    "Details": {
        "Error Message": "java.lang.Integer cannot be cast to java.lang.String",
        "Location": {
            "Class Name": "com.example.test.controller.GetController",
            "Method Name": "getClassCastException",
            "File Name": "GetController.java",
            "Line Number": 147
        }
    },
    "More Info": {
        "Request URL": "/api/v1/get-api/classcastexception",
        "Message": "java.lang.Integer cannot be cast to java.lang.String",
        "Timestamp": "2022-11-15T05:44:37.317+00:00"
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
@ErrorShift(exception = ClassCastException.class, language = "ko")
public class GlobalExceptionHandler {
}
`}
              />
              <Code
                codeString={`// json
{
  "요약": "com.example.test.controller.GetController 클래스 147째 줄 getClassCastException 메소드에서 ClassCastException이 발생했습니다.",
  "상세": {
      "에러 메시지": "java.lang.Integer cannot be cast to java.lang.String",
      "에러 발생 위치": {
          "클래스 이름": "com.example.test.controller.GetController",
          "발생 라인": 147,
          "메소드 이름": "getClassCastException",
          "파일 이름": "GetController.java"
      }
  },
  "추가 정보": {
      "요청 URL": "/api/v1/get-api/classcastexception",
      "발생 시각": "2022-11-15T06:00:10.267+00:00",
      "메시지": "java.lang.Integer cannot be cast to java.lang.String"
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
export default ClassCast;
