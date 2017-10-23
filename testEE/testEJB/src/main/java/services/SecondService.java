package services;

import javax.ejb.Stateless;

@Stateless
public class SecondService {
	public String getSecondServiceName(String arg){
		return arg + this.toString();
	}
}
