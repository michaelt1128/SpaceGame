import java.util.Scanner;


public class GameDriver 
{
	public static void main(String[] args)
	{
		Player p1 = new Player();
		Scanner sc = new Scanner(System.in);
		p1.setName(sc.next("Character Name: "));
		
		System.out.println("Player Name: " + p1.getName());
	}
}
