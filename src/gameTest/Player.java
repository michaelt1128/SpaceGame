package gameTest;
import java.util.ArrayList;

public class Player extends CharTraits 
{
	public int money;
	public ArrayList<String> inventory;
	
	
	public int getMoney()
	{
		return money;
	}
	public void setMoney(int m)
	{
		money = m;
	}
	
	public ArrayList<String> getInventory()
	{
		return inventory;
	}
	public void setInventory(ArrayList<String> i)
	{
		this.inventory = i;
	}
}
