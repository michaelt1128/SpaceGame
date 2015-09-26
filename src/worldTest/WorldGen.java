package worldTest;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class WorldGen											 
{ 
	JFrame frame=new JFrame("Universe");
    JButton[][] grid;
    File randVals = new File(WorldGen.class.getResource("/textFiles/randVals.txt").getFile());
           
    public WorldGen(int width, int length, Icon image[])
    { 
    	frame.setLayout(new GridLayout(width, length));
    	frame.setBackground(Color.BLACK);
    	frame.setSize(new Dimension(400, 400));
        grid=new JButton[width][length];
        
        try {
			FileWriter fileOut = new FileWriter(randVals);
			fileOut.write("");
			fileOut.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(randVals, false);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        
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
    			String randString = Double.toString(randVal);
    			try {
					bw.write(randString);
					bw.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false); 
        frame.setResizable(false);
        try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void setTile(int x_val, int y_val, Icon image)
    {
    	grid[x_val][y_val].setIcon(image);
    }
    public Icon resetTile(int x_val, int y_val, Icon[] image)
    {
    	String line = "";
    	double tileValue;
    	String realLine = "";
    	try {
			BufferedReader br = new BufferedReader(new FileReader(randVals));
			for(int y = 0; y<=y_val; y++)
			{
				for(int x = 0; x<10; x++)
				{
					line = br.readLine();
					if(x==x_val && y==y_val)
					{
						realLine = line;
						System.out.println(line);
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	tileValue = Double.parseDouble(realLine);
    	if(tileValue<.4)
		{
			grid[x_val][y_val].setIcon(image[0]);    
			return image[0];
		}
		else if(tileValue<.5)
		{
			setTile(x_val, y_val, image[1]);
			return image[1];
		}
		else if(tileValue<.6)
		{
			setTile(x_val, y_val, image[2]);
			return image[2];
		}
		else if(tileValue<.7)
		{
			setTile(x_val, y_val, image[3]);
			return image[3];
		}
		else if(tileValue<.8)
		{
			setTile(x_val, y_val, image[4]);
			return image[4];
		}
		else if(tileValue<.9)
		{
			setTile(x_val, y_val, image[5]);
			return image[5];
		}
		else if(tileValue<1)
		{
			setTile(x_val, y_val, image[6]);
			return image[6];
		}    
		else
		{
			return null;
		}
    }    
    public void makeSpaceShip(int x, int y, Icon image)
    {
    	ImageIcon ship = new ImageIcon(WorldGen.class.getResource("/images/spaceShip.png"));
    	BufferedImage combined = new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB);
		Graphics g = combined.createGraphics();
		image.paintIcon(null, g, 0, 0);
		ship.paintIcon(null, g, 0, 0);
		
		Icon combo = new ImageIcon(combined);
		grid[x][y].setIcon(combo);
    }
}
















