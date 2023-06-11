package Dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;

public interface CandidateDao {
	
	// add a method to get candidate details
	List<Candidate> getAllCandidates() throws SQLException;
	
	// add a method to increment chosen candidate votes
	
	String incremenetCandidateVotes(int candidateid) throws SQLException;

}
