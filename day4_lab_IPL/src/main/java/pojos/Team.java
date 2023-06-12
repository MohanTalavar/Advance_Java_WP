package pojos;

//team_id | name  | abbrevation | owner  | max_age | batting_avg | wickets_taken

public class Team {
	
	private int teamId;
	private String name;
	private String abbrevation;
	private String owner;
	private int maxAge;
	private int minbattingAvg;
	private int minwicketsTaken;
	
	public Team() {
		
	}
	
	
	
	

	public Team(int teamId, String name, String abbrevation, String owner, int maxAge, int minbattingAvg,
			int minwicketsTaken) {
		super();
		this.teamId = teamId;
		this.name = name;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minbattingAvg = minbattingAvg;
		this.minwicketsTaken = minwicketsTaken;
	}

	
	




	public Team(int teamId, String abbrevation) {
		super();
		this.teamId = teamId;
		this.abbrevation = abbrevation;
	}





	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", abbrevation=" + abbrevation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", minbattingAvg=" + minbattingAvg + ", minwicketsTaken=" + minwicketsTaken + "]";
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbrevation() {
		return abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public int getminbattingAvg() {
		return minbattingAvg;
	}

	public void setminbattingAvg(int minbattingAvg) {
		this.minbattingAvg = minbattingAvg;
	}

	public int getminwicketsTaken() {
		return minwicketsTaken;
	}

	public void setminwicketsTaken(int minwicketsTaken) {
		this.minwicketsTaken = minwicketsTaken;
	}
	
	
	

}
