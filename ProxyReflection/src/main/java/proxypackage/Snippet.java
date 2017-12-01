package proxypackage;

import java.lang.reflect.Method;

public class Snippet {

	public class MyDynamicProxyClass implements java.lang.reflect.InvocationHandler {
		Object obj;

		public MyDynamicProxyClass(Object obj) {
			this.obj = obj;
		}

		public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
			try {
				// do something
			} catch (Exception e) {
				throw e;
			}
			// return something
			return args;
		}

		public Object newInstance(Object obj, @SuppressWarnings("rawtypes") Class[] interfaces) {
			return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), interfaces,
					new MyDynamicProxyClass(obj));
		}
	}

}
