package com.ssafy.e206.response;

import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MaxUploadSizeExceededException;

public class MaxUploadSizeExceededExceptionResponse {
    private Map<String, Object> details;
    private static StackTraceElement[] stackTrace;

    public Map<String, Object> getDetails() {
        return details;
    }

    private MaxUploadSizeExceededExceptionResponse(final Map<String, Object> map) {
        this.details = map;
    }

    private static void setStackTraceElement(StackTraceElement[] stackTrace) {
        MaxUploadSizeExceededExceptionResponse.stackTrace = stackTrace;
        
    }

    public StackTraceElement[] getStackTrace() {
        return MaxUploadSizeExceededExceptionResponse.stackTrace;
    }

    public static MaxUploadSizeExceededExceptionResponse koOf(final MaxUploadSizeExceededException e) {

       
        HashMap<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        System.out.println(e.getStackTrace()[0].getClassName());
        sb.append(e.getStackTrace()[0].getClassName()).append(" 클래스 ");
        sb.append(e.getStackTrace()[0].getLineNumber()).append("째 줄 ");
        sb.append(e.getStackTrace()[0].getMethodName()).append(" 메소드에서 ");
        sb.append("MaxUploadSizeExceededException이 발생했습니다.");

        System.out.println(sb + " ----------------------------------sb----------------------------");
        map.put("요약", sb);
        map.put("상세", new HashMap<String, Object>() {
            {
                put("에러 메시지", e.getMessage() != null ? e.getMessage() : "MaxUploadSizeExceededException");
                put("에러 발생 위치", new HashMap<String, Object>() {
                    {
                        put("파일 이름", e.getStackTrace()[0].getFileName());
                        put("클래스 이름", e.getStackTrace()[0].getClassName());
                        put("발생 라인", e.getStackTrace()[0].getLineNumber());
                        put("메소드 이름", e.getStackTrace()[0].getMethodName());
                    }
                });
            }
        });
        setStackTraceElement(e.getStackTrace());
        return new MaxUploadSizeExceededExceptionResponse(map);
        }

    public static MaxUploadSizeExceededExceptionResponse enOf(final MaxUploadSizeExceededException e) {
        HashMap<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        sb.append(e.getMaxUploadSize() + "             ");
        sb.append("MaxUploadSizeExceededException is occurred at ");
        sb.append(e.getStackTrace()[0].getClassName()).append(" Class ");
        sb.append(e.getStackTrace()[0].getLineNumber()).append(" line ");
        sb.append(e.getStackTrace()[0].getMethodName()).append(" method.");

        map.put("Summary", sb);
        map.put("Details", new HashMap<String, Object>() {
            {
                put("Error Message", e.getMessage() != null ? e.getMessage() : "MaxUploadSizeExceededException");
                put("Location", new HashMap<String, Object>() {
                    {   
                        put("File Name", e.getStackTrace()[0].getFileName());
                        put("Class Name", e.getStackTrace()[0].getClassName());
                        put("Line Number", e.getStackTrace()[0].getLineNumber());
                        put("Method Name", e.getStackTrace()[0].getMethodName());
                    }
                });

            }
        });
        setStackTraceElement(e.getStackTrace());
        return new MaxUploadSizeExceededExceptionResponse(map);
    }

    public static MaxUploadSizeExceededExceptionResponse of(final MaxUploadSizeExceededException e, String language) {
        switch (language) {
            case "en":
                return enOf(e);
            case "ko":
                return koOf(e);
            default:
                return enOf(e);
        }
    }

    @Override
    public String toString() {
        return "MaxUploadSizeExceededException [ " + details + " ]";
    }
}
