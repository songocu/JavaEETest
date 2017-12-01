package services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Interceptors(interceptor.TracingInterceptor.class)
@Stateless
public class SimpleService {
	
	@EJB
	SecondService secondService;
	
	public String doBusiniss(String param) {
		return param + " " + this.toString() + secondService.getSecondServiceName(this.toString());
	}
}
