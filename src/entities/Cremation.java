package entities;

public class Cremation extends Ability{

	public Cremation() {
		this.name = "Cremation";
		this.description = "Habilidad para crear fuego, aumenta la inteligencia pero reduce la defensa";
		this.isHeroic = false;
	}
	@Override
	public void refreshStats(Stats stats) {
		stats.setIntelligence(stats.getIntelligence()*5);
		stats.setDefense(stats.getDefense()/2);
		
	}

}
