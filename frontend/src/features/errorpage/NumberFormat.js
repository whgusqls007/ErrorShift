import SideBar from "../../common/sidebar/SideBar";
import Code from "react-code-prettify";
import "./ErrorPage.css";
function NumberFormat() {
  return (
    <div>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div className="content">
          <h2>NumberFormatException</h2>
          <div className="sub-content">
            <p>
              NumberFormatException 핸들링 하기 위해선 다음 코드를 작성하면
              됩니다.
            </p>
            <Code
              codeString={`// java
@ErrorShift(exception = NumberFormatException.class)
public class GlobalExceptionHandler {
}`}
            />
            <p>응답은 다음과 같습니다.</p>
            <Code
              codeString={`// json
{
    "Summary": "NumberFormatException is occurred  This error occurs when a character type is incorrectly changed to a numeric type. Please check the request URL and error message.",
    "Details": {
        "Error Message": "For input string: "123o"",
        "Location": {
            "File Name": "NumberFormatException.java",
            "Class Name": "java.lang.NumberFormatException",
            "Line Number": 65,
            "Method Name": "forInputString"
        }
    },
    "More Info": {
        "Request URL": "/api/v1/get-api/numberformat",
        "Message": "For input string: "123o"",
        "Timestamp": "2022-11-15T06:41:49.860+00:00"
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
@ErrorShift(exception = NumberFormatException.class, language = "ko")
public class GlobalExceptionHandler {
}
`}
            />
            <Code
              codeString={`// json
{
    "요약": "NumberFormatException이 발생했습니다. 문자형을 숫자형으로 잘못 변경 시 발생하는 에러입니다. 요청 URL과 에러 메세지를 확인해주세요.",
    "상세": {
        "에러 메시지": "For input string: "123o"",
        "에러 발생 위치": {
            "파일 이름": "NumberFormatException.java",
            "클래스 이름": "java.lang.NumberFormatException",
            "발생 라인": 65,
            "메소드 이름": "forInputString"
        }
    },
    "추가 정보": {
        "요청 URL": "/api/v1/get-api/numberformat",
        "발생 시각": "2022-11-15T06:40:38.329+00:00",
        "메시지": "For input string: "123o""
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
export default NumberFormat;
