import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
 
public class WorldGen											 
{
 
	JFrame frame=new JFrame(); //creates frame
    JButton[][] grid; //names the grid of buttons
    /**public BufferedImage kappaIcon = loadBufferedImage("/Kappa.jpg");
    
    private BufferedImage loadBufferedImage(String string)
    {
    	try
    	{
    		BufferedImage bi = ImageIO.read(this.getClass().getResource(string));
    		return bi;
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	return null;
    }**/

    public WorldGen(int width, int length) //constructor
    { 
    	frame.setLayout(new GridLayout(width,length)); //set layout
        grid=new JButton[width][length]; //allocate the size of grid
        for(int y=0; y<length; y++)
        {
         	for(int x=0; x<width; x++)
          	{
          		grid[x][y]=new JButton(""); //creates new button
          		grid[x][y].setPreferredSize(new Dimension(40,40));
          		frame.add(grid[x][y]); //adds button to grid
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //sets appropriate size for frame
        frame.setVisible(true); //makes frame visible
    }
    
    public void setTile(int x_val, int y_val)
    {
    	try
    	{
    		BufferedImage image = null;
    		image = ImageIO.read(WorldGen.class.getResource("/images/Kappa.jpg"));    	
    		grid[x_val][y_val]=new JButton(new ImageIcon(image));
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    }
    public static void main(String[] args) 
    {
    	new WorldGen(10,10);//makes new WorldGen with 2 parameters
    }
}