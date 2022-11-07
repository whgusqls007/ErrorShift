package com.ssafy.e206.util;

import java.util.Map;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.logger.LoggerService;
import com.ssafy.e206.response.ArithmeticExceptionResponse;
import com.ssafy.e206.response.ArrayIndexOutOfBoundsExceptionResponse;
import com.ssafy.e206.response.HttpMediaTypeNotSupportedExceptionResponse;
import com.ssafy.e206.response.HttpRequestMethodNotSupportedExceptionResponse;
import com.ssafy.e206.response.IllegalArgumentExceptionResponse;
import com.ssafy.e206.response.IndexOutOfBoundsExceptionResponse;
import com.ssafy.e206.response.NoHandlerFoundExceptionResponse;
import com.ssafy.e206.response.NullPointerExceptionResponse;
import com.ssafy.e206.response.TypeMismatchExceptionResponse;

public class ResponseAttribute {

	@Autowired
	static LoggerService loggerService;

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
		switch (getExceptionName(exception)) {

			case "NullPointerException":
				NullPointerExceptionResponse nullPointerExceptionResponse = NullPointerExceptionResponse
						.of((NullPointerException) exception);
				if (showStackTrace) {
					result.put("trace", nullPointerExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
				result.putAll(nullPointerExceptionResponse.getDetails());
				break;

			case "HttpRequestMethodNotSupportedException":
				HttpRequestMethodNotSupportedExceptionResponse httpRequestMethodNotSupportedExceptionResponse = HttpRequestMethodNotSupportedExceptionResponse
						.of((HttpRequestMethodNotSupportedException) exception);
				if (showStackTrace) {
					result.put("trace", httpRequestMethodNotSupportedExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
				result.putAll(httpRequestMethodNotSupportedExceptionResponse.getDetails());
				break;

			case "MethodArgumentNotValidException":
				// MethodArgumentNotValidExceptionResponse
				// methodArgumentNotValidExceptionResponse =
				// MethodArgumentNotValidExceptionResponse
				// .of((MethodArgumentNotValidException) exception);
				// result.remove("path");
				// result.put("message", "MethodArgumentNotValidException");
				break;

			case "TypeMismatchException":
				TypeMismatchExceptionResponse typeMismatchExceptionResponse = TypeMismatchExceptionResponse
						.of((TypeMismatchException) exception);
				if (showStackTrace) {
					result.put("trace", typeMismatchExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
				result.putAll(typeMismatchExceptionResponse.getDetails());
				break;

			case "NoHandlerFoundException":
				NoHandlerFoundExceptionResponse noHandlerFoundExceptionResponse = NoHandlerFoundExceptionResponse
						.of((NoHandlerFoundException) exception);
				if (showStackTrace) {
					result.put("trace", noHandlerFoundExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
				result.putAll(noHandlerFoundExceptionResponse.getDetails());
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
				result.putAll(arithmeticExceptionResponse.getDetails());
				break;

			case "ArrayIndexOutOfBoundsException":
				ArrayIndexOutOfBoundsExceptionResponse arrayIndexOutOfBoundsExceptionResponse = ArrayIndexOutOfBoundsExceptionResponse
						.of((ArrayIndexOutOfBoundsException) exception);
				if (showStackTrace) {
					result.put("trace", arrayIndexOutOfBoundsExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
				result.putAll(arrayIndexOutOfBoundsExceptionResponse.getDetails());
				break;

			case "IndexOutOfBoundsException":
				IndexOutOfBoundsExceptionResponse indexOutOfBoundsExceptionResponse = IndexOutOfBoundsExceptionResponse
						.of((IndexOutOfBoundsException) exception);
				if (showStackTrace) {
					result.put("trace", indexOutOfBoundsExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
				result.putAll(indexOutOfBoundsExceptionResponse.getDetails());
				break;

			case "IllegalArgumentException":
				IllegalArgumentExceptionResponse illegalArgumentExceptionResponse = IllegalArgumentExceptionResponse
						.of((IllegalArgumentException) exception);
				if (showStackTrace) {
					result.put("trace", illegalArgumentExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
				result.putAll(illegalArgumentExceptionResponse.getDetails());
				break;

			default:
		}
		return result;
	}

	private static String getExceptionName(Throwable exception) {
		String[] exceptionNameArray = exception.getClass().getName().split("\\.");
		String exceptionName = exceptionNameArray[exceptionNameArray.length - 1];
		return exceptionName;
	}
}
