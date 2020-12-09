package entities;
import java.util.ArrayList;  
import java.util.Comparator;
import java.util.List;




public class Game {
	 public static List<Character> allCharacters = new ArrayList<Character>();
	public static List<Team> allTeams = new ArrayList<>();

	
	public static void main(String[] args) {
	
		Comparator<Character> cp;


		
		
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Fumikage Tokoyami","Jet-Black",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("Himiko Toga","Toga",new Stats(2,20,2,1,5,50),false);
		Character char6 = new Character("Shigaraki","All for One",new Stats(1,1,1,1,1,1),false);
		Character char7 = new Character("Toya Todoroki","Creamtion",new Stats(5,10,50,12,22,5),false);
		Character char8 = new Character("Shigaraki","XD",new Stats(50,50,20,15,15,25),false);
		//char6.addAbility(new AllForOne());
		//System.out.println(char6);
		
		fightByStat(char2, char8, "STR");
		//char5.addAbility(new Transform());
		//System.out.println(char5);
		//System.out.println(char1.toString());
		
		//showAllCharacters();
		
		//fight(char1,char4);
		
		//char1.addAbility(new OneForAll());
		//showAllCharacters();
		
		

		
		//Team teamVillains = new Team("Villains League",false);
		
		Team team1 = new Team("Besto Team",true);
		Team team2 = new Team("UA",true);
		Team team3 = new Team("Test",true);
		//Team team4 = new Team("Besto Team",false);
		
		
		//team3.addGroup(char2);
		//team3.addGroup(char4);
		
		
		
		//team1.addGroup(char1);
		//team1.addGroup(char2);
		
		//System.out.println(whoBeats(char1));
		
		//fight(team3,team1);
		
		
		//se me agregan 2 teams iguales virgo de mierda
		
		
		//team2.addGroup(char3);
		//team2.addGroup(team1);
		//team2.addGroup(char1);
		//System.out.println(allTeams);
		//team2.addGroup(team3);
		//team2.addGroup(char4);
		//team2.addGroup(team1);
		//System.out.println(team2.toString());
		
		//cp = Character.getComparator(Character.SortParameter.AKA_ASC);
		//Character charAux = new Character("Ochaco Uraraka","Zuravity",new Stats(3,10,15,5,5,0),true);
		//team2.addGroup(charAux);
		//cp = Character.getComparator(CharacterComparator.SortParameter.NAME_DES);
		//System.out.println(team2.sortByCriteria(cp));
		
		
		//teamVillains.addGroup(char5);
		//teamVillains.addGroup(char1);
		
		
		//System.out.println(Game.allTeams);
		
		//fillStatMatrix(statMatrix);
		//showStatMatrix(statMatrix);
		
		
	
		
		//System.out.println(team1.teamToString());
		
		//System.out.println(team2.teamToString());
		
		//System.out.println(teamVillains.teamToString());
		
		//System.out.println(char1.toString());
		
		//char1.addAbility(new OneForAll());
		
		//System.out.println(char1.toString());
		
		//char1.addAbility(new OneForAll());
		

	}
	
	//public hashSet<Character> whoBeats(Character ch){
		
	//}
	
	
	public static Group fightByStat(Group g1, Group g2,String stat) {
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
		if(g1.getSide() == g2.getSide()) {
			System.out.println("No pueden luchar 2 equipos del mismo bando");
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
				
			if(result==0) {
				System.out.println("Empate");
				return null;
			}
			return null;
				
			
		
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
	
	

}
