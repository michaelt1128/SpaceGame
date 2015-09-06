
import java.util.Scanner;


public class GameDriver 
{
	public static void main(String[] args)
	{
		//Getting the player name as input
		Player p1 = new Player();
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your name: ");
		p1.setName(sc.next());
		//Displaying player name
		System.out.println("Player Name: " + p1.getName());
		//test
	}
}
