package test;

import static org.junit.Assert.assertThrows;  
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;

import org.junit.jupiter.*;
import org.junit.jupiter.api.Test;

import entities.*;

import entities.Character;
import junit.framework.Assert;


public class TestCharacter {
	@Test
	public  void testAddCharacterOK() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Assert.assertEquals(1,Game.allCharacters.size());
		Game.allCharacters.clear();
	}
	@Test
	public void testAddCharactersOK() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Assert.assertEquals(3,Game.allCharacters.size());
		Game.allCharacters.clear();
	}
	/*
	@Test
	public void testAddCharactersError() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Game.allCharacters.clear();
		//no se hacerlo :(
		
	}
	*/
	@Test
	public void testAddAbilityOK() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Assert.assertEquals(true,char1.addAbility(new OneForAll()));
		Game.allCharacters.clear();
	}
	
	@Test
	public void testAddAbilitiesOK() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Assert.assertEquals(true,char1.addAbility(new OneForAll()));
		Assert.assertEquals(true,char1.addAbility(new ZeroGravity()));
		Assert.assertEquals(true,char1.addAbility(new DarkShadow()));
		Game.allCharacters.clear();
	}
	
	@Test 
	public void testAddAbilitesERRORDifferentSide() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Assert.assertEquals(false,char1.addAbility(new Transform()));
		Game.allCharacters.clear();
	}
	
	@Test
	public void testAddAbilityERRORSameAbility() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Assert.assertEquals(true,char1.addAbility(new OneForAll()));
		Assert.assertEquals(false,char1.addAbility(new OneForAll()));
		Game.allCharacters.clear();
	}
	
	@Test
	public void  testRefreshStatsOneForAll() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		char1.addAbility(new OneForAll());
		Assert.assertEquals(100,char1.getAGL());
		Assert.assertEquals(200,char1.getSTR());
		Assert.assertEquals(0,char1.getCRT());
		Assert.assertEquals(1,char1.getPHY());
		Assert.assertEquals(1,char1.getDEF());
		Assert.assertEquals(1,char1.getINT());
		Game.allCharacters.clear();
	}
	
	@Test
	public void testRefreshStatsDarkShadowBadEnding() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		char1.addAbility(new DarkShadow());
		Assert.assertEquals(1,char1.getAGL());
		Assert.assertEquals(1,char1.getSTR());
		Assert.assertEquals(1,char1.getCRT());
		Assert.assertEquals(1,char1.getPHY());
		Assert.assertEquals(1,char1.getDEF());
		Assert.assertEquals(1,char1.getINT());
		Game.allCharacters.clear();	
	}
	
	@Test 
	public void testRefreshStatsDarkShadowGoodEnding() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,40,5),true);
		char1.addAbility(new DarkShadow());
		Assert.assertEquals(30,char1.getAGL());
		Assert.assertEquals(60,char1.getSTR());
		Assert.assertEquals(0,char1.getCRT());
		Assert.assertEquals(15,char1.getPHY());
		Assert.assertEquals(120,char1.getDEF());
		Assert.assertEquals(15,char1.getINT());
		Game.allCharacters.clear();	
	}
	
	@Test
	public void testRefreshStatsZeroGravityGoodEnding() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(30,20,5,5,40,5),true);
		char1.addAbility(new ZeroGravity());
		Assert.assertEquals(90,char1.getAGL());
		Assert.assertEquals(20,char1.getSTR());
		Assert.assertEquals(15,char1.getCRT());
		Assert.assertEquals(5,char1.getPHY());
		Assert.assertEquals(40,char1.getDEF());
		Assert.assertEquals(5,char1.getINT());
		Game.allCharacters.clear();	

	}
	@Test
	public void testRefreshStatsZeroGravityBadEnding() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,5,5,40,5),true);
		char1.addAbility(new ZeroGravity());
		Assert.assertEquals(5,char1.getAGL());
		Assert.assertEquals(20,char1.getSTR());
		Assert.assertEquals(5,char1.getCRT());
		Assert.assertEquals(5,char1.getPHY());
		Assert.assertEquals(40,char1.getDEF());
		Assert.assertEquals(5,char1.getINT());
		Game.allCharacters.clear();	
	}
	@Test 
	public void testRefreshStatsTransform() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Toga Himiko","Toga",new Stats(1,1,1,1,1,1),false);
		
		char4.addAbility(new Transform());
		HashSet<Ability>ab = char4.getAbilities();
		
		for(Character ch : Game.allCharacters) {
			for(Ability a : ab) {
				if(a.getName().contains(ch.getAka())) {
					Assert.assertEquals(char4.getAGL(),ch.getAGL());
					Assert.assertEquals(char4.getSTR(),ch.getSTR());
					Assert.assertEquals(char4.getCRT(),ch.getCRT());
					Assert.assertEquals(char4.getPHY(),ch.getPHY());
					Assert.assertEquals(char4.getDEF(),ch.getDEF());
					Assert.assertEquals(char4.getINT(),ch.getINT());
				}
			}
		}
		Game.allCharacters.clear();
	}
	
	@Test 
	public void testRefreshStatsAllForOne() {
		Character char1 = new Character("Izuku Midoriya","Deku",new Stats(10,20,0,5,5,5),true);
		Character char2 = new Character("Toshinori Yagi","All Might",new Stats(50,50,20,15,15,25),true);
		Character char3 = new Character("Ochaco Uraraka","Uravity",new Stats(3,10,15,5,5,0),true);
		Character char4 = new Character("Toga Himiko","Toga",new Stats(1,1,1,1,1,1),false);
		
		char4.addAbility(new AllForOne());
		
		
		Assert.assertEquals(64,char4.getAGL());
		Assert.assertEquals(81,char4.getSTR());
		Assert.assertEquals(36,char4.getCRT());
		Assert.assertEquals(26,char4.getPHY());
		Assert.assertEquals(26,char4.getDEF());
		Assert.assertEquals(31,char4.getINT());
		
		Game.allCharacters.clear();
	}
	
	@Test
	public void testRefreshStatsCremation() {
		Character char1 = new Character("Toga Himiko","Toga",new Stats(1,1,1,1,10,1),false);
		char1.addAbility(new Cremation());
		
		Assert.assertEquals(1,char1.getAGL());
		Assert.assertEquals(1,char1.getSTR());
		Assert.assertEquals(1,char1.getCRT());
		Assert.assertEquals(1,char1.getPHY());
		Assert.assertEquals(5,char1.getDEF());
		Assert.assertEquals(5,char1.getINT());
		
		Game.allCharacters.clear();
		
	}

}
