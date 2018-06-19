package cn.mldn.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import cn.mldn.util.action.ActionUploadUtil;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.util.web.ServletObjectUtil;
import cn.mldn.vo.Dept;
import cn.mldn.vo.Emp;
/**
 * 开发者才会关注于此处的Action程序类
 * @author mldn
 *
 */
public class EmpAction {
	public EmpAction() {
		// System.out.println("********* 实例化EmpAction类对象");
	}
	public void show() throws Exception {	// 是一个无参的操作
		ServletObjectUtil.getResponse().getWriter().println("<h1>HelloWorld</h1>");
		ServletObjectUtil.getResponse().getWriter().println("<h1>"+ServletObjectUtil.getRequest().getContextPath()+"</h1>");
	}  
	public String add(long empno,String ename,double sal,int age,Date hiredate) throws Exception {
		ActionUploadUtil actionUpload = new ActionUploadUtil("upload/emp") ;	// 该路径要首先存在
		System.out.println(actionUpload.createSingleFileName());
		actionUpload.saveSingleFile(); 	// 文件保存
		System.out.println(empno + "、" + ename + "、" + sal + "、" + age + "、" + hiredate);
		return null ;
	}
	public String delete1(String ids[]) {
		System.out.println("## delete1 = " + Arrays.toString(ids));
		return null ;
	}
	public String delete2(int ids[]) {
		System.out.println("## delete2 = " + Arrays.toString(ids));
		return null ; 
	}
	public String edit(String mid,Emp vo) {
		System.out.println("## mid = " + mid);
		System.out.println("## vo = " + vo);
		return null ;
	} 
	public String add2(long empno) {
		System.out.println(empno);
		return null ;
	}
	public String editPre() {	// 是一个无参的操作
		return "/pages/back/admin/emp/emp_edit.jsp" ;
	}
	public ModelAndView addPre() {	// 是一个无参的操作
		ModelAndView mav = new ModelAndView("/pages/back/admin/emp/emp_add.jsp") ;
		List<Dept> all = new ArrayList<Dept>() ;
		for (int x = 0 ; x < 10 ; x ++) {
			Dept vo = new Dept() ;
			vo.setDeptno(x);
			vo.setDname("部门名称 - " + x);
			vo.setLoc("部门位置 - " + x);
			all.add(vo) ;
		}
		mav.add("allDepts",all);	// 传递属性
		// 中间可能是你的一些业务的操作方法调用
		return mav ;
	}
	public ModelAndView list() {	// 是一个无参的操作
		ModelAndView mav = new ModelAndView("/pages/back/admin/emp/emp_list.jsp") ;
		// 中间可能是你的一些业务的操作方法调用
		return mav ;
	}
}
