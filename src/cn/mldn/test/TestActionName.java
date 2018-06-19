package cn.mldn.test;

public class TestActionName {
	public static void main(String[] args) {
		String url = "http://localhost/MyDispatcherServlet/pages/back/admin/dept/DeptAction!edit.action?cp=2&ls=10&col=&kw=";
		System.out.println(url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(".")));
	}
}
