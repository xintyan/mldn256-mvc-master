package cn.mldn.test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import cn.mldn.action.EmpAction;
import cn.mldn.util.bean.MethodUtil;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

public class TestMethodDemo {
	public static final String METHOD_NAME = "delete"; // 要操作的方法
	public static void main(String[] args) throws Exception {
		Class<?> cls = EmpAction.class; // 必须有Class对象，有了Class就可以找到ClassLoader
		Method method = MethodUtil.getMethod(cls, METHOD_NAME) ;
		Class<?> params [] = method.getParameterTypes() ;
		
		ClassPool classPool = ClassPool.getDefault(); // 是javassist包定义的内容，用于进行要解析类的工具定义
		CtClass ctClass = classPool.get("cn.mldn.action.EmpAction") ;	// 理解为要操作类的字节码文件
		CtMethod ctMethod = ctClass.getDeclaredMethod(method.getName()) ;	// 取得要操作的方法对象
		MethodInfo methodInfo = ctMethod.getMethodInfo() ;	// 取得方法的信息	
		// 以上是取得了方法的相关操作信息项，但是随后才是关键性的问题，如果要想取得参数的名称
		CodeAttribute codeAttribute = methodInfo.getCodeAttribute() ;	// 获取代码的属性
		LocalVariableAttribute attribute = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag) ;	// 取得属性的标签（名称）
		// 必须要考虑到方法上会带有static标志的问题，所以必须确定开始点
		int pos = Modifier.isStatic(ctMethod.getModifiers()) ? 0 : 1 ;
		for (int x = 0 ; x < params.length ; x ++) {
			System.out.println(attribute.variableName(x + pos));
		}
	}
}
