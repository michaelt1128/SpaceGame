package gameTest;
import java.util.ArrayList;


public class ShipTraits 
{
	public String name;
	public ArrayList<Integer> shipStats; //Shield absorb, Shield Durability, Armor, Attack, Accuracy, max Shields, loot(money)
	
	public ArrayList<Integer> getShipStats()
	{
		return shipStats;
	}
	public void setShipStats(ArrayList<Integer> sS)
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
