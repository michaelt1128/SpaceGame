package gameTest;

public class EnemyShip extends ShipTraits
{
	public String shipClass;
	public int difficulty;
	
	public String getShipClass()
	{
		return shipClass;
	}
	public void setShipClass(String sC)
	{
		shipClass = sC;
	}
	public int getDifficulty()
	{
		return difficulty;
	}
	public void setDifficulty(int d)
	{
		difficulty = d;
	}
}
