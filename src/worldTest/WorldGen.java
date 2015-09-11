package worldTest;
import javax.swing.*;
import java.awt.*;
 
public class WorldGen											 
{ 
	JFrame frame=new JFrame("Universe");
    JButton[][] grid;
        
    public static void main(String[] args)
    {    	
    	
    }
    
    public WorldGen(int width, int length, Icon image[]) 
    { 
    	frame.setLayout(new GridLayout(width, length));
    	frame.setBackground(Color.BLACK);
    	frame.setSize(new Dimension(600, 600));
        grid=new JButton[width][length];
        
        for(int y=0; y<length; y++)
        {
         	for(int x=0; x<width; x++)
          	{         		
          		grid[x][y]=new JButton("");
          		grid[x][y].setBackground(Color.black);		
          		grid[x][y].setSize(40, 40);
          		frame.add(grid[x][y]); 
          		
          		double randVal = Math.random();
          		
          		//assign tiles to various images from an Icon array
    			if(randVal<.4)
    			{
    				grid[x][y].setIcon(image[0]);    				
    			}
    			else if(randVal<.5)
    			{
    				setTile(x, y, image[1]);
    			}
    			else if(randVal<.6)
    			{
    				setTile(x, y, image[2]);
    			}
    			else if(randVal<.7)
    			{
    				setTile(x, y, image[3]);
    			}
    			else if(randVal<.8)
    			{
    				setTile(x, y, image[4]);
    			}
    			else if(randVal<.9)
    			{
    				setTile(x, y, image[5]);
    			}
    			else if(randVal<1)
    			{
    				setTile(x, y, image[6]);
    			}
    			System.out.println(randVal);
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false); 
        frame.setResizable(false);
    }
    
    public void setTile(int x_val, int y_val, Icon image)
    {
    	grid[x_val][y_val].setIcon(image);
    }
}