package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static utils.dbUtils.*;

import pojos.User;

public class userDaoImpl implements userDao{
	
	private Connection cn;
	private PreparedStatement pst1,pst2;
	
	//=======================================================
	
	public userDaoImpl() throws SQLException {
		
		cn= openConnection();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		pst2 = cn.prepareStatement("update users set status=1 where id=?");
		System.out.println("user dao created");
		
		
	}
 
	//========================================================
	
	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		
		pst1.setString(1, email);
		pst2.setString(2, password);
		
		try( ResultSet rst=pst1.executeQuery()){
			if(rst.next()) // => success
				return new User( rst.getInt(1), rst.getString(2), rst.getString(3), email, password,
						rst.getDate(6), rst.getBoolean(7) ,rst.getString(8));
		
		}
		return null;
	}

	//=========================================================
	
	@Override
	public String updateVotingStatus(int voterId) throws SQLException {
		
		pst2.setInt(1, voterId);
		
		int updateCount=pst2.executeUpdate();
		if(updateCount==1)
			return "Updated voting status";
		return "Updation failed!!!!";
		
	}
	
	//==========================================================

	public void cleanUp() throws SQLException {
		if(pst1!=null)
			pst1.close();
		if(pst2!=null)
			pst2.close();
		closeConnection();
		System.out.println("user dao cleaned Up!");
		
	}
	
	
	
}
