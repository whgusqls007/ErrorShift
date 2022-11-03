package com.ssafy.e206.util;

import java.util.Map;

import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.http.HttpStatus;

@SuppressWarnings("unchecked")
public class ResponseAttribute {

	public static Map<String, Object> getResponseAttribute(Map<String, Object> result,
			AnnotationAttributes annotationAttributes, Throwable exception,
			Class<? extends Throwable> handleException) {

		Map<String, Object> datas = GetAnnotationData.getAnnotationData(annotationAttributes);

		switch (getExceptionName(exception)) {
			case "NullPointerException":
				result.remove("path");
				result.put("message", "NullPointerException");
				break;
			case "HttpRequestMethodNotSupportedException":
				result.remove("path");
				result.put("message", "HttpRequestMethodNotSupportedException");
				break;
			case "MethodArgumentNotValidException":
				result.remove("path");
				result.put("message", "MethodArgumentNotValidException");
				break;
			case "TypeMismatchException":
				result.remove("path");
				result.put("message", "TypeMismatchException");
				break;
			case "NoHandlerFoundException":
				result.remove("path");
				result.put("message", "NoHandlerFoundException");
				break;
			case "HttpMediaTypeNotSupportedException":
				result.remove("path");
				result.put("message", "HttpMediaTypeNotSupportedException");
				break;
			case "ArithmeticException":
				result.remove("path");
				result.put("message", "ArithmeticException");
				break;
			case "ArrayIndexOutOfBoundsException":
				result.remove("path");
				result.put("message", "ArrayIndexOutOfBoundsException");
				break;
			case "IllegalArgumentException":
				result.remove("path");
				result.put("message", "IllegalArgumentException");
				break;
			default:
		}

		if (!datas.get("message").equals("")) {
			result.put("message", datas.get("message"));
		}

		result = setHttpStatus(result, annotationAttributes);

		return result;
	}

	public static Map<String, Object> getResponseAttribute(Map<String, Object> result,
			Class<? extends Throwable> exception,
			Map<String, Object> annotationData) {

		return result;
	}

	private static Map<String, Object> setHttpStatus(Map<String, Object> result,
			AnnotationAttributes annotationAttribute) {
		Integer status = ((HttpStatus) annotationAttribute.getEnum("httpStatus")).value();

		if (status != 200) {
			result.put("status", status);
			try {
				result.put("error", HttpStatus.valueOf(status).getReasonPhrase());
			} catch (Exception ex) {
				result.put("error", "Http Status " + status);
			}
		}

		return result;
	}

	private static String getExceptionName(Throwable exception) {
		String[] exceptionNameArray = exception.getClass().getName().split("\\.");
		String exceptionName = exceptionNameArray[exceptionNameArray.length - 1];
		return exceptionName;
	}
}
