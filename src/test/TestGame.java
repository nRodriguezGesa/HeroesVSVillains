package test;
import static org.junit.Assert.assertThrows; 
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.*;
import org.junit.jupiter.api.Test;

import entities.*;

import entities.Character;
import entities.Game;
import junit.framework.Assert;

public class TestGame {
	
	@Test
	public void testFightCharacterOKWinner() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Fumikage Tokoyami","Jet-Black",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("Himiko Toga","Toga",new Stats(2,20,2,1,5,50),false);
		Character char6 = new Character("Shigaraki","All for One",new Stats(1,1,1,1,1,1),false);
		Character char7 = new Character("Toya Todoroki","Creamtion",new Stats(5,10,50,12,22,5),false);
		Character char8 = new Character("Shigaraki","XD",new Stats(50,50,20,15,15,25),false);
		Team team1 = new Team("Besto Team",false);
		Team team2 = new Team("Worst Team",true);
		
		Assert.assertEquals(char2,Game.fight(char6, char2));
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test
	public void testFightCharacterOKDraw() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(1,1,1,1,1,1),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Fumikage Tokoyami","Jet-Black",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("Himiko Toga","Toga",new Stats(2,20,2,1,5,50),false);
		Character char6 = new Character("Shigaraki","All for One",new Stats(1,1,1,1,1,1),false);
		Character char7 = new Character("Toya Todoroki","Creamtion",new Stats(5,10,50,12,22,5),false);
		Character char8 = new Character("Shigaraki","XD",new Stats(50,50,20,15,15,25),false);
		Team team1 = new Team("Besto Team",false);
		Team team2 = new Team("Worst Team",true);
		
		Assert.assertEquals(null,Game.fight(char1, char6));
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test
	public void testFightCharacterERRORSameSide() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Fumikage Tokoyami","Jet-Black",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("Himiko Toga","Toga",new Stats(2,20,2,1,5,50),false);
		Character char6 = new Character("Shigaraki","All for One",new Stats(1,1,1,1,1,1),false);
		Character char7 = new Character("Toya Todoroki","Creamtion",new Stats(5,10,50,12,22,5),false);
		Character char8 = new Character("Shigaraki","XD",new Stats(50,50,20,15,15,25),false);
		Team team1 = new Team("Besto Team",false);
		Team team2 = new Team("Worst Team",true);
		
		Assert.assertEquals(null,Game.fight(char1, char2));
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test
	public void testFightTeamOK() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Fumikage Tokoyami","Jet-Black",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("Himiko Toga","Toga",new Stats(2,20,2,1,5,50),false);
		Character char6 = new Character("Shigaraki","All for One",new Stats(1,1,1,1,1,1),false);
		Character char7 = new Character("Toya Todoroki","Creamtion",new Stats(5,10,50,12,22,5),false);
		Character char8 = new Character("Shigaraki","XD",new Stats(50,50,20,15,15,25),false);
		Team team1 = new Team("Besto Team",true);
		Team team2 = new Team("Worst Team",false);
		
		team1.addGroup(char1);
		team1.addGroup(char2);
		team2.addGroup(char6);
		
		Assert.assertEquals(team1,Game.fight(team1, team2));
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test
	public void testFightTeamVSCharOK() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Fumikage Tokoyami","Jet-Black",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("Himiko Toga","Toga",new Stats(1,1,1,1,1,1),false);
		Character char6 = new Character("Shigaraki","All for One",new Stats(1,1,1,1,1,1),false);
		Character char7 = new Character("Toya Todoroki","Creamtion",new Stats(5,10,50,12,22,5),false);
		Character char8 = new Character("Shigaraki","XD",new Stats(50,50,20,15,15,25),false);
		Team team1 = new Team("Besto Team",true);
		Team team2 = new Team("Worst Team",false);
		
		
		team2.addGroup(char6);
		team2.addGroup(char5);
		
		Assert.assertEquals(char2,Game.fight(char2, team2));
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	
	
	@Test
	public void testFightCharacterByStatOK() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Fumikage Tokoyami","Jet-Black",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("Himiko Toga","Toga",new Stats(2,20,2,1,5,50),false);
		Character char6 = new Character("Shigaraki","All for One",new Stats(1,1,1,1,1,1),false);
		Character char7 = new Character("Toya Todoroki","Creamtion",new Stats(5,10,50,12,22,5),false);
		Character char8 = new Character("Shigaraki","XD",new Stats(50,50,20,15,15,25),false);
		Team team1 = new Team("Besto Team",false);
		Team team2 = new Team("Worst Team",true);
		
		Assert.assertEquals(char2,Game.fightByStat(char2, char6,"AGL"));
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test
	public void testFightCharacterByStatOKDefault() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(5,5,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Fumikage Tokoyami","Jet-Black",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("Himiko Toga","Toga",new Stats(2,20,2,1,5,50),false);
		Character char6 = new Character("Shigaraki","All for One",new Stats(5,5,1,1,1,1),false);
		Character char7 = new Character("Toya Todoroki","Creamtion",new Stats(5,10,50,12,22,5),false);
		Character char8 = new Character("Shigaraki","XD",new Stats(50,50,20,15,15,25),false);
		Team team1 = new Team("Besto Team",false);
		Team team2 = new Team("Worst Team",true);
		
		Assert.assertEquals(char2,Game.fightByStat(char2, char6,"AGL"));
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test
	public void testFightCharacterByStatOKDraw() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(1,1,1,1,1,1),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Fumikage Tokoyami","Jet-Black",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("Himiko Toga","Toga",new Stats(2,20,2,1,5,50),false);
		Character char6 = new Character("Shigaraki","All for One",new Stats(1,1,1,1,1,1),false);
		Character char7 = new Character("Toya Todoroki","Creamtion",new Stats(5,10,50,12,22,5),false);
		Character char8 = new Character("Shigaraki","XD",new Stats(50,50,20,15,15,25),false);
		Team team1 = new Team("Besto Team",false);
		Team team2 = new Team("Worst Team",true);
		
		Assert.assertEquals(null,Game.fightByStat(char2, char6,"AGL"));
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test
	public void testFightCharacterByStatERRORSameSide() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char6 = new Character("Shigaraki","All for One",new Stats(1,1,1,1,1,1),true);
		Team team1 = new Team("Besto Team",false);
		Team team2 = new Team("Worst Team",true);
		
		Assert.assertEquals(null,Game.fightByStat(char1, char6,"AGL"));
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	

	@Test
	public void testFightCharacterByStatERRORWrongStatInput() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char6 = new Character("Shigaraki","All for One",new Stats(1,1,1,1,1,1),false);
		Team team1 = new Team("Besto Team",false);
		Team team2 = new Team("Worst Team",true);
		
		Assert.assertEquals(null,Game.fightByStat(char1, char6,"Banana"));
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test
	public void testWhoBeatsOK() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(1,1,1,1,1,1),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(100,100,150,50,50,100),true);
		Character char4 = new Character("Fumikage Tokoyami","Jet-Black",new Stats(60,150,150,250,250,100),true);
		
		Team team1 = new Team("Besto Team",true);
		team1.addGroup(char2);
		team1.addGroup(char3);
		team1.addGroup(char4);
		
		List<Group> beatsCharacter = new ArrayList<Group>();
		List<Group> result = new ArrayList<Group>();
		beatsCharacter.add(char3);
		beatsCharacter.add(char4);
		beatsCharacter.add(team1);
		
		result = Game.whoBeats(char1);
		Assert.assertEquals(true,result.containsAll(beatsCharacter));
		//System.out.println(result);
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test
	public void testWhoBeatsEmpty() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10000,20000,10000,50000,50000,50000),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(1,1,1,1,1,1),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(100,100,150,50,50,100),true);
		Character char4 = new Character("Fumikage Tokoyami","Jet-Black",new Stats(60,150,150,250,250,100),true);
		
		Team team1 = new Team("Besto Team",true);
		team1.addGroup(char2);
		team1.addGroup(char3);
		team1.addGroup(char4);
		
		List<Group> result = new ArrayList<Group>();
		
		result = Game.whoBeats(char1);
		System.out.println(result);
		Assert.assertEquals(true,result.isEmpty());
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}


}
