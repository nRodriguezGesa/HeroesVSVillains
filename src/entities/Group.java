package entities;

import java.util.Comparator; 
import java.util.List;

public interface Group {
	
	public boolean invalidAdd(Group group);
	
	public List<Character> sortByCriteria(Comparator<Character>cp);
	
	public List<Character> obtainCharacters();
	
	public String getFictionName();
	
	public List<Group>  forEachCharacter();
	
	public boolean getSide();
	
	public boolean isEmpty();
	
	public int countCharacters();
	
	public int getAGL();
	public int getSTR();
	public int getCRT();
	public int getPHY();
	public int getDEF();
	public int getINT();
	
}
