package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Team;
import Utils.dbUtils;

import static Utils.dbUtils.*;

public class teamDaoImpl implements teamDao{
	
	private Connection cn;
	private PreparedStatement pst1;
	
	//========================================
	
	public teamDaoImpl() throws SQLException {
		
		cn = openConnection();
		pst1 = cn.prepareStatement("select team_id, abbrevation from teams ");
		System.out.println("Team dao created");
		
	}
	
	//=========================================
	
	@Override
	public List<Team> getAllTeamDetails() throws SQLException {
		
		List<Team> teams = new ArrayList<>();
		
		try(ResultSet rst= pst1.executeQuery()){
			
			while(rst.next())
				teams.add(new Team(rst.getInt(1), rst.getString(2)));
		}	
		return teams;
	}
	
	//=========================================================
	
	public void cleanUp() throws SQLException{
		
		if(pst1!=null)
			pst1.close();
		closeConnection();
		System.out.println("team dao cleaned up!");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
