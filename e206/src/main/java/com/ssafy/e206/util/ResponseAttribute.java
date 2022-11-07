package com.ssafy.e206.util;

import java.lang.reflect.Method;
import java.util.Map;

import com.ssafy.e206.response.*;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.NoHandlerFoundException;

public class ResponseAttribute {

	public static Map<String, Object> getResponseAttribute(Map<String, Object> result,
			AnnotationAttributes annotationAttribute, Throwable exception,
			Class<? extends Throwable> handleException, boolean useCustomResponse) {

		if (useCustomResponse) {
			result = getCustomResponse(exception, result, annotationAttribute.getBoolean("trace"));
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
			result = getCustomResponse(exception, result,
					(Boolean) annotationData.get("trace") != null ? (Boolean) annotationData.get("trace") : false);
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

	private static Map<String, Object> getCustomResponse(Throwable exception, Map<String, Object> result,
			boolean showStackTrace) {
//		String exceptionName = getExceptionName(exception);
//		String packageName = "com.ssafy.e206.response.";
//		String responseName = packageName.concat(exceptionName).concat("Response");
//		try {
//			Class<?> exceptionClass = Class.forName(responseName);
//			Object newObj = exceptionClass.newInstance();
//			Method of = exceptionClass.getDeclaredMethod("of", Exception.class);
//			of.invoke(newObj, exception);
//
//		} catch (Exception e) {
//		}
		switch (getExceptionName(exception)) {
			case "NullPointerException":
				NullPointerExceptionResponse nullPointerExceptionResponse = NullPointerExceptionResponse
						.of((NullPointerException) exception);
				if (showStackTrace) {
					result.put("trace", nullPointerExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
//				result.remove("path");
//				result.put("message", "NullPointerException");
				break;
			case "HttpRequestMethodNotSupportedException":
				HttpRequestMethodNotSupportedExceptionResponse httpRequestMethodNotSupportedExceptionResponse = HttpRequestMethodNotSupportedExceptionResponse
						.of((HttpRequestMethodNotSupportedException) exception);
				if (showStackTrace) {
					result.put("trace", httpRequestMethodNotSupportedExceptionResponse.getStackTrace());
				}else {
					result.remove("trace");
				}
//				result.remove("path");
//				result.put("message", "HttpRequestMethodNotSupportedException");
				break;
			case "MethodArgumentNotValidException":
				MethodArgumentNotValidExceptionResponse methodArgumentNotValidExceptionResponse = MethodArgumentNotValidExceptionResponse
						.of((MethodArgumentNotValidException) exception);
				if (showStackTrace) {
					result.put("trace", methodArgumentNotValidExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
//				result.remove("path");
//				result.put("message", "MethodArgumentNotValidException");
				break;
			case "TypeMismatchException":
				TypeMismatchExceptionResponse typeMismatchExceptionResponse = TypeMismatchExceptionResponse
						.of((TypeMismatchException) exception);
				if (showStackTrace) {
					result.put("trace", typeMismatchExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
//				result.remove("path");
//				result.put("message", "TypeMismatchException");
				break;
			case "NoHandlerFoundException":
				NoHandlerFoundExceptionResponse noHandlerFoundExceptionResponse = NoHandlerFoundExceptionResponse
						.of((NoHandlerFoundException) exception);
				if (showStackTrace) {
					result.put("trace", noHandlerFoundExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
//				result.remove("path");
//				result.put("message", "NoHandlerFoundException");
				break;
			case "HttpMediaTypeNotSupportedException":
				HttpMediaTypeNotSupportedExceptionResponse httpMediaTypeNotSupportedExceptionResponse = HttpMediaTypeNotSupportedExceptionResponse
						.of((HttpMediaTypeNotSupportedException) exception);
				if (showStackTrace) {
					result.put("trace", httpMediaTypeNotSupportedExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
				result.putAll(httpMediaTypeNotSupportedExceptionResponse.getDetails());
				break;
			case "ArithmeticException":
				ArithmeticExceptionResponse arithmeticExceptionResponse = ArithmeticExceptionResponse
						.of((ArithmeticException) exception);
				if (showStackTrace) {
					result.put("trace", arithmeticExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
//				result.remove("trace");
//				result.putAll(ArithmeticExceptionResponse.of((ArithmeticException) exception).getDetails());
				break;
			case "ArrayIndexOutOfBoundsException":
				ArrayIndexOutOfBoundsExceptionResponse arrayIndexOutOfBoundsExceptionResponse = ArrayIndexOutOfBoundsExceptionResponse
						.of((ArrayIndexOutOfBoundsException) exception);
				if (showStackTrace) {
					result.put("trace", arrayIndexOutOfBoundsExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
//				result.remove("path");
//				result.put("message", "ArrayIndexOutOfBoundsException");
				break;
			case "IndexOutOfBoundsException":
				IndexOutOfBoundsExceptionResponse indexOutOfBoundsExceptionResponse = IndexOutOfBoundsExceptionResponse
						.of((IndexOutOfBoundsException) exception);
				if (showStackTrace) {
					result.put("trace", indexOutOfBoundsExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
//				result.remove("path");
//				result.put("message", "IndexOutofBoundsException");
				break;
			case "IllegalArgumentException":
				IllegalArgumentExceptionResponse illegalArgumentExceptionResponse = IllegalArgumentExceptionResponse
						.of((IllegalArgumentException) exception);
				if (showStackTrace) {
					result.put("trace", illegalArgumentExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
//				result.remove("path");
//				result.put("message", "IllegalArgumentException");
				break;
			case "ClassCastException":
				ClassCastExceptionResponse classCastExceptionResponse = ClassCastExceptionResponse
						.of((ClassCastException) exception);
				if (showStackTrace) {
					result.put("trace", classCastExceptionResponse.getStackTrace());
				}else {
					result.remove("trace");
				}
//				result.remove("path");
//				result.put("message", "ClassCastException");
				break;
			case "NumberFormatException":
				NumberFormatExceptionResponse numberFormatExceptionResponse = NumberFormatExceptionResponse
						.of((NumberFormatException) exception);
				if (showStackTrace) {
					result.put("trace", numberFormatExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
//				result.remove("path");
//				result.put("message", "NumberFormatException");
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
