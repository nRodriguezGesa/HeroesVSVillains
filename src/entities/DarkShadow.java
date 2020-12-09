package entities;

public class DarkShadow extends Ability {

	public DarkShadow() {
		this.name = "Dark Shadow";
		this.isHeroic = true;
		this.description = "Otorga un aumento en todos los atributos si la defensa del personaje es alta, en otro caso"
				+ "se descontrola y todas sus estadisticas pasan a 1";
	}
	@Override
	public void refreshStats(Stats stats) {
		if(stats.getDefense()> 30) {
			stats.setAgility(stats.getAgility()*3);
			stats.setCritical(stats.getCritical()*3);
			stats.setDefense(stats.getDefense()*3);
			stats.setIntelligence(stats.getIntelligence()*3);
			stats.setStrength(stats.getStrength()*3);
			stats.setPhysical(stats.getPhysical()*3);
		}
		else {
			stats.setAgility(1);
			stats.setCritical(1);
			stats.setDefense(1);
			stats.setIntelligence(1);
			stats.setStrength(1);
			stats.setPhysical(1);
		}
		
	}

}
