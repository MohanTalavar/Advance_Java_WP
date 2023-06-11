package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CandidateDaoImpl;
import Dao.userDaoImpl;
import pojos.User;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			
			HttpSession session = request.getSession();
			
			// get voter details
			
			User voter = (User) session.getAttribute("user_details");
			
			if(voter!=null) {
				if(voter.isVoitngStatus())
					pw.print("</h3> You have already voted !!!! <h3>");
				else {
					
					int candidateId = Integer.parseInt(request.getParameter("cid"));
					
					userDaoImpl userDao = (userDaoImpl) session.getAttribute("user_dao");
					CandidateDaoImpl candDao = (CandidateDaoImpl) session.getAttribute("candidate_dao");
					
					// update voting status
					
					pw.print("<h5>" +userDao.updateVotingStatus(voter.getId())+"</h5>");
					
				}
			}else
				pw.print("<h5> No Session tracking !!!! </h5>");
			
			// invalidate session
			session.invalidate();
			pw.print("<h5> You have been logged out ....</h5>");
			
					
			
		}catch(Exception e) {
			throw new ServletException("err in do-get "+getClass(),e);
			
		}
		
	}

}
