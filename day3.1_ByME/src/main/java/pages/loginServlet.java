package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.*;
import pojos.*;
import Dao.CandidateDaoImpl;
/**
 * Servlet implementation class loginServlet
 */

@WebServlet(value= "/login", loadOnStartup = 1)


public class loginServlet extends HttpServlet {
	
	private userDaoImpl userDao;
	private CandidateDaoImpl candidateDao;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		
		try {
			// create dao instances
			
			userDao = new userDaoImpl();
			candidateDao = new CandidateDaoImpl();
			
			
			
			
		}catch(Exception e) {
			throw new ServletException("err in inti "+getClass(), e);
		}
	
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		
		try {
			
			userDao.cleanUp();
			candidateDao.cleanUp();
		
			
			
		}catch(Exception e) {
		System.out.println("err in destroy of "+getClass() + " "+e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try( PrintWriter pw = response.getWriter() ){
			
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			
			User user = userDao.authenticateUser(email, password);
			
			if(user == null) // login failed
				pw.print("<h2> Invalid email or password, please <a href='login.html'> Retry </a> </h2>");
			else {
				
				// creating a httpsession to remeber the user 
				//details and instances
				HttpSession hs = request.getSession();
				
				System.out.println("is new ? " + hs.isNew()); // t
				System.out.println("sesson id  " + hs.getId()) ;
				
				hs.setAttribute("user_detals", user);
				hs.setAttribute("user_dao", userDao);
				hs.setAttribute("candidate_dao", candidateDao);
				
				// role based authorization 
				
				if(user.getRole().equals("admin")) {
					response.sendRedirect("admin_page");
				}else
					
				if(user.isVoitngStatus()) {
					response.sendRedirect("logout");
				}else {
					
					response.sendRedirect("candidate_list");
					
				}
				
				
				
			}
			
			
			
			
			
		}catch(Exception e) {
			
			throw new ServletException("Err in do-get" + getClass(),e);
			
		}
		
	}

}
