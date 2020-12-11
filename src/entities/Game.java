package entities;
import java.util.ArrayList; 
import java.util.List;
public class Game {
	 public static List<Character> allCharacters = new ArrayList<Character>();
	 public static List<Team> allTeams = new ArrayList<>();

	
	public static void main(String[] args) {
	}
	
	public static Group fightByStat(Group g1, Group g2,String stat) {
		if(validSides(g1,g2) == false)
			return null;
		return resultFightByStat(g1,g2,stat);
	}
	
	public static Group  fight(Group g1,Group g2) {
		if(g1.getSide() == g2.getSide()) {
			System.out.println("No pueden luchar 2 equipos del mismo bando");
			return null;
		}
		int result = resultFight(g1,g2);
		System.out.println(g1.getFictionName() + " VS " + g2.getFictionName());
		
		if(result == 0) {
			System.out.println("Empate");
			return null;
			
		}
			
		if(result > 0) {
			System.out.println("Gana " + g1.getFictionName());
			return g1;
		}
			
		else {
			System.out.println("Gana " + g2.getFictionName());
			return g2;
		}
			
		
	}
	
	private static int resultFight(Group g1,Group g2) {
		
		int powerGroup1 = 0;
		int powerGroup2 = 0;
		
		powerGroup1 += (g1.getAGL()*2)-g2.getSTR();
		powerGroup1 += (g1.getSTR()*2)-g2.getCRT();
		powerGroup1 += (g1.getCRT()*2)-g2.getPHY();
		powerGroup1 += (g1.getPHY()*2)-g2.getDEF();
		powerGroup1 += (g1.getDEF()*2)-g2.getINT();
		powerGroup1 += (g1.getINT()*2)-g2.getAGL();
		
		powerGroup2 += (g2.getAGL()*2)-g1.getSTR();
		powerGroup2 += (g2.getSTR()*2)-g1.getCRT();
		powerGroup2 += (g2.getCRT()*2)-g1.getPHY();
		powerGroup2 += (g2.getPHY()*2)-g1.getDEF();
		powerGroup2 += (g2.getDEF()*2)-g1.getINT();
		powerGroup2 += (g2.getINT()*2)-g1.getAGL();
		return powerGroup1 - powerGroup2;
	}
	
	private static Group resultFightByStat(Group g1,Group g2,String stat) {
		String []statOrderVector = {"AGL","STR","CRT","PHY","DEF","INT"};
		int wrongString=1;
		for(String s : statOrderVector) {
			if(s.equals(stat)) {
				wrongString=0;
				break;
			}
				
		}
		if(wrongString == 1) {
			System.out.println("Error al ingresar un stat");
			return null;
		}
	
		
			int equal=1;
			int result=0;
			int powerGroup1;
			int powerGroup2;
			int i=0;
			String s = stat;
			
	
			while(equal == 1 && i<statOrderVector.length) {
				powerGroup1=0;
				powerGroup2=0;
				equal=0;
				result=0;
				switch(s) {
				case "AGL":
					powerGroup1 += (g1.getAGL()*2)-g2.getSTR();
					powerGroup2 += (g2.getAGL()*2)-g1.getSTR();
					result=(powerGroup1-powerGroup2);
					if(result == 0)
						equal=1;
					break;
				case "STR":
					powerGroup1 += (g1.getSTR()*2)-g2.getCRT();
					powerGroup2 += (g2.getSTR()*2)-g1.getCRT();
					result=(powerGroup1-powerGroup2);
					if(result == 0)
						equal=1;
					break;
				case "CRT":
					powerGroup1 += (g1.getCRT()*2)-g2.getPHY();
					powerGroup2 += (g2.getCRT()*2)-g1.getPHY();
					result=(powerGroup1-powerGroup2);
					if(result == 0)
						equal=1;
					break;
				case "PHY":
					powerGroup1 += (g1.getPHY()*2)-g2.getDEF();
					powerGroup2 += (g2.getPHY()*2)-g1.getDEF();
					result=(powerGroup1-powerGroup2);
					if(result == 0)
						equal=1;
					break;
				case "DEF":
					powerGroup1 += (g1.getDEF()*2)-g2.getINT();
					powerGroup2 += (g2.getDEF()*2)-g1.getINT();
					result=(powerGroup1-powerGroup2);
					if(result == 0)
						equal=1;
					break;
				case "INT":
					powerGroup1 += (g1.getINT()*2)-g2.getAGL();
					powerGroup2 += (g2.getINT()*2)-g1.getAGL();
					result=(powerGroup1-powerGroup2);
					if(result == 0)
						equal=1;
					break;
				}
				if(equal ==1) {
					s = statOrderVector[i];
					i++;
				}
			}
			if(result < 0) {
				System.out.println("Gana " + g2.getFictionName());
				return g2;
			}
				
			if(result > 0) {
				System.out.println("Gana " + g1.getFictionName());
				return g1;
			}
		
			return null;
	}
	
	public static List<Group> whoBeats(Character ch){
		List<Group>beatsCharacter = new ArrayList<>();
		System.out.println("Vencen a " + ch.getAka() +":");
		for(Character ch2 : Game.allCharacters) {
			if(resultFight(ch,ch2)<0)
				beatsCharacter.add(ch2);
		}
		
		for(Team t : Game.allTeams) {
			if(resultFight(ch,t)<0)
				beatsCharacter.add(t);
		}
		return beatsCharacter;
	}
	
	public static List<Group> whoBeatsByStat(Character ch,String stat){
		
		if(wrongStatSyntax(stat)==true)
			return null;
			
		List<Group>beatsCharacter = new ArrayList<>();
		System.out.println("Vencen a " + ch.getAka() +":");
		
		for(Character ch2 : Game.allCharacters) {
			if(resultFightByStat(ch,ch2,stat)==ch2)
				beatsCharacter.add(ch2);
			
		}
		for(Team t : Game.allTeams) {
			if(resultFightByStat(ch,t,stat)==t)
				beatsCharacter.add(t);
		}
		return beatsCharacter;
	}
	
	private static boolean wrongStatSyntax(String stat) {
		String []statOrderVector = {"AGL","STR","CRT","PHY","DEF","INT"};
		int wrongString=1;
		for(String s : statOrderVector) {
			if(s.equals(stat)) {
				wrongString=0;
				break;
			}
				
		}
		if(wrongString == 1) {
			System.out.println("Error al ingresar un stat");
			return true;
	
		}
		return false;
	}
	
	private static boolean validSides(Group g1, Group g2) {
		if(g1.getSide() == g2.getSide()) {
			System.out.println("No pueden luchar 2 equipos del mismo bando");
			return false;
		}
		return true;
	}
}
