package cn.mldn.util.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.SmartUpload;

public class ServletObjectUtil {
	private static ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<HttpServletRequest>() ;
	private static ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<HttpServletResponse>() ;
	private static ThreadLocal<SmartUpload> smartThreadLocal = new ThreadLocal<SmartUpload>() ;
	private ServletObjectUtil() {} ;
	public static void setSmartUpload(SmartUpload smart) {
		smartThreadLocal.set(smart);
	}
	public static void setRequest(HttpServletRequest request) {
		requestThreadLocal.set(request);
	}
	public static void setResponse(HttpServletResponse response) {
		responseThreadLocal.set(response);
	}
	public static void clear() {
		requestThreadLocal.remove(); 
		responseThreadLocal.remove();
		smartThreadLocal.remove(); 
	}
	public static SmartUpload getSmartUpload() {
		return smartThreadLocal.get() ;
	}
	public static HttpServletRequest getRequest() {
		return requestThreadLocal.get() ;
	}
	public static HttpServletResponse getResponse() {
		return responseThreadLocal.get() ;
	}
	public static HttpSession getSession() {
		return requestThreadLocal.get().getSession() ;
	}
	public static ServletContext getServletContext() {
		return requestThreadLocal.get().getServletContext() ;
	}
}
