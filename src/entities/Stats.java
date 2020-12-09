package entities;

import java.io.Serializable;

public class Stats  {

	private int agility;
	private int strength;
	private int critical;
	private int physical;
	private int defense;
	private int intelligence;
	
	public Stats(int a, int s, int c, int p, int d, int i){
		this.strength = s;
		this.agility = a;
		this.intelligence = i;
		this.defense = d;
		this.physical = p;
		this.critical = c;
		
	}
	

	

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligente) {
		this.intelligence = intelligente;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getPhysical() {
		return physical;
	}

	public void setPhysical(int physical) {
		this.physical = physical;
	}

	public int getCritical() {
		return critical;
	}

	public void setCritical(int critical) {
		this.critical = critical;
	}




	@Override
	public String toString() {
		return "Stats [agility=" + agility + ", strength=" + strength + ", critical=" + critical + ", physical="
				+ physical + ", defense=" + defense + ", intelligence=" + intelligence + "]";
	}


	
	

}
