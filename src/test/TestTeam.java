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
import entities.CharacterComparator;
import junit.framework.Assert;

public class TestTeam {
	
	@Test
	public void testCreateTeamOK() {
		Team team1 = new Team("Besto Team",true);
		Team team2 = new Team("Worst Team",true);
		Assert.assertEquals(2,Game.allTeams.size());
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	/*
	@Test
	public void testCreateTeamErrorSameName() {
		Team team1 = new Team("Besto Team",true);
		Team team2 = new Team("Besto Team",true);
		//no se hacer test de exceptions
	}
	*/
	@Test
	public void testAddGroupCharacterOK() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Fumikage Tokoyami","Jet-Black",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("Himiko Toga","Toga",new Stats(2,20,2,1,5,50),false);
		Character char6 = new Character("Shigaraki","All for One",new Stats(1,1,1,1,1,1),false);
		Character char7 = new Character("Toya Todoroki","Creamtion",new Stats(5,10,50,12,22,5),false);
		Character char8 = new Character("Shigaraki","XD",new Stats(50,50,20,15,15,25),false);
		
		Team team1 = new Team("Besto Team",true);
		
		team1.addGroup(char1);
		//System.out.println(team1);
		//System.out.println(Game.allTeams);
		for(Team t : Game.allTeams) {
			if(t.getFictionName().equals(team1.getFictionName())) {
				Assert.assertEquals(team1.toString(),t.toString());
			}
		}
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test 
	public void testAddGroupCharacterERRORDistinctSide() {
		Character char5 = new Character("Himiko Toga","Toga",new Stats(2,20,2,1,5,50),false);
		Team team1 = new Team("Besto Team",true);
		team1.addGroup(char5);
		Assert.assertEquals(0,team1.getTeamSize());
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test
	public void testAddGroupTeamOK() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Fumikage Tokoyami","Jet-Black",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("Himiko Toga","Toga",new Stats(2,20,2,1,5,50),false);
		Character char6 = new Character("Shigaraki","All for One",new Stats(1,1,1,1,1,1),false);
		Character char7 = new Character("Toya Todoroki","Creamtion",new Stats(5,10,50,12,22,5),false);
		Character char8 = new Character("Shigaraki","XD",new Stats(50,50,20,15,15,25),false);
		Team team1 = new Team("Besto Team",true);
		Team team2 = new Team("Worst Team",true);
		
		team1.addGroup(char1);
		team1.addGroup(char2);
		team2.addGroup(char3);
		team2.addGroup(team1);
		
		Assert.assertEquals(3,team2.countCharacters());
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test
	public void testAddGroupTeamERRORDistinctSide() {
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
		
		team1.addGroup(char1);
		team1.addGroup(char2);
		team2.addGroup(char3);
		team2.addGroup(team1);
		
		Assert.assertEquals(1,team2.countCharacters());
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test 
	public void testAddGroupTeamERRORSameCharacter() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Fumikage Tokoyami","Jet-Black",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("Himiko Toga","Toga",new Stats(2,20,2,1,5,50),false);
		Character char6 = new Character("Shigaraki","All for One",new Stats(1,1,1,1,1,1),false);
		Character char7 = new Character("Toya Todoroki","Creamtion",new Stats(5,10,50,12,22,5),false);
		Character char8 = new Character("Shigaraki","XD",new Stats(50,50,20,15,15,25),false);
		Team team1 = new Team("Besto Team",true);
		Team team2 = new Team("Worst Team",true);
		
		team1.addGroup(char1);
		team1.addGroup(char2);
		team2.addGroup(char1);
		team2.addGroup(team1);
		//System.out.println(team2);
		
		Assert.assertEquals(1,team2.countCharacters());
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test
	public void testAddGroupTeamERROREmptyTeam() {
		Team team1 = new Team("Besto Team",true);
		Team team2 = new Team("Worst Team",true);
		
		team1.addGroup(team2);
		//System.out.println(team2);
		Assert.assertEquals(0,team1.getTeamSize());
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test public void testSortByCriteriaDifferentFields() {
		Character char1 = new Character("Izuku Midoriya","A",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","B",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","C",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Fumikage Tokoyami","D",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("Himiko Toga","Toga",new Stats(2,20,2,1,5,50),false);
		Character char6 = new Character("Shigaraki","All for One",new Stats(1,1,1,1,1,1),false);
		Character char7 = new Character("Toya Todoroki","Creamtion",new Stats(5,10,50,12,22,5),false);
		Character char8 = new Character("Shigaraki","XD",new Stats(50,50,20,15,15,25),false);
		Team team1 = new Team("Besto Team",true);
		Team team2 = new Team("Worst Team",true);
		List<Character> list1 = new ArrayList<Character>();
		List<Character> list2 = new ArrayList<Character>();
		
		list1.add(char1);
		list1.add(char2);
		list1.add(char3);
		list1.add(char4);
		
		team1.addGroup(char2);
		team1.addGroup(char3);
		team1.addGroup(char1);
		team1.addGroup(char4);
		
		
		Comparator<Character > cp = Character.getComparator(CharacterComparator.SortParameter.AKA_DES);
		
		
		list2 = team1.sortByCriteria(cp);
		Assert.assertEquals(list1,list2);
		
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test 
	public void testSortByMultipleCriteria() {
		Character char1 = new Character("A","A",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("A","B",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("A","C",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("B","D",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("C","E",new Stats(2,20,2,1,5,50),true);
		Character char6 = new Character("C","F",new Stats(1,1,1,1,1,1),true);
		Character char7 = new Character("C","G",new Stats(5,10,50,12,22,5),true);
		Character char8 = new Character("D","H",new Stats(50,50,20,15,15,25),true);
		
		Team team1 = new Team("Besto Team",true);
		List<Character> list1 = new ArrayList<Character>();
		List<Character> list2 = new ArrayList<Character>();
		
		list1.add(char1);
		list1.add(char2);
		list1.add(char3);
		list1.add(char4);
		list1.add(char5);
		list1.add(char6);
		list1.add(char7);
		list1.add(char8);
		
		team1.addGroup(char2);
		team1.addGroup(char3);
		team1.addGroup(char7);
		team1.addGroup(char8);
		team1.addGroup(char1);
		team1.addGroup(char4);
		team1.addGroup(char5);
		team1.addGroup(char6);
		
		
		
		Comparator<Character > cp = Character.getComparator(CharacterComparator.SortParameter.NAME_DES,CharacterComparator.SortParameter.AKA_DES);
		
		
		list2 = team1.sortByCriteria(cp);
		//System.out.println(list1);
		//System.out.println(team1);
		//System.out.println(list2);
		Assert.assertEquals(list1,list2);
		
		
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	@Test
	public void testSortByMultipleCriteriaDefault() {
		Character char1 = new Character("A","A",new Stats(10,10,10,10,10,10),true);
		Character char2 = new Character("A","B",new Stats(20,20,20,20,20,20),true);
		Character char3 = new Character("A","C",new Stats(10,10,10,10,10,10),true);
		Character char4 = new Character("B","D",new Stats(6,15,15,25,25,0),true);
		
		Character char5 = new Character("C","E",new Stats(10,10,10,10,10,10),true);
		Character char6 = new Character("C","F",new Stats(10,10,10,10,10,10),true);
		Character char7 = new Character("C","G",new Stats(10,10,10,10,10,10),true);
		Character char8 = new Character("D","H",new Stats(50,50,20,15,15,25),true);
		
		Team team1 = new Team("Besto Team",true);
		List<Character> list1 = new ArrayList<Character>();
		List<Character> list2 = new ArrayList<Character>();
		
		list1.add(char2);
		list1.add(char1);
		list1.add(char3);
		list1.add(char4);
		list1.add(char5);
		list1.add(char6);
		list1.add(char7);
		list1.add(char8);
		
		team1.addGroup(char2);
		team1.addGroup(char3);
		team1.addGroup(char7);
		team1.addGroup(char8);
		team1.addGroup(char1);
		team1.addGroup(char4);
		team1.addGroup(char5);
		team1.addGroup(char6);
		
		
		
		Comparator<Character > cp = Character.getComparator(CharacterComparator.SortParameter.NAME_DES,CharacterComparator.SortParameter.AGL_DES);
		
		
		list2 = team1.sortByCriteria(cp);
		System.out.println(list1);
		System.out.println(team1);
		System.out.println(list2);
		Assert.assertEquals(list1,list2);
		
		
		
		Game.allCharacters.clear();
		Game.allTeams.clear();
	}
	
	
}
