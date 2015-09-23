package worldTest;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class CreateIcons {
	public Icon[] createSpc()
	{   	    	
    	Icon spc_0 = new ImageIcon(WorldGen.class.getResource("/images/space_background0.jpg"));
    	Icon spc_1 = new ImageIcon(WorldGen.class.getResource("/images/space_background1.jpg"));
    	Icon spc_2 = new ImageIcon(WorldGen.class.getResource("/images/space_background2.jpg"));
    	Icon spc_3 = new ImageIcon(WorldGen.class.getResource("/images/space_background3.jpg"));
    	Icon spc_4 = new ImageIcon(WorldGen.class.getResource("/images/space_background4.jpg"));
    	Icon spc_5 = new ImageIcon(WorldGen.class.getResource("/images/space_background5.jpg"));
    	Icon spc_6 = new ImageIcon(WorldGen.class.getResource("/images/space_background6.jpg"));
    	
    	
    	Icon[] spcIcons = new Icon[7];
    	spcIcons[0] = spc_0;
    	spcIcons[1] = spc_1;
    	spcIcons[2] = spc_2;
    	spcIcons[3] = spc_3;
    	spcIcons[4] = spc_4;
    	spcIcons[5] = spc_5;
    	spcIcons[6] = spc_6;
    	
    	return spcIcons;
	}
	
	public Icon[] createMars()
	{
		Icon mars0 = new ImageIcon(WorldGen.class.getResource("/images/mars2.png"));
		Icon mars1 = new ImageIcon(WorldGen.class.getResource("/images/mars1.png"));
		Icon mars2 = new ImageIcon(WorldGen.class.getResource("/images/mars0.png"));
		Icon mars3 = new ImageIcon(WorldGen.class.getResource("/images/mars3.png"));
		Icon mars4 = new ImageIcon(WorldGen.class.getResource("/images/mars4.png"));
		Icon mars5 = new ImageIcon(WorldGen.class.getResource("/images/mars5.png"));
		Icon mars6 = new ImageIcon(WorldGen.class.getResource("/images/mars6.png"));
		
		Icon[] marsIcons = new Icon[7];
		marsIcons[0] = mars0;
		marsIcons[1] = mars1;
		marsIcons[2] = mars2;
		marsIcons[3] = mars3;
		marsIcons[4] = mars4;
		marsIcons[5] = mars5;
		marsIcons[6] = mars6;
		
		return marsIcons;
	}
	
	public Icon[] createUranus()
	{
		Icon uranus0 = new ImageIcon(WorldGen.class.getResource("/images/uranus0.png"));

		Icon[] uranusIcons = new Icon[7];
		uranusIcons[0]= uranus0;
		uranusIcons[1]= uranus0;
		uranusIcons[2]= uranus0;
		uranusIcons[3]= uranus0;
		uranusIcons[4]= uranus0;
		uranusIcons[5]= uranus0;
		uranusIcons[6]= uranus0;
		return uranusIcons;
	}
	
	public Icon[] createPluto()
	{
		Icon pluto0 = new ImageIcon(WorldGen.class.getResource("/images/pluto0.png"));
		
		Icon[] plutoIcons = new Icon[7];
		plutoIcons[0] = pluto0;
		plutoIcons[1] = pluto0;
		plutoIcons[2] = pluto0;
		plutoIcons[3] = pluto0;
		plutoIcons[4] = pluto0;
		plutoIcons[5] = pluto0;
		plutoIcons[6] = pluto0;
		
		return plutoIcons;
	}
}
