package Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import static utils.dbUtils.*;

import pojos.Candidate;

public class CandidateDaoImpl implements CandidateDao {
	
	private Connection cn;
	private PreparedStatement pst1,pst2;
	
	//==========================================================
	
	public CandidateDaoImpl() throws SQLException {
		
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from candidates");
		pst2 = cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		System.out.println("candidate dao created");
		
	}
	
	//===========================================================

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		
		List<Candidate> candidates = new ArrayList<>();
		
		try(ResultSet rst=pst1.executeQuery()){
			while(rst.next())
				candidates.add(new Candidate( rst.getInt(1),rst.getString(2), rst.getString(3),rst.getInt(4) ));		
		}
		
		return candidates;
	}
	
	//=================================================

	public void cleanUp() throws SQLException{
		if(pst1!=null)
			pst1.close();
		if(pst2!=null)
			pst2.close();
		closeConnection();
		System.out.println("candidate dao cleaned up");
	}
	
	//===============================================================
	
	@Override
	public String incremenetCandidateVotes(int candidateid) throws SQLException {
		
		pst2.setInt(1, candidateid);
		int updateCount=pst2.executeUpdate();
		if(updateCount==1)
			return "Updated votes counts..";
		return "Updation of votes failed!!!!!";
	}
	
	//================================================
	

}
