package entities;

public class ZeroGravity extends Ability {
	
	public ZeroGravity() {
		this.name = "Zero Gravity";
		this.isHeroic = true;
		this.description = "Otorga la capacidad de moverse en gravedad 0 si la agilidad del heroe es alta,otorgando aumento en agilidad y en critico.En otro caso, solo reduce la agilidad";
	}

	@Override
	public void refreshStats(Stats stats) {
		// TODO Auto-generated method stub
		if(stats.getAgility()>20) {
			stats.setAgility(stats.getAgility()*3);
			stats.setCritical(stats.getCritical()*3);
		}
		else
			stats.setAgility(stats.getAgility()/2);
	}

}
