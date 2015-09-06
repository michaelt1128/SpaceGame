
import java.util.Scanner;


public class GameDriver 
{
	public static void main(String[] args)
	{
		//Getting the player name as input
		CharTraits p1 = new CharTraits();
		Scanner sc = new Scanner(System.in);
		System.out.println("Input your name: ");
		p1.setName(sc.next());
		//Displaying player name
		System.out.println("Player Name: " + p1.getName());
		//test
	}
}
