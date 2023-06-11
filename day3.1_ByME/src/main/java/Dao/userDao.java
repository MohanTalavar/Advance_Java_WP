package Dao;

import java.sql.SQLException;

import pojos.User;

public interface userDao {
	
	// add authenticate metod 
	
	User authenticateUser(String email, String password) throws SQLException;
	
	// add update voting status method 
	
	
	String updateVotingStatus(int voterId) throws SQLException;
	

}
