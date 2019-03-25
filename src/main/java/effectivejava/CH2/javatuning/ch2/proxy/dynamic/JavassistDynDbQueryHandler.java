package effectivejava.CH2.javatuning.ch2.proxy.dynamic;

import effectivejava.CH2.javatuning.ch2.proxy.IDBQuery;
import javassist.util.proxy.MethodHandler;

import java.lang.reflect.Method;

public class JavassistDynDbQueryHandler implements MethodHandler {
	IDBQuery real=null;
	@Override
	public Object invoke(Object arg0, Method arg1, Method arg2, Object[] arg3)
			throws Throwable {
		if(real==null)
			real=new DBQuery();
		return real.request();	
	}
}
