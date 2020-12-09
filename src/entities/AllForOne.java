package entities;

import java.util.HashSet;

public class AllForOne extends Ability {
	
	public AllForOne() {
		this.name = "All for One";
		this.isHeroic = false;
		this.description = "Roba las habilidades de todos los personajes del juego";
	}

	@Override
	public void refreshStats(Stats stats) {
		int flag=0;
		HashSet<Ability> ab;
		for(Character ch : Game.allCharacters) {
			ab = ch.getAbilities();
			for(Ability a : ab) {
				if(a.getName().equals("All for One")) {
					flag=1;
				}
					
			}
			if(flag==0) {
				stats.setAgility(stats.getAgility()+ch.getAGL());
				stats.setStrength(stats.getStrength()+ch.getSTR());
				stats.setIntelligence(stats.getIntelligence()+ch.getINT());
				stats.setDefense(stats.getDefense()+ch.getDEF());
				stats.setCritical(stats.getCritical()+ch.getCRT());
				stats.setPhysical(stats.getPhysical()+ch.getPHY());
			}
			
		}
		
	}

}
