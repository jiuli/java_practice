package aop_cglb;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
 * 此为代理类，用于在pointcut处添加advise*/
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        //添加切面逻辑
        System.out.println("Before..........");
        //执行目标类add方法
        proxy.invokeSuper(object, args);
        //添加切面逻辑
        System.out.println("After............");
        return null;
    }
}
