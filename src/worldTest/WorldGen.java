package worldTest;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
 
public class WorldGen											 
{
 
	JFrame frame=new JFrame("Universe"); //creates frame
    JButton[][] grid; //names the grid of buttons
        
    public static void main(String[] args)
    {    	
    	//create the icons from the image files
    	Icon Kappa = null;
    	Icon BibleThump = null;
    	Icon spc_0 = null;
    	Icon spc_1 = null;
    	Icon spc_2 = null;
    	Icon spc_3 = null;
    	Icon spc_4 = null;
    	Icon spc_5 = null;
    	Icon spc_6 = null;
    	
    	Icon[] spcIcons = new Icon[7];
    	spcIcons[0] = spc_0;
    	spcIcons[1] = spc_1;
    	spcIcons[2] = spc_2;
    	spcIcons[3] = spc_3;
    	spcIcons[4] = spc_4;
    	spcIcons[5] = spc_5;
    	spcIcons[6] = spc_6;
    	
    	
    	try
    	{
        	//Kappa = kappa image icon
    		BufferedImage kappa = null;
    		kappa = ImageIO.read(WorldGen.class.getResource("/images/Kappa.jpg"));
    		Kappa = new ImageIcon(kappa);
    		
    		//BibleThump = BibleThump image icon
    		BufferedImage bible = null;
        	bible = ImageIO.read(WorldGen.class.getResource("/images/BibleThump.png"));
    		BibleThump = new ImageIcon(bible);
    		
    		BufferedImage spc0 = ImageIO.read(WorldGen.class.getResource("/images/space_background0.jpg"));
    		spc_0 = new ImageIcon(spc0);
    		
    		BufferedImage spc1 = ImageIO.read(WorldGen.class.getResource("/images/space_background1.jpg"));
    		spc_1 = new ImageIcon(spc1);
    		
    		BufferedImage spc2 = ImageIO.read(WorldGen.class.getResource("/images/space_background2.jpg"));
    		spc_2 = new ImageIcon(spc2);

    		BufferedImage spc3 = ImageIO.read(WorldGen.class.getResource("/images/space_background3.jpg"));
    		spc_3 = new ImageIcon(spc3);
    		
    		BufferedImage spc4 = ImageIO.read(WorldGen.class.getResource("/images/space_background4.jpg"));
    		spc_4 = new ImageIcon(spc4);
    		
    		BufferedImage spc5 = ImageIO.read(WorldGen.class.getResource("/images/space_background5.jpg"));
    		spc_5 = new ImageIcon(spc5);
    		
    		BufferedImage spc6 = ImageIO.read(WorldGen.class.getResource("/images/space_background6.jpg"));
    		spc_6 = new ImageIcon(spc6);  
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	WorldGen universe = new WorldGen(10, 10, spc_0);    	
    	universe.randomSpaceTiles(spcIcons);
    	universe.setTile(4, 4, spc_4);
    }
    
    //the worldgen constructor creates a grid of buttons 
    //the size and icon can be changed
    public WorldGen(int width, int length, Icon image) 
    { 
    	frame.setLayout(new GridLayout(width, length));
    	frame.setBackground(Color.BLACK);
    	frame.setSize(new Dimension(600, 600));
        grid=new JButton[width][length]; //allocate the size of button grid
        
        for(int y=0; y<length; y++)
        {
         	for(int x=0; x<width; x++)
          	{
          		grid[x][y]=new JButton("");
          		grid[x][y].setBackground(Color.black);		
          		grid[x][y].setIcon(image);
          		grid[x][y].setSize(40, 40);
          		frame.add(grid[x][y]); //adds button to grid
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); //makes frame visible
        frame.setResizable(false);
    }
    
    //The goal of the setTile method is to replace tiles with other icons
    public void setTile(int x_val, int y_val, Icon image)
    {
    	grid[x_val][y_val].setIcon(image);
    }
    
    public void randomSpaceTiles(Icon image[])
    {
    	int count = 0;
    	for(int y=0; y<10; y++)
    	{
    		for(int x=0; x<10; x++)
    		{
    			grid[x][y].setIcon(image[0]);
    			double randVal = Math.random();
    			if(randVal<=.4)
    			{
    				
    				//setTile(x, y, image[0]);
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
    			count++;
    			System.out.println(count + " " + randVal);
    		}
    	}
    }
}