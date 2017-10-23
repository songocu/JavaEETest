package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.SimpleService;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/SimpleServlet")
public class SimpleServlet extends HttpServlet{
	
	@EJB
	SimpleService simpleService;
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print(this.toString() + simpleService.doBusiniss("test Service"));
	}
}
