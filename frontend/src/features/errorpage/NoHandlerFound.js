import SideBar from "../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import "./ErrorPage.css";

function NoHandlerFound() {
  return (
    <div>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div className="content">
          <h2>NoHandlerFoundException</h2>
          <div className="sub-content">
            <p>
              NoHandlerFoundException 핸들링 하기 위해선 다음 코드를 작성하면
              됩니다.
            </p>
            <Code
              codeString={`// java
@ErrorShift(exception = NoHandlerFoundException.class)
public class GlobalExceptionHandler {
}`}
            />
            <p>응답은 다음과 같습니다.</p>
            <Code
              codeString={`// json
{
    "Summary": "NoHandlerFoundException is occurred. Could not find 'POST' method for path '/api/v1/get-api/61565161' Please check again the path and method.",
    "Details": {
        "Error Message": "No handler found for POST /api/v1/get-api/61565161",
        "HTTP": {
            "HTTP Method": "POST",
            "Request URL": "/api/v1/get-api/61565161"
        }
    },
    "More Info": {
        "Request URL": "/api/v1/get-api/61565161",
        "Message": "No handler found for POST /api/v1/get-api/61565161",
        "Timestamp": "2022-11-15T06:06:11.680+00:00"
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
@ErrorShift(exception = NoHandlerFoundException.class, language = "ko")
public class GlobalExceptionHandler {
}
`}
            />
            <Code
              codeString={`// json
{
    "요약": "NoHandlerFoundException이 발생했습니다. '/api/v1/get-api/nohandler' 경로에 대한 'POST' 메서드를 찾을 수 없습니다. path와 method를 다시한번 확인 바랍니다.",
    "상세": {
        "에러 메시지": "No handler found for POST /api/v1/get-api/nohandler",
        "HTTP": {
            "HTTP 메소드": "POST",
            "요청 URL": "/api/v1/get-api/nohandler"
        }
    },
    "추가 정보": {
        "요청 URL": "/api/v1/get-api/nohandler",
        "발생 시각": "2022-11-15T06:07:32.823+00:00",
        "메시지": "No handler found for POST /api/v1/get-api/nohandler"
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
export default NoHandlerFound;
