package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Task;

@RequestScoped
@Path("/tasks")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class RestService {
	
	@Inject
	//Need to implement BusinessServiceInterface class
	BusinessServiceInterface BS;

	//Get all tasks in json format
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Task> getAllTasksAsJson() {
		
	}
}
