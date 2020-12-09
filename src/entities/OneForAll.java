package entities;



public class OneForAll extends Ability  {

	public OneForAll(){
		this.name = "One For All";
		this.isHeroic = true;
		this.description = "Otorga gran cantidad de fuerza y agilidad a cambio de un descenso de las demas estadisticas ";
	}
	
	public void refreshStats(Stats stats){
		stats.setAgility(stats.getAgility()*10);
		stats.setCritical(stats.getCritical()/3);
		stats.setDefense(stats.getDefense()/3);
		stats.setIntelligence(stats.getIntelligence()/3);
		stats.setStrength(stats.getStrength()*10);
		stats.setPhysical(stats.getPhysical()/3);
	}
	
	
	

}
