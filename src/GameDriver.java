import java.util.*;
import java.util.Scanner;


public class GameDriver 
{	
	public static boolean gameState = true;
	
	public static void main(String[] args)
	{
		ArrayList<Integer> p1 = new ArrayList<>();
		ArrayList<Integer> e1 = new ArrayList<>();
		System.out.println("*****-------Welcome to SpaceGame-------*****");
		SpaceBattle b1 = new SpaceBattle();
		
		p1.add(100);
		p1.add(100);
		p1.add(50);
		e1.add(100);
		e1.add(100);
		e1.add(50);
		
		b1.startBattle(p1,e1);

	}
}
