import SideBar from "../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import "./ErrorPage.css";

function ArrayIndexOutOfBounds() {
  return (
    <strong>
      <div>
        <div className="overall-screen">
          <div>
            <SideBar></SideBar>
          </div>
          <div className="content">
            <h2>ArrayIndexOutOfBoundsException</h2>
            <div className="sub-content">
              <p>
                ArrayIndexOutOfBoundsException 핸들링 하기 위해선 다음 코드를
                작성하면 됩니다.
              </p>
              <Code
                codeString={`// java
@ErrorShift(exception = ArrayIndexOutOfBoundsException.class)
public class GlobalExceptionHandler {
}
`}
              />
              <p>응답은 다음과 같습니다.</p>
              <Code
                codeString={`// json
{
    "Summary": "ArrayIndexOutOfBoundsException is occurred at com.example.test.controller.GetController Class 126 line getArrayIndexOutOfBoundsException method.",
    "Details": {
        "Error Message": "index 2 exceeds the size of the array",
        "Location": {
            "Class Name": "com.example.test.controller.GetController",
            "Method Name": "getArrayIndexOutOfBoundsException",
            "File Name": "GetController.java",
            "Line Number": 126
        }
    },
    "More Info": {
        "Request URL": "/api/v1/get-api/arrayIndexOutOfBounds",
        "Message": "2",
        "Timestamp": "2022-11-15T05:40:21.402+00:00"
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
    @ErrorShift(exception = ArrayIndexOutOfBoundsException.class, language = "ko")
    public class GlobalExceptionHandler {
    }
    `}
              />
              <Code
                codeString={`// json
{
    "요약": "com.example.test.controller.GetController 클래스 126째 줄 getArrayIndexOutOfBoundsException 메소드에서 ArrayIndexOutOfBoundsException이 발생했습니다.",
    "상세": {
        "에러 메시지": "2번 인덱스는 배열의 크기를 초과 합니다.",
        "에러 발생 위치": {
            "클래스 이름": "com.example.test.controller.GetController",
            "발생 라인": 126,
            "메소드 이름": "getArrayIndexOutOfBoundsException",
            "파일 이름": "GetController.java"
        }
    },
    "추가 정보": {
        "요청 URL": "/api/v1/get-api/arrayIndexOutOfBounds",
        "발생 시각": "2022-11-15T05:59:08.295+00:00",
        "메시지": "2"
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
export default ArrayIndexOutOfBounds;
