package entities;

public class Transform extends Ability {

	public Transform() {
		this.name = "Transform";
		this.isHeroic = false;
		this.description = "Copia los atributos de un personaje al azar de la lista total de personajes";
	}
	@Override
	public void refreshStats(Stats stats) {
		int quantChars = Game.allCharacters.size()-1;
		int randomInt = (int) (Math.random()*(quantChars-0+1)+0);
		
		Character copyChar = Game.allCharacters.get(randomInt);
		
		this.name = "Transform-" + copyChar.getAka();
		
		stats.setAgility(copyChar.getAGL());
		stats.setCritical(copyChar.getCRT());
		stats.setDefense(copyChar.getDEF());
		stats.setIntelligence(copyChar.getINT());
		stats.setPhysical(copyChar.getPHY());
		stats.setStrength(copyChar.getSTR());
		
		
		
	}

}
