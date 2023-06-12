package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.teamDaoImpl;
import pojos.Team;

/**
 * Servlet implementation class teamList
 */
@WebServlet("/teamList")
public class teamList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private teamDaoImpl teamDao;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		try( PrintWriter pw = response.getWriter()){
			
			List<Team> teams = teamDao.getAllTeamDetails();
			
			//dynamic form generation
			
			pw.print("<form action='process_form'>");
			pw.print("<h5>  Choose a team </h5>");
			pw.print("<select name='team_id'>");
			for(Team t: teams) {
				pw.print("<option value=' " + t.getTeamId()+" '>" +t.getAbbrevation()+ "</option>");
			}
			pw.print("</select> </h5>");
			
			pw.print("<h5> PlayerName ");
			pw.print("<input type='text' name='full_name'/> </h5>");
			
			pw.print("<h5> Date of Birth: ");
			pw.print("<input type='date' name='dob' /></h5>");
			
			pw.print("<h5> Batting Average: ");
			pw.print("<input type='number' name='avg'/> </h5>");
			
			pw.print("<h5> Wickets Taken");
			pw.print("<input type='number' name='wickets'/></h5>");
			pw.print("<h5> <input type='submit' value='Add Player'/></h5");
			pw.print("</form>");
			
			
		}catch(Exception e) {
			throw new ServletException("err in teamlist servlet" + getClass(),e);
		}
		
	}
	
	//=================================================

	@Override
	public void destroy() {
		
		try {
			teamDao.cleanUp();
			
		}catch(Exception e) {
			System.out.println("err in destroy of " + getClass()+ " " + e);
		}
		
	}

	//========================================================
	
	@Override
	public void init() throws ServletException {
		
		try {
			
			teamDao = new teamDaoImpl();
			
		}catch(Exception e) {
			throw new ServletException("err in init " + getClass(),e);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
