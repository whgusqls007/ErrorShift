import SideBar from "../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import "./ErrorPage.css";

function HttpRequestMethodNotSupported() {
  return (
    <strong>
      <div>
        <div className="overall-screen">
          <div>
            <SideBar></SideBar>
          </div>
          <div className="content">
            <h2>HttpRequestMethodNotSupportedException</h2>
            <div className="sub-content">
              <p>
                HttpRequestMethodNotSupportedException 핸들링 하기 위해선 다음
                코드를 작성하면 됩니다.
              </p>
              <Code
                codeString={`// java
@ErrorShift(exception = HttpRequestMethodNotSupportedException.class)
public class GlobalExceptionHandler {
}
`}
              />
              <p>응답은 다음과 같습니다.</p>
              <Code
                codeString={`// json
{
    "Summary": "The supported method' is '[GET]', but requested method' is '[POST]'. Please check again",
    "Details": {
        "Error Message": "Request method 'POST' not supported",
        "Method Info": {
            "Supported HTTP Methods": [
                "GET"
            ],
            "Rquested Method": "POST"
        }
    },
    "More Info": {
        "Request URL": "/api/v1/get-api/requestnot",
        "Message": "Request method 'POST' not supported",
        "Timestamp": "2022-11-15T05:47:17.211+00:00"
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
@ErrorShift(exception = HttpRequestMethodNotSupportedException.class, language = "ko")
public class GlobalExceptionHandler {
}
`}
              />
              <Code
                codeString={`// json
{
    "요약": "지원되는 메소드는 '[GET]'지만 현재 요청하신 메소드는 '[POST]' 입니다",
    "상세": {
        "에러 메시지": "Request method 'POST' not supported",
        "메소드 정보": {
            "지원되는 메소드": [
                "GET"
            ],
            "요청 메소드": "POST"
        }
    },
    "추가 정보": {
        "요청 URL": "/api/v1/get-api/requestnot",
        "발생 시각": "2022-11-15T05:46:38.332+00:00",
        "메시지": "Request method 'POST' not supported"
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
export default HttpRequestMethodNotSupported;
