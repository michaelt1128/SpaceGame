package worldTest;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.concurrent.ExecutionException;
 
public class WorldGen											 
{
 
	JFrame frame=new JFrame("Universe"); //creates frame
    JButton[][] grid; //names the grid of buttons
    JPanel ButtonPane = new JPanel();

    
    public WorldGen(int width, int length) //constructor
    { 
    	frame.setLayout(new GridLayout(width, length)); //set layout
    	frame.setBackground(Color.BLACK);
    	frame.setSize(new Dimension(600, 600));
        grid=new JButton[width][length]; //allocate the size of grid
        
        for(int y=0; y<length; y++)
        {
         	for(int x=0; x<width; x++)
          	{
          		grid[x][y]=new JButton(""); //creates new button
          		//grid[x][y].setPreferredSize(new Dimension(40,40));
          		grid[x][y].setBackground(Color.blue);

          		try
            	{
            		BufferedImage image = null;
            		image = ImageIO.read(WorldGen.class.getResource("/images/Kappa.jpg"));    	
            		grid[x][y].setIcon(new ImageIcon(image));
            		
            		frame.setVisible(true);
            	}
            	catch(IOException e)
            	{
            		e.printStackTrace();
            	}
          		grid[x][y].setSize(40, 40);
          		frame.add(grid[x][y]); //adds button to grid
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack(); //sets appropriate size for frame
        frame.setVisible(true); //makes frame visible
        frame.setResizable(false);
    }
    
    //The goal of the setTile method is to replace tiles with other icons
    public void setTile(int x_val, int y_val)
    {
    	SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>(){
    		@Override
    		protected Boolean doInBackground() throws Exception
    		{
    			return false;
    		}
    		
    		@Override
    		protected void done()
    		{
    			try {
					Boolean status = get();
					BufferedImage bible = null;
            		bible = ImageIO.read(WorldGen.class.getResource("/images/BibleThump.png"));    	
            		grid[x_val][y_val].setIcon(new ImageIcon(bible));
            		
				} catch (InterruptedException | ExecutionException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    		}
    	};
    			

    }
    /**public static void main(String[] args) 
    {
    	new WorldGen(10,10);//makes new WorldGen with 2 parameters
    }**/
}