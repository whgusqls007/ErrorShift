import SideBar from "../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import "./ErrorPage.css";

function IndexOutOfBounds() {
  return (
    <div>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div className="content">
          <h2>IndexOutOfBoundsException</h2>
          <div className="sub-content">
            <p>
              IndexOutOfBoundsException 핸들링 하기 위해선 다음 코드를 작성하면
              됩니다.
            </p>
            <Code
              codeString={`// java
@ErrorShift(exception = IndexOutOfBoundsException.class)
public class GlobalExceptionHandler {
}`}
            />
            <p>응답은 다음과 같습니다.</p>
            <Code
              codeString={`// json
{
    "Summary": "IndexOutOfBoundsException is occurred at com.example.test.controller.GetController Class 132 line getIndexOutOfBoundsException method.",
    "Details": {
        "Error Message": "IndexOutOfBoundsException",
        "Location": {
            "Class Name": "com.example.test.controller.GetController",
            "Method Name": "getIndexOutOfBoundsException",
            "File Name": "GetController.java",
            "Line Number": 132
        }
    },
    "More Info": {
        "Request URL": "/api/v1/get-api/indexoutofbounds",
        "Message": "No message available",
        "Timestamp": "2022-11-15T05:51:35.109+00:00"
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
@ErrorShift(exception = IndexOutOfBoundsException.class, language = "ko")
public class GlobalExceptionHandler {
}
`}
            />
            <Code
              codeString={`// json
{
    "요약": "com.example.test.controller.GetController 클래스 132째 줄 getIndexOutOfBoundsException 메소드에서 IndexOutOfBoundsException이 발생했습니다.",
    "상세": {
        "에러 메시지": "IndexOutOfBoundsException",
        "에러 발생 위치": {
            "클래스 이름": "com.example.test.controller.GetController",
            "발생 라인": 132,
            "메소드 이름": "getIndexOutOfBoundsException",
            "파일 이름": "GetController.java"
        }
    },
    "추가 정보": {
        "요청 URL": "/api/v1/get-api/indexoutofbounds",
        "발생 시각": "2022-11-15T05:50:27.523+00:00",
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
export default IndexOutOfBounds;
