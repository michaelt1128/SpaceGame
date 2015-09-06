import java.util.ArrayList;
import java.util.Scanner;


public class GameDriver 
{
	public static boolean gameState = true;
	
	public static void main(String[] args)
	{
		System.out.println("*****-------Welcome to SpaceGame-------*****");
		GameDriver game = new GameDriver();
		
		ArrayList<String> portNames = new ArrayList<String>();
		portNames.add("Washington");
		portNames.add("Moscow");
		
		PlanetGen planet1 = new PlanetGen();
		planet1.setWorldName("Earth");
		planet1.setPortNames(portNames);
		System.out.println(planet1.getPortNames());
		
		WorldGen universe = new WorldGen(10,10);
		universe.setTile(2, 2);

	}
}
