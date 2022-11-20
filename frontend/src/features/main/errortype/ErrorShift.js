import SideBar from "../../../common/sidebar/SideBar";
import Code from "react-code-prettify";

import "./ErrorType.css";

function ErrorShift() {
  return (
    <strong>
      <div className="overall-screen">
        <div>
          <SideBar></SideBar>
        </div>
        <div className="content">
          <h2>ErrorShift</h2>
          <div className="sub-content">
            <p>ErrorShift는 다음과 같은 ErrorShift 어노테이션을 제공합니다.</p>
            <Code codeString={`@ErrorShift`} />
            <p>
              ErrorShift 어노테이션에는 반드시 exception 값으로 예외 class가
              들어가야 합니다.
            </p>
            <Code codeString={`@ErrorShift(exception = Exception.class)`} />
            <p>
              ErrorShift 어노테이션은 ControllerAdvice 어노테이션이 포함되어
              있습니다. 따라서, GlobalExceptionHandler 클래스를 따로 만들어
              어노테이션들을 사용하는 것을 권장합니다. <br />
              ErrorShift에서 사용 가능한 속성들은 다음과 같이, message, logging,
              prettyRes, trace, httpStatus, userResPackage, language 가
              있습니다.
            </p>
          </div>
          <hr />
          <h4>1. prettyRes</h4>
          <div className="sub-content">
            <p>
              prettyRes 속성(기본 : true)은 결과를 가독성 있게 만들어 줍니다.
            </p>
            <Code
              codeString={`// java
@ErrorShift(exception = NullPointerException.class, prettyRes = true)
public class GlobalExceptionHandler {
}
`}
            />
            <Code
              codeString={`// json
{
    "Summary": "NullPointerException is occurred at com.example.test.controller.GetController Class 83 line test method.",
    "Details": {
        "Error Message": "NullPointerException",
        "Location": {
            "File Name  ": "GetController.java",
            "Class Name ": "com.example.test.controller.GetController",
            "Line Number": 83,
            "Method Name": "test"
        }
    },
    "More Info": {
        "Request URL": "/api/v1/get-api/test",
        "Message": "No message available",
        "Timestamp": "2022-11-14T05:51:48.920+00:00"
    },
    "HTTP": {
        "Http Status": 500,
        "Error": "Internal Server Error"
    }
}`}
            />
          </div>
          <hr />
          <h4>2. message</h4>
          <div className="sub-content">
            <p>
              message 속성은 예외 발생 시, 사용자에게 보여줄 메시지를 설정할 수
              있습니다.
            </p>
            <Code
              codeString={`// java
@ErrorShift(exception = NullPointerException.class, message = "My Message")
public class GlobalExceptionHandler {
}
`}
            />
            <Code
              codeString={`// json
{
    "Summary": "NullPointerException is occurred at com.example.test.controller.GetController Class 83 line test method.",
    "Details": {
        "Error Message": "NullPointerException",
        "Location": {
            "File Name  ": "GetController.java",
            "Class Name ": "com.example.test.controller.GetController",
            "Line Number": 83,
            "Method Name": "test"
        }
    },
    "User Message": "My Message",
    "More Info": {
        "Request URL": "/api/v1/get-api/test",
        "Message": "No message available",
        "Timestamp": "2022-11-14T05:58:05.403+00:00"
    },
    "HTTP": {
        "Http Status": 500,
        "Error": "Internal Server Error"
    }
}`}
            />
          </div>
          <hr />
          <h4>3. logging</h4>
          <div className="sub-content">
            <p>
              logging 속성을 true로 주면(기본 : false) 로그를 정제해서
              보여줍니다.
            </p>
            <Code
              codeString={`// java
@ErrorShift(exception = NullPointerException.class, message = "My Message", logging = true)
public class GlobalExceptionHandler {
}
`}
            />
            <Code
              codeString={`// console
2022-11-16 12:14:44.854 ERROR 2036 --- [nio-8080-exec-2] java.lang.NullPointerException           :
status          ------>  500
error           ------>  Internal Server Error
message         ------>  My Message
path            ------>  /api/v1/re/null-pointer
errorMessage    ------>  NullPointerException
`}
            />
          </div>
          <hr />
          <h4>4. trace</h4>
          <div className="sub-content">
            <p>
              trace 속성을 true로 주면(기본 : false) stackTrace를 표시합니다.
            </p>
            <Code
              codeString={`// java
@ErrorShift(exception = NullPointerException.class, message = "My Message", trace = true)
public class GlobalExceptionHandler {
}
`}
            />
            <Code
              codeString={`// json
{
    "Stack Trace": [
        {
            "methodName": "test",
            "fileName": "GetController.java",
            "lineNumber": 83,
            "className": "com.example.test.controller.GetController",
            "nativeMethod": false
        },
        .
        .
        .
    ],
    "Summary": "NullPointerException is occurred at com.example.test.controller.GetController Class 83 line test method.",
    "Details": {
        "Error Message": "NullPointerException",
        "Location": {
            "File Name  ": "GetController.java",
            "Class Name ": "com.example.test.controller.GetController",
            "Line Number": 83,
            "Method Name": "test"
        }
    },
    "User Message": "My Message",
    "More Info": {
        "Request URL": "/api/v1/get-api/test",
        "Message": "No message available",
        "Timestamp": "2022-11-14T05:59:42.809+00:00"
    },
    "HTTP": {
        "Http Status": 500,
        "Error": "Internal Server Error"
    }
}
          `}
            />
          </div>
          <hr />
          <h4>5. httpStatus</h4>
          <div className="sub-content">
            <p>
              httpStatus 속성은 예외 발생 시, 사용자에게 보여줄 HTTP 상태 코드를
              설정할 수 있습니다. <br />미 설정시 기본 httpStatus를 따릅니다.
            </p>
            <Code
              codeString={`// java
@ErrorShift(exception = NullPointerException.class, message = "My Message", httpStatus = HttpStatus.NOT_FOUND)
public class GlobalExceptionHandler {
}
`}
            />
            <Code
              codeString={`// json
{
    "Summary": "NullPointerException is occurred at com.example.test.controller.GetController Class 83 line test method.",
    "Details": {
        "Error Message": "NullPointerException",
        "Location": {
            "File Name  ": "GetController.java",
            "Class Name ": "com.example.test.controller.GetController",
            "Line Number": 83,
            "Method Name": "test"
        }
    },
    "User Message": "My Message",
    "More Info": {
        "Request URL": "/api/v1/get-api/test",
        "Message": "No message available",
        "Timestamp": "2022-11-14T06:37:11.561+00:00"
    },
    "HTTP": {
        "Http Status": 404,
        "Error": "Not Found"
    }
}
          `}
            />
          </div>
          <hr />
          <h4>6. userResPackage</h4>
          <div className="sub-content">
            <p>
              userResPackage 속성은 사용자가 원하는 결과값을 설정할 수 있습니다.
              <br />
              CommonResponse를 구현한 클래스를 만들어서 사용하면 됩니다.
              <Code
                codeString={`// java
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements CommonResponse {

  public Map&lt;String, Object&gt; details;
  public StackTraceElement[] stackTrace;

  UserResponse(HashMap&lt;String, Object&gt; map) {
    this.details = map;
  }

  @Override
  public CommonResponse of(Exception e) {
    NullPointerException nullPointerException = (NullPointerException) e;
    HashMap&lt;String, Object&gt; map = new HashMap<>();
    map.put("이런", "결과값이 나왔어요");
    setStackTrace(nullPointerException.getStackTrace());
    return new UserResponse(map);
  }
}`}
              />
              <Code
                codeString={`// java
@ErrorShift(exception = NullPointerException.class, message = "My Message", userResPackage = "com.example.test.response.UserResponse")
public class GlobalExceptionHandler {
}
`}
              />
              <Code
                codeString={`// json
{
    "이런": "결과값이 나왔어요",
    "User Message": "My Message",
    "More Info": {
        "Request URL": "/api/v1/get-api/test",
        "Message": "No message available",
        "Timestamp": "2022-11-14T06:53:52.915+00:00"
    },
    "HTTP": {
        "Http Status": 500,
        "Error": "Internal Server Error"
    }
}
`}
              />
            </p>
          </div>
          <hr />
          <h4>7. language</h4>
          <div className="sub-content">
            <p>
              language 속성(default : "en") 을 사용하여 응답의 언어를 설정 할 수
              있습니다.
            </p>
            <Code
              codeString={`// java
@ErrorShift(exception = NullPointerException.class, message = "My Message", language = "ko")
public class GlobalExceptionHandler {
}
`}
            />
            <Code
              codeString={`// json
{
    "요약": "com.example.test.controller.GetController 클래스 83째 줄 test 메소드에서 NullPointerException이 발생했습니다.",
    "상세": {
        "에러 메시지": "NullPointerException",
        "에러 발생 위치": {
            "파일 이름": "GetController.java",
            "클래스 이름": "com.example.test.controller.GetController",
            "발생 라인": 83,
            "메소드 이름": "test"
        }
    },
    "사용자 메시지": "My Message",
    "추가 정보": {
        "요청 URL": "/api/v1/get-api/test",
        "발생 시각": "2022-11-14T06:59:54.493+00:00",
        "메시지": "No message available"
    },
    "HTTP": {
        "에러 종류": "Internal Server Error",
        "HTTP 상태 코드": 500
    }
}
`}
            />
          </div>
        </div>
      </div>
    </strong>
  );
}
export default ErrorShift;
