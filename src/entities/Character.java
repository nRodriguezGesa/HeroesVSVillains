package entities;


import java.util.*;


import entities.CharacterComparator.SortParameter;



public class Character implements Group{

	private String realName;
	private String aka;
	private Stats stats;
	private boolean isHero;
	private HashSet<Ability> abilities = new HashSet<>();
	
	public Character(String name, String aka, Stats stats, boolean isHero) {
		//FileMan fm = new FileMan("Characters.txt");
		if(canAddCharacter(aka)==false) {
			throw new IllegalArgumentException();
		}
		
		this.realName = name;
		this.aka = aka;
		this.stats = stats;
		this.isHero = isHero;
		Game.allCharacters.add(this);
		/*
		if(!fm.addCharacter(this)) {
			System.out.println("No se pudo agregar el personaje a la bdd");
		}
		*/
	}
	
	public static Comparator<Character> getComparator(SortParameter...sortParameters){
		return new CharacterComparator(sortParameters);
	} 
	
	
	public boolean canAddCharacter(String aka) {
		for(Character ch : Game.allCharacters) {
			if(ch.getAka().equals(aka))
				return false;
		}
		return true;
	}
	
	public boolean addAbility(Ability ability){
		int result = canAddAbility(ability);
		
		if(result== 0) {
			Game.allCharacters.remove(this);
			abilities.add(ability);
			ability.refreshStats(this.stats);
			Game.allCharacters.add(this);
			
			System.out.println("Se ha agregado la habilidad " + ability.getName() + " para el personaje "+ this.aka);
			return true;
		}
		else if(result == 1) {
			System.out.println("No se ha podido agregar la habilidad porque " + this.aka + " ya posee esta habilidad");
			return false;
		}
			
		else {
			System.out.println("No se ha podido agregar la habilidad porque " + this.aka + " no pertenece al mismo bando");
			return false;
		}
			
	}
	
	private int canAddAbility(Ability ability) {
		if(ability.getIsHeroic() != this.isHero)
			return 2;
		
		for(Ability ab : abilities) {
			if(ab.getName().equals(ability.getName()))
				return 1;
		}
		return 0;
	}

	/*
	public List<Character> sortCharacters() {
		Comparator<Character> cp = Character.getComparator(Character.SortParameter.AKA_DES);
		Collections.sort(Game.allCharacters,cp);
		return Game.allCharacters;
	}
	*/
	
	@Override
	public String toString() {
		return "\nCharacter [realName=" + realName + ", aka=" + aka + ", stats=" + stats.toString() + ", isHero=" + isHero
				+ ", abilities=" + abilities + "]";
	}

	
	@Override
	public boolean invalidAdd(Group group) {
		if(this.aka.equals(group.getFictionName()))
			return true;
		return false;
	}
	/*
	public static Comparator<Character> getComparator(SortParameter){
		return new CharacterComparator(sortParameters);
	}
	*/



	@Override
	public String getFictionName() {
		return this.aka;
	}

	@Override
	public List<Group> forEachCharacter() {
		List<Group> set = new ArrayList<>();
		set.add(this);
		return set;
	}


	@Override
	public boolean getSide() {
		// TODO Auto-generated method stub
		return this.isHero;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAka() {
		return aka;
	}

	public void setAka(String aka) {
		this.aka = aka;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public boolean isHero() {
		return isHero;
	}

	public void setHero(boolean isHero) {
		this.isHero = isHero;
	}

	public HashSet<Ability> getAbilities() {
		return abilities;
	}

	public void setAbilities(HashSet<Ability> abilities) {
		this.abilities = abilities;
	}

	@Override
	public int getAGL() {
		return this.stats.getAgility();
	}

	@Override
	public int getSTR() {
		// TODO Auto-generated method stub
		return this.stats.getStrength();
	}

	@Override
	public int getCRT() {
		// TODO Auto-generated method stub
		return this.stats.getCritical();
	}

	@Override
	public int getPHY() {
		// TODO Auto-generated method stub
		return this.stats.getPhysical();
	}

	@Override
	public int getDEF() {
		// TODO Auto-generated method stub
		return this.stats.getDefense();
	}

	@Override
	public int getINT() {
		// TODO Auto-generated method stub
		return this.stats.getIntelligence();
	}

	@Override
	public List<Character> sortByCriteria(Comparator<Character> cp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Character> obtainCharacters() {
		List<Character> chars = new ArrayList<>();
		chars.add(this);
		return chars;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int countCharacters() {
		// TODO Auto-generated method stub
		return 1;
	}

	
	

	
	

}
