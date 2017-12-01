package rest;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import rest.services.RestService;

@ApplicationPath("/rest")
public class ApplicationConfig extends Application{
	  
	  @Override
	public Set<Class<?>> getClasses() {
		  Set<Class<?>> classes= new LinkedHashSet<>();
		  classes.add(RestService.class);
		return classes;
	}
	
}
