package com.ssafy.e206.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.TypeMismatchException;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.e206.response.ArithmeticExceptionResponse;
import com.ssafy.e206.response.ArrayIndexOutOfBoundsExceptionResponse;
import com.ssafy.e206.response.ClassCastExceptionResponse;
import com.ssafy.e206.response.CommonResponse;
import com.ssafy.e206.response.HttpMediaTypeNotSupportedExceptionResponse;
import com.ssafy.e206.response.HttpRequestMethodNotSupportedExceptionResponse;
import com.ssafy.e206.response.IllegalArgumentExceptionResponse;
import com.ssafy.e206.response.IndexOutOfBoundsExceptionResponse;
import com.ssafy.e206.response.NoHandlerFoundExceptionResponse;
import com.ssafy.e206.response.NullPointerExceptionResponse;
import com.ssafy.e206.response.NumberFormatExceptionResponse;
import com.ssafy.e206.response.TypeMismatchExceptionResponse;

public class ResponseAttribute {
	public static Map<String, Object> getResponseAttribute(Map<String, Object> result,
			AnnotationAttributes annotationAttribute, Throwable exception,
			Class<? extends Throwable> handleException, boolean useCustomResponse) {

		String language = getLanguage(result, annotationAttribute);

		String userResPackage = annotationAttribute.getString("userResPackage");
		if (!userResPackage.equals("")) {
			result = getUserResponse(userResPackage, exception, result, annotationAttribute.getBoolean("trace"));
		} else if (useCustomResponse) {
			result = getCustomResponse(exception, result, annotationAttribute.getBoolean("trace"));
		}

		String message = annotationAttribute.getString("message");
		if (!message.equals("")) {
			// result.put("message", message);
			result.put("사용자 메시지", message);
		}
		Object resPath = result.get("path");
		Object resTimestamp = result.get("timestamp");
		Object resMessage = result.get("message");

		Map<String, Object> temp = new HashMap<>();
		temp.put("추가 정보", new HashMap<String, Object>(){
			{
				put("요청 URL", resPath);
				put("발생 시각", resTimestamp);
				put("메시지", resMessage);
			}
		});

		result.putAll(temp);

		// result.put("요청 URL", result.get("path"));
		result.remove("path");
		// result.put("타임스탬프", result.get("timestamp"));
		result.remove("timestamp");
		// result.put("메시지", result.get("message"));
		result.remove("message");

		result = setHttpStatus(result, annotationAttribute, language);

		return result;
	}

	private static Map<String, Object> setDetails(Map<String, Object> result, 
			AnnotationAttributes annotationAttribute, Throwable exception, String language) {
		switch (language) {
			case "ko":

				break;
			case "en":

				break;
			default:

				break;
		}
		return result;
	}

	private static Map<String, Object> koDetail(Map<String, Object> result,
			AnnotationAttributes annotationAttribute, Throwable exception, String language) {

		return result;
	}

	private static String getLanguage(Map<String, Object> result,
			AnnotationAttributes annotationAttributes) {
		String language = annotationAttributes.getString("language");
		return language;
	}

	private static Map<String, Object> setHttpStatus(Map<String, Object> result,
			AnnotationAttributes annotationAttribute, String language) {
		Integer status = ((HttpStatus) annotationAttribute.getEnum("httpStatus")).value();

		if (status != 200) {
			switch (language) {
				case "ko":
					result.remove("status");
					result.put("HTTP 상태 코드", status);
					result.remove("error");
					try {
						result.put("에러 종류", HttpStatus.valueOf(status).getReasonPhrase());
					} catch (Exception ex) {
						result.put("에러 종류", "Http Status " + status);
					}
					break;
				case "en":
					result.put("Http Status", status);
					result.remove("error");
					try {
						 result.put("Error", HttpStatus.valueOf(status).getReasonPhrase());
					} catch (Exception ex) {
						 result.put("Error", "Http Status " + status);
					}
					break;
				default:
					break;
			}
		}

		return result;
	}

	private static Map<String, Object> getUserResponse(String userResPackage, Throwable exception,
			Map<String, Object> result, boolean showStackTrace) {
		try {
			Class<?> clazz = Class.forName(userResPackage);
			CommonResponse commonResponse = ((CommonResponse) clazz.newInstance()).of((Exception) exception);
			result.putAll(commonResponse.getDetails());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private static Map<String, Object> getCustomResponse(Throwable exception, Map<String, Object> result,
			boolean showStackTrace) {
		switch (getExceptionName(exception)) {

			case "NullPointerException":
				NullPointerExceptionResponse nullPointerExceptionResponse = NullPointerExceptionResponse
						.of((NullPointerException) exception);
				result.remove("trace");
				if (showStackTrace) {
					// result.put("trace", nullPointerExceptionResponse.getStackTrace());
					result.put("Stack Trace", nullPointerExceptionResponse.getStackTrace());
				}
				// } else {
				// result.remove("trace");
				// }
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

			case "MethodArgumentNotValidException":
				// MethodArgumentNotValidExceptionResponse
				// methodArgumentNotValidExceptionResponse =
				// MethodArgumentNotValidExceptionResponse
				// .of((MethodArgumentNotValidException) exception);
				// result.remove("path");
				// result.put("message", "MethodArgumentNotValidException");
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
			case "ClassCastException":
				ClassCastExceptionResponse classCastExceptionResponse = ClassCastExceptionResponse
						.of((ClassCastException) exception);
				if (showStackTrace) {
					result.put("trace", classCastExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
				result.putAll(classCastExceptionResponse.getDetails());
				break;
			case "NumberFormatException":
				NumberFormatExceptionResponse numberFormatExceptionResponse = NumberFormatExceptionResponse
						.of((NumberFormatException) exception);
				if (showStackTrace) {
					result.put("trace", numberFormatExceptionResponse.getStackTrace());
				} else {
					result.remove("trace");
				}
				result.putAll(numberFormatExceptionResponse.getDetails());
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
