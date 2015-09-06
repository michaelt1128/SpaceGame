package gameTest;
import java.util.ArrayList;
import java.util.Scanner;
public class SpaceBattle 
{
	public void startBattle(ArrayList<Integer> pStats,ArrayList<Integer> eStats)
	{
		System.out.println("Enemy Spotted to the front Captain!");
		Scanner sc = new Scanner(System.in);
		while(pStats.get(0) > 0 && eStats.get(0) > 0)
		{
			System.out.println("Attack: 1 \n Flee: 2");
			if(sc.nextInt() == 1)
			{
				eStats.set(0,eStats.get(0) - pStats.get(2));
			}
			System.out.println(eStats.get(0));
			eStats.set(0,0); // exits the loop
		}
	}
}