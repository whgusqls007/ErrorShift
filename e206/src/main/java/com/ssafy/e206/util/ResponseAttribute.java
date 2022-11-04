package com.ssafy.e206.util;

import java.util.Map;

import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.http.HttpStatus;

@SuppressWarnings("unchecked")
public class ResponseAttribute {

	public static Map<String, Object> getResponseAttribute(Map<String, Object> result,
			AnnotationAttributes annotationAttribute, Throwable exception,
			Class<? extends Throwable> handleException, boolean useCustomResponse) {

		if (useCustomResponse) {
			result = getCustomResponse(exception, result);
		}

		String message = annotationAttribute.getString("message");
		if (!message.equals("")) {
			result.put("message", message);
		}

		result = setHttpStatus(result, annotationAttribute);

		return result;
	}

	public static Map<String, Object> getResponseAttribute(Map<String, Object> result,
			Map<String, Object> annotationData, Throwable exception,
			Class<? extends Throwable> handleException, boolean useCustomResponse) {

		if (useCustomResponse) {
			result = getCustomResponse(exception, result);
		}

		String message = (String) annotationData.get("message");
		if (message != null && !message.equals("")) {
			result.put("message", message);
		}

		result = setHttpStatus(result, annotationData);

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

	private static Map<String, Object> getCustomResponse(Throwable exception, Map<String, Object> result) {
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
			case "IndexOutOfBoundsException":
				result.remove("path");
				result.put("message", "IndexOutofBoundsException");
				break;
			case "IllegalArgumentException":
				result.remove("path");
				result.put("message", "IllegalArgumentException");
				break;
			default:
		}
		return result;
	}

	private static Map<String, Object> setHttpStatus(Map<String, Object> result,
			Map<String, Object> annotationData) {
		HttpStatus httpStatus = (HttpStatus) annotationData.get("httpStatus") != null
				? (HttpStatus) annotationData.get("httpStatus")
				: HttpStatus.OK;
		Integer status = httpStatus.value();

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
