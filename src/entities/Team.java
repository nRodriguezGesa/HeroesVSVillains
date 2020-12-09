package entities;

import java.util.*;

public class Team implements Group {

	private String name;
	private List<Group> team = new ArrayList<Group>();
	private boolean isHeroic;

	public Team(String name, boolean isHeroic) {
		for(Team t : Game.allTeams) {
			if(t.getFictionName().equals(name))
				throw new IllegalArgumentException();
		}
		this.name = name;
		this.isHeroic = isHeroic;
		Game.allTeams.add(this);
	}

	public void addGroup(Group group) {
		if (invalidAdd(group) == false)
			team.add(group);
			refreshAllTeams();
			//this.teamCharactersToString(group);
		
	}
	// TEAM1 : A B C F
	//TEAM2 : D E TEAM1
	//TEAM1.ADD(F);
	private void refreshAllTeams() {
		for(int i = 0; i<Game.allTeams.size();i++) {
			if(Game.allTeams.get(i).getFictionName().equals(this.name)) {
				Game.allTeams.set(i,this);
			}
		}
	}
	
	@Override
	public String getFictionName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getTeamSize() {
		return this.team.size();
	}
	


	public String teamToString() {
		String line = "";
		line = this.name;
		line = line.concat("\n");
		if(this.isHeroic==true)
			line = line.concat("Heroes");
		else
			line = line.concat("Villains");
		for (Group group : team) {
			line = line.concat(group.toString());
			line = line.concat("\n");
		}
		return line;

	}

	@Override
	public String toString() {
		return "\nTeam [name=" + name + ", team=" + "\n" + team + ", isHeroic=" + isHeroic + "\n]";
	}

	@Override
	public  boolean invalidAdd(Group group) {
		if(this.name.equals(group.getFictionName()) || this.isHeroic != group.getSide()|| group.isEmpty() == true)
			return true;
		
		List<Group>auxTeam = group.forEachCharacter();
		
		for(Group el : team) {
			for(Group el2: auxTeam) {
				if(el.invalidAdd(el2)==true)
					return true;
			}
		}
		return false;
	}

	@Override
	public List<Group> forEachCharacter() {
		List<Group>auxTeam = new ArrayList<>();
		
		auxTeam.addAll(this.team);
		return auxTeam;
	}



	@Override
	public boolean getSide() {
		return this.isHeroic;
	}



	@Override
	public int getAGL() {
		int totalAGL = 0;
		
		for(Group g : this.team) {
			totalAGL+= g.getAGL();
		}
		return totalAGL;
	}

	@Override
	public int getSTR() {
		int totalSTR=0;
		
		for(Group g : this.team) {
			totalSTR+=g.getSTR();
		}
		return totalSTR;
	}

	@Override
	public int getCRT() {
		// TODO Auto-generated method stub
		int totalCRT = 0;
		
		for(Group g : this.team) {
			totalCRT+= g.getCRT();
		}
		
		return totalCRT;
	}

	@Override
	public int getPHY() {
		// TODO Auto-generated method stub
		int totalPHY = 0;
		for(Group g : this.team) {
			totalPHY+=g.getPHY();
		}
		return totalPHY;
	}

	@Override
	public int getDEF() {
		// TODO Auto-generated method stub
		int totalDEF=0;
		for(Group g : this.team) {
			totalDEF+=g.getDEF();
		}
		return totalDEF;
	}

	@Override
	public int getINT() {
		// TODO Auto-generated method stub
		int totalINT=0;
		for(Group g : this.team) {
			totalINT+=g.getINT();
		}
		return totalINT;
	}

	@Override
	public List<Character> sortByCriteria(Comparator<Character>cp) {
		List<Character> chars = this.obtainCharacters();
		Collections.sort(chars,cp);
		return chars;
	}

	@Override
	public List<Character> obtainCharacters() {
		List<Character> chars = new ArrayList<>();
		
		for(Group g : this.team) {
			chars.addAll(g.obtainCharacters());
		}
		return chars;
	}

	@Override
	public boolean isEmpty() {
		return this.team.isEmpty();
	}

	@Override
	public int countCharacters() {
		int counter=0;
		
		for(Group g : this.team) {
			counter+=g.countCharacters();
		}
		return counter;
	}


}
