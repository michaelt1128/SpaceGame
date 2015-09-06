package gameTest;
import java.util.ArrayList;

public class Enemy extends CharTraits 
{
	public int difficulty;
	public ArrayList<String> loot;
	
	
	public int getDifficulty()
	{
		return difficulty;
	}
	public void setDifficulty(int diff)
	{
		difficulty = diff;
	}
}
