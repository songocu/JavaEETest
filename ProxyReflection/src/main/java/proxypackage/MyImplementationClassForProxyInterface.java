package proxypackage;

public class MyImplementationClassForProxyInterface implements MyProxyInterface {

	public String MyMethod(String stringToBeAdded) {
		String returnString = "Method from implementation class invoked "+stringToBeAdded;
		System.out.println(returnString);
		return returnString;
		
	}

}
