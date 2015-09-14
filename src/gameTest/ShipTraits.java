package gameTest;
import java.util.ArrayList;


public class ShipTraits 
{
	public String name;
	public ArrayList<String> cargo;
	public ArrayList<Integer> shipStats; //Shields, Shield Strength, Armor, Attack, Accuracy 
	
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
	public ArrayList<String> getCargo()
	{
		return cargo;
	}
	public void setCargo(ArrayList<String> c)
	{
		cargo = c;
	}
}
