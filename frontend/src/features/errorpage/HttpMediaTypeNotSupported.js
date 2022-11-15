import SideBar from "../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import "./ErrorPage.css";

function HttpMediaTypeNotSupported() {
  return (
    <div>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div className="content">
          <h2>HttpMediaTypeNotSupportedException</h2>
          <div className="sub-content">
            <p>
              HttpMediaTypeNotSupportedException 핸들링 하기 위해선 다음 코드를
              작성하면 됩니다.
            </p>
            <Code
              codeString={`// java
@ErrorShift(exception = HttpMediaTypeNotSupportedException.class)
public class GlobalExceptionHandler {
}
`}
            />
            <p>응답은 다음과 같습니다.</p>
            <Code
              codeString={`// json
{
    "Summary": "HttpMediaTypeNotSupportedException is occurred at org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping Class 267 line handleNoMatch method.",
    "Details": {
        "Error Message": "Content type '' not supported",
        "Content": {
            "Supported Media Type": "[application/xml]"
        },
        "Location": {
            "Class Name": "org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping",
            "Method Name": "handleNoMatch",
            "File Name": "RequestMappingInfoHandlerMapping.java",
            "Line Number": 267
        }
    },
    "More Info": {
        "Request URL": "/api/v1/get-api/httpMediaTypeNotSupported",
        "Message": "Content type '' not supported",
        "Timestamp": "2022-11-15T05:47:52.291+00:00"
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
@ErrorShift(exception = HttpMediaTypeNotSupportedException.class, language = "ko")
public class GlobalExceptionHandler {
}
`}
            />
            <Code
              codeString={`// json
{
    "요약": "org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping 클래스 267째 줄 handleNoMatch 메소드에서 HttpMediaTypeNotSupportedException이 발생했습니다.",
    "상세": {
        "에러 메시지": "Content type '' not supported",
        "에러 발생 위치": {
            "클래스 이름": "org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping",
            "발생 라인": 267,
            "메소드 이름": "handleNoMatch",
            "파일 이름": "RequestMappingInfoHandlerMapping.java"
        },
        "콘텐츠": {
            "지원되는 미디어 타입": "[application/xml]"
        }
    },
    "추가 정보": {
        "요청 URL": "/api/v1/get-api/httpMediaTypeNotSupported",
        "발생 시각": "2022-11-15T06:00:56.572+00:00",
        "메시지": "Content type '' not supported"
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
export default HttpMediaTypeNotSupported;
