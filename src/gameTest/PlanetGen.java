package gameTest;
import java.util.ArrayList;

public class PlanetGen
{	
	public String worldName;
	public ArrayList<String> portNames;
	public ArrayList<String> shops;
	public ArrayList<String> shopList;
	public ArrayList<Integer> itemCost;
	public int[] planetCoords;
	//need to create a coordinate int[] so we can set coords of the planets.
	public int[] getPlanetCoords()
	{
		return planetCoords;
	}
	public void setPlanetCoords(int[] pC)
	{
		planetCoords = pC;
	}
	
	public String getWorldName()
	{
		return worldName;
	}
	public void setWorldName(String wN)
	{
		worldName = wN;
	}
	
	public ArrayList<String> getPortNames()
	{
		return portNames;
	}
	public void setPortNames(ArrayList<String> pN)
	{
		this.portNames = pN;
	}
	
	public ArrayList<String> getShops()
	{
		return shops;
	}
	public void setShops(ArrayList<String> s)
	{
		this.shops = s;
	}
	
	public ArrayList<String> getShopList()
	{
		return shopList;
	}
	public void setShopList(ArrayList<String> sL)
	{
		this.shopList = sL;
	}
	
	public ArrayList<Integer> getItemCost()
	{
		return itemCost;
	}
	public void setItemCost(ArrayList<Integer> iC)
	{
		this.itemCost = iC;
	}
}
