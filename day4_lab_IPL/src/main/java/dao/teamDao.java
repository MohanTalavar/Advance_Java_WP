package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Team;

public interface teamDao {

	List<Team> getAllTeamDetails() throws SQLException;
}
