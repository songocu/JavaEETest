package interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@MyInterceptor
@javax.interceptor.Interceptor
public class Interceptor {
	
	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		System.out.println("Catch REST message******************");
		return context.proceed();
	}
}
