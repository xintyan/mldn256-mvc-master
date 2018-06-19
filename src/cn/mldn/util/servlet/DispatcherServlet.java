package cn.mldn.util.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import cn.mldn.util.action.ActionMessageUtil;
import cn.mldn.util.web.ActionBeanUtil;
import cn.mldn.util.web.ParameterValidatorUtil;
import cn.mldn.util.web.RequestUrlUtil;
import cn.mldn.util.web.ServletObjectUtil;
/**
 * 项目的设计者需要把这个控制层的程序类编写完整，并且让其功能足够强大。
 * @author mldn
 */
@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	// 所有的请求交给服务方法创建请求处理线程
		
		String requestContextType = request.getContentType() ;	// 取得当前的表单模式
		if (requestContextType != null) {
			if (requestContextType.contains("multipart/form-data")) {	// 表示表单封装
				// 表单一旦被封装就意味着有可能进行文件的上传处理，就要准备好SmartUpload组件，但是这个组件最终肯定还是交给各个Action去操作
				SmartUpload smart = new SmartUpload() ;
				smart.initialize(super.getServletConfig(), request, response);
				try {
					smart.upload();
				} catch (SmartUploadException e) {
					e.printStackTrace();
				} 
				ServletObjectUtil.setSmartUpload(smart);
			}
		}
		ServletObjectUtil.setRequest(request);
		ServletObjectUtil.setResponse(response);
		String actionName = RequestUrlUtil.getActionName(request) ;
		
		ParameterValidatorUtil pvu = new ParameterValidatorUtil(actionName) ;
		if (pvu.validate()) {
			String urlResult [] = RequestUrlUtil.splitUrl(request) ;
			try {
				// DispatcherServlet程序类只是负责有数据跳转操作。
				String url = ActionBeanUtil.actionHandle(urlResult) ;
				ServletObjectUtil.clear(); 	// 清空保存的request、response
				if (url != null) {
					request.getRequestDispatcher(url).forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {	// 应该跳转到一个错误页上
			request.getRequestDispatcher(
					ActionMessageUtil.getUrl(actionName + ".error.page"))
					.forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
