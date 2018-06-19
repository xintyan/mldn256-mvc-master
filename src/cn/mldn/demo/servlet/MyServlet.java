package cn.mldn.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private String msg = null; // 定义了一个变量， 这个变量定义在了Servlet类中
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print(request.getSession().getId());
		if (request.getParameter("msg") != null) {
			this.msg = request.getParameter("msg") ;
		} 
		System.out.println("************** msg = " + this.msg);
	}
}
