package AOP_JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现动态代理类*/
public class MyInvocationHandler implements InvocationHandler{
	private Object target;
	
	MyInvocationHandler(){
		super();
	}
	
	MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}
	
	/*
	 * 在该方法中加入切面逻辑的*/
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
		//程序执行前加入逻辑，
		System.out.println("Before..........");
		//程序执行
		Object res = method.invoke(target, args);
		//程序执行后加入逻辑，
		System.out.println("After..........");
		
		return res;
		
	}

}
