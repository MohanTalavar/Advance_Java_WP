package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CandidateDaoImpl;
import pojos.Candidate;
import pojos.User;

/**
 * Servlet implementation class CandidateList
 */
@WebServlet("/CandidateList")
public class CandidateList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		try( PrintWriter pw = response.getWriter()){
			
			pw.print("<h5> In candidate list page </h5>");
			
			// get session from wc
			
			HttpSession session = request.getSession();
			
			System.out.println("is new ?" +session.isNew()); // false
			System.out.println("session id: " +session.getId());
			
			// get user details from scope 
			
			User userDetails = (User) session.getAttribute("user_details");
			if(userDetails!=null) {
				
				// session valid
				
				pw.print("<h5> Hello , " + userDetails.getFirstName()+ " "+ userDetails.getLastName()+"</h5>");
				
				CandidateDaoImpl dao = (CandidateDaoImpl) session.getAttribute("candidate_dao");
				
				List<Candidate> candidateList = dao.getAllCandidates();
				
				// dynamic form gneration 
				
				pw.print("<from action='logout'>");
				
				for(Candidate c: candidateList)
					pw.print("<h5> <input type='radio' name='cid' value='' " + c.getCandidateid()+ " " +c.getName() + "</h5>");
					pw.print("<h5> <input type='submit' value='Cast a vote'/> </h5>");
					pw.print("</form>");	
			}
			else {
				pw.print("<h5> Session Tracking Failed, No Cookies!!! </h5>");
			}
			
		}catch(Exception e) {
			throw new ServletException( "err in do-get:"+ getClass(),e );
			
		}
		
	}

}
