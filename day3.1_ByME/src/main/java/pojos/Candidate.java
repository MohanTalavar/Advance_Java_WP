package pojos;

// id | name    | party    | votes

public class Candidate {
	
	private int Candidateid;
	private String name;
	private String party;
	private int votes;
	
	public Candidate() {
		
	}
	
	
	
	

	public Candidate(int candidateid, String name, String party, int votes) {
		super();
		Candidateid = candidateid;
		this.name = name;
		this.party = party;
		this.votes = votes;
	}





	public int getCandidateid() {
		return Candidateid;
	}

	public void setCandidateid(int candidateid) {
		Candidateid = candidateid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Candidate [Candidateid=" + Candidateid + ", name=" + name + ", party=" + party + ", votes=" + votes
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	

} // end of class
