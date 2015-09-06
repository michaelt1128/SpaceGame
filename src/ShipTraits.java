import java.util.ArrayList;


public class ShipTraits 
{
	public int shields = 100;
	public int armor;
	public String name;
	public ArrayList<String> cargo;
	
	public int getShield()
	{
		return shields;
	}
	public void setShields(int sh)
	{
		shields = sh;
	}
	
	public int getArmor()
	{
		return armor;
	}
	public void setArmor(int a)
	{
		armor = a;
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
