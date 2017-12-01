package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;
import services.PostgresService;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/PostgresServlet")
public class PostgresServlet extends HttpServlet{
	@EJB
    PostgresService postgresService;
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		
		if (operation.equals("create")){
			postgresService.create();
		} else if (operation.equals("list")) {
			List<Person> list = postgresService.list();
			resp.getWriter().println(list);
		} else if(operation.equals("createAndThrowException")) {
			postgresService.createUsersAndThrowException();
		} else {
			postgresService.delete();
		}
	}
}
