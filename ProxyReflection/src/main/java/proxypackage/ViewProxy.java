package proxypackage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class ViewProxy implements InvocationHandler {
	private Map<String, Object> map;

	public static Object newInstance(Map<String, Object> map, @SuppressWarnings("rawtypes") Class[] interfaces) {
		return Proxy.newProxyInstance(map.getClass().getClassLoader(), interfaces, new ViewProxy(map));
	}

	public ViewProxy(Map<String, Object> map) {
		this.map = map;
	}

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		String methodName = m.getName();
		if (methodName.startsWith("get")) {
			String name = methodName.substring(methodName.indexOf("get") + 3);
			return map.get(name);
		} else if (methodName.startsWith("set")) {
			String name = methodName.substring(methodName.indexOf("set") + 3);
			map.put(name, args[0]);
			return null;
		} else if (methodName.startsWith("is")) {
			String name = methodName.substring(methodName.indexOf("is") + 2);
			return (map.get(name));
		}
		return null;
	}
}