package entities;

public abstract class Ability  {

	protected String name;
	protected String description;
	protected boolean isHeroic;
	
	public abstract void refreshStats(Stats stats);
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getIsHeroic() {
		return this.isHeroic;
	}

	@Override
	public String toString() {
		return "Ability [name=" + name + ", description=" + description + ", isHeroic=" + isHeroic + "]";
	}
	
	
	
	
	
}
