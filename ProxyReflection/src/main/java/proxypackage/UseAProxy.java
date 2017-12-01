package proxypackage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UseAProxy {

	public void testInterface() throws Throwable {

		InvocationHandler handler = new InvocationHandler() {

			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("Invocation handler");
				return null;
			}
		};

		MyProxyInterface foo = (MyProxyInterface) java.lang.reflect.Proxy.newProxyInstance(
				MyProxyInterface.class.getClassLoader(), new Class[] { MyProxyInterface.class }, handler);
		
		handler.invoke(foo, null, null);
	}
}
