package gameTest;
import java.util.ArrayList;


public class ShipTraits 
{
	public String name;
	public static ArrayList<Integer> shipStats; //Shield absorb, Shield Durability, Armor, Attack, Accuracy, max Shields, loot(money)
	
	public static ArrayList<Integer> getShipStats()
	{
		return shipStats;
	}
	public static void setShipStats(ArrayList<Integer> sS)
	{
		shipStats = sS;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String n)
	{
		name = n;
	}
}
