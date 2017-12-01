package rest.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import rest.model.json.ResultJson;
import services.PostgresService;

@Path("/testRest")
@Stateless
public class RestService {
	
	@EJB
	PostgresService postgresService; 
	
    @Path("result/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public ResultJson getJson(@PathParam("id") Integer id,@QueryParam("text") String text) {
		ResultJson resultJson = new ResultJson();
		resultJson.setId(id);
		resultJson.setText("Gigel");
		return resultJson;
	}
    
    @Path("changeuser/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public String changeUser(@PathParam("id") Integer id,@QueryParam("text") String text) {
    	postgresService.changeUser(id,text);
    	return "Success!!!!";
	}
    
}
