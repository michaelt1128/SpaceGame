package worldTest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import gameTest.*;

public class GameOutput {
	// arraylists to store values for the ship battle
	public static ArrayList<Integer> tempP = new ArrayList<Integer>();
	public static ArrayList<Integer> tempE = new ArrayList<Integer>();
	public static boolean gameState = true;

	// declares and initializes the images used on maps
	private static final Icon mars = new ImageIcon(WorldGen.class.getResource("/images/mars.png"));
	private static final Icon sun = new ImageIcon(WorldGen.class.getResource("/images/sun.png"));
	private static final Icon uranus = new ImageIcon(WorldGen.class.getResource("/images/uranus.png"));
	private static final Icon pluto = new ImageIcon(WorldGen.class.getResource("/images/pluto.png"));

	// Creates the iconCreator object and all of the icon arrays used in the
	// maps
	private static CreateIcons iconCreator = new CreateIcons();
	private static Icon[] spc_icons = iconCreator.createSpc();
	private static Icon[] mars_Icons = iconCreator.createMars();
	private static Icon[] uranus_Icons = iconCreator.createUranus();
	private static Icon[] pluto_Icons = iconCreator.createPluto();

	// Creates the planet map objects
	private static WorldGen uranusGen = new WorldGen(10, 10, uranus_Icons);
	private static WorldGen plutoGen = new WorldGen(10, 10, pluto_Icons);
	private static WorldGen marsGen = new WorldGen(10, 10, mars_Icons);

	// Creates the dimension objects of planets and ships
	private static int[] shipLocation = { 4, 4 };
	private static final int[] marsLocation = { 2, 1 };
	private static final int[] uranusLocation = { 6, 3 };
	private static final int[] plutoLocation = { 3, 8 };
	private static final int[] sunLocation = { 8, 8 };
	private static final int[] centerLocation = { 4, 4 };
	
	public static WorldGen w = new WorldGen(10, 10, spc_icons);
	public static ShipTraits st = new ShipTraits();
	
	public static void main(String[] args) {

		// Creates the universe object, w, and sets its location in the top
		// center
		w.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		w.frame.setLocation(dim.width / 2 - w.frame.getSize().width, 0);
		// Starts the game
		welcomeText(w);
		setUpGame();
		
		class plutoMoveMaker extends SwingWorker<Double, Double> { 
			@Override
			protected Double doInBackground() throws Exception {
				int[][] p = fancyMoveShip(plutoLocation, w);
				for(int i = 1; i<p.length; i++){
					moveShip(p[i], w);
					Thread.sleep(500);
				}
				return null;
			}
			@Override
			protected void done() {
		
			}
		}
		class marsMoveMaker extends SwingWorker<Double, Double> { 
			@Override
			protected Double doInBackground() throws Exception {
				int[][] p = fancyMoveShip(marsLocation, w);
				for(int i = 1; i<p.length; i++){
					moveShip(p[i], w);
					Thread.sleep(500);
				}
				return null;
			}
			@Override
			protected void done() {
				
			}
		}
		
		class uranusMoveMaker extends SwingWorker<Double, Double> { 
			@Override
			protected Double doInBackground() throws Exception {
				int[][] p = fancyMoveShip(uranusLocation, w);
				for(int i = 1; i<p.length; i++){
					moveShip(p[i], w);
					Thread.sleep(500);
				}
				return null;
			}
			@Override
			protected void done() {
				
			}
		}
		class sunMoveMaker extends SwingWorker<Double, Double> {

			@Override
			protected Double doInBackground() throws Exception {
				int[][] p = fancyMoveShip(sunLocation, w);
				for(int i = 1; i<p.length; i++) {
					moveShip(p[i], w);
					Thread.sleep(500);
				}
				System.exit(0);
				return null;
			}
			
		}
		class centerMoveMaker extends SwingWorker<Double, Double> {
			
			@Override
			protected Double doInBackground() throws Exception {
				int[][] p = fancyMoveShip(centerLocation, w);
				for(int i = 1; i<p.length; i++) {
					moveShip(p[i], w);
					Thread.sleep(500);
				}
				return null;
			}
		}
		class spaceBattleMaker extends SwingWorker<Double, Double> {
			@Override
			protected Double doInBackground() throws Exception {
				SpaceBattle sb = new SpaceBattle(tempP, randomEnemy());
				sb.bFrame.setLocation(w.frame.getX(), w.frame.getHeight());
				sb.bFrame.setVisible(true);
				while(sb.hasLost != true && sb.hasWon != true)
				{
					Thread.sleep(100);
				}
				Thread.sleep(1000);
                sb.bFrame.dispose();
                SpacePort s = new SpacePort(PlayerShip.getShipStats());
                s.leaveButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
	                		new centerMoveMaker().execute();
	                		s.mFrame.dispose();
	                		uranusGen.frame.setVisible(false);
	                		marsGen.frame.setVisible(false);
	                		plutoGen.frame.setVisible(false);
                	}
                });
				
				return null;
			}
		}
		
		// Create the mars tile and open mars map
		w.setTile(marsLocation[0], marsLocation[1], mars);
		w.grid[marsLocation[0]][marsLocation[1]].setToolTipText("Mars");
		w.grid[marsLocation[0]][marsLocation[1]].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				new marsMoveMaker().execute();

				marsGen.frame.setVisible(true);
				uranusGen.frame.setVisible(false);
				plutoGen.frame.setVisible(false);

				marsGen.frame.setTitle("Mars");
				marsGen.frame.setLocation(w.frame.getX() + w.frame.getWidth(), w.frame.getY());
				
				new spaceBattleMaker().execute();
				
			}
		});

		// Create the uranus tile and open uranus map
		w.setTile(uranusLocation[0], uranusLocation[1], uranus);
		w.grid[uranusLocation[0]][uranusLocation[1]].setToolTipText("Uranus");
		w.grid[uranusLocation[0]][uranusLocation[1]].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				
				new uranusMoveMaker().execute();

				marsGen.frame.setVisible(false);
				uranusGen.frame.setVisible(true);
				plutoGen.frame.setVisible(false);

				uranusGen.frame.setTitle("Uranus");
				uranusGen.frame.setLocation(w.frame.getX() + w.frame.getWidth(), w.frame.getY());

				new spaceBattleMaker().execute();
				
			}
		});
		
		
		// Create the pluto tile and open map
		w.setTile(plutoLocation[0], plutoLocation[1], pluto);
		w.grid[plutoLocation[0]][plutoLocation[1]].setToolTipText("Pluto");
		w.grid[plutoLocation[0]][plutoLocation[1]].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				new plutoMoveMaker().execute();

				marsGen.frame.setVisible(false);
				uranusGen.frame.setVisible(false);
				plutoGen.frame.setVisible(true);

				plutoGen.frame.setTitle("Pluto");
				plutoGen.frame.setLocation(w.frame.getX() + w.frame.getWidth(), w.frame.getY());

				new spaceBattleMaker().execute();
				
			}
		});

		// Create sun tile
		w.setTile(sunLocation[0], sunLocation[1], sun);
		w.grid[sunLocation[0]][sunLocation[1]].setToolTipText("Sun");
		w.grid[sunLocation[0]][sunLocation[1]].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new sunMoveMaker().execute();
			}
		});
	}

	public static void welcomeText(WorldGen x) {
		JFrame frame = new JFrame("Space Game");
		frame.setLayout(new BorderLayout());

		// Text displayed in start gui
		JLabel hiText = new JLabel("Welcome to SPACE GAME");
		JLabel infoText = new JLabel("Please play responsibly");
		hiText.setFont(new Font("Serif", Font.BOLD, 24));
		infoText.setFont(new Font("Serif", Font.BOLD, 16));

		// Creates button that starts the game
		JButton startButton = new JButton("Start New Game");
		startButton.setSize(60, 40);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x.frame.setVisible(true);
				moveShip(centerLocation, x);
				frame.dispose();
			}
		});
		frame.add(startButton, BorderLayout.AFTER_LAST_LINE);
		frame.add(hiText, BorderLayout.PAGE_START);
		frame.add(infoText, BorderLayout.CENTER);
		frame.setSize(340, 150);
		// Makes start window open in middle of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		frame.setVisible(true);
	}

	public static void setUpGame() {
		tempP.add(0, 100);
		tempP.add(1, 1000);
		tempP.add(2, 100);
		tempP.add(3, 150);
		tempP.add(4, 90);
		tempP.add(5, 1000);
		tempP.add(6, 2000);

		PlayerShip.setShipStats(tempP);
		EnemyShip.setShipStats(randomEnemy());
	}

	public static ArrayList<Integer> randomEnemy() {
		ArrayList<Integer> randEnemyShip = new ArrayList<Integer>();

		int randShieldAbsorb = (int) (Math.random() * 20 + 80);
		int randShieldDurability = (int) (Math.random() * 200 + 900);
		int randArmor = (int) (Math.random() * 30 + 70);
		int randAttack = (int) (Math.random() * 40 + 100);
		int randAccuracy = (int) (Math.random() * 20 + 80);
		int randLoot = (int) (Math.random() * 50 + 200);
		randEnemyShip.add(0, randShieldAbsorb);
		randEnemyShip.add(1, randShieldDurability);
		randEnemyShip.add(2, randArmor);
		randEnemyShip.add(3, randAttack);
		randEnemyShip.add(4, randAccuracy);
		randEnemyShip.add(5, randShieldDurability);
		randEnemyShip.add(6, randLoot);

		return randEnemyShip;
	}

	public static int[] moveShip(int[] end, WorldGen w) {
		if (shipLocation[0] == marsLocation[0] && shipLocation[1] == marsLocation[1]) {
			w.setTile(marsLocation[0], marsLocation[1], mars);
		} else if (shipLocation[0] == plutoLocation[0] && shipLocation[1] == plutoLocation[1]) {
			w.setTile(plutoLocation[0], plutoLocation[1], pluto);
		} else if (shipLocation[0] == uranusLocation[0] && shipLocation[1] == uranusLocation[1]) {
			w.setTile(uranusLocation[0], uranusLocation[1], uranus);
		} else {
			w.resetTile(shipLocation[0], shipLocation[1], spc_icons);
		}
		
		shipLocation = end.clone();
		
		if (end[0] == marsLocation[0] && end[1] == marsLocation[1]) {
			w.makeSpaceShip(end[0], end[1], mars);
		} else if (end[0] == plutoLocation[0] && end[1] == plutoLocation[1]) {
			w.makeSpaceShip(end[0], end[1], pluto);
		} else if (end[0] == uranusLocation[0] && end[1] == uranusLocation[1]) {
			w.makeSpaceShip(end[0], end[1], uranus);
		} else {
			w.makeSpaceShip(end[0], end[1], w.resetTile(end[0], end[1], spc_icons));
		}
		return shipLocation;
	}

	public static int[][] fancyMoveShip(int[] end, WorldGen w) {
		int length = 10;
		int width = 10;

		// create a grid of -1s
		int[][] distance = new int[length][width];
		for (int i = 0; i < distance.length; i++) {
			for (int j = 0; j < distance[i].length; j++) {
				distance[i][j] = -1;
			}
		}
		// 0 for the end position
		distance[end[1]][end[0]] = 0;

		// amount of steps from the end position
		int steps = 1;

		// loop stops when it reaches the current ship location
		while (distance[shipLocation[1]][shipLocation[0]] == -1) {
			// loops through the y values
			for (int i = 0; i < 10; i++) {
				// loops through the x values
				for (int j = 0; j < 10; j++) {
					// checks to see if the current tile is in the path
					if (distance[i][j] == steps - 1) {
						// checks below
						if (i < length - 1) {
							// if the tile isnt marked already then we can mark
							// it with the current amount of steps
							if (distance[i + 1][j] == -1) {
								distance[i + 1][j] = steps;
							}
						}
						// checks above
						if (i > 0) {
							if (distance[i - 1][j] == -1) {
								distance[i - 1][j] = steps;
							}
						}
						// checks to the right
						if (j < length - 1) {
							if (distance[i][j + 1] == -1) {
								distance[i][j + 1] = steps;
							}
						}
						// checks to the left
						if (j > 0) {
							if (distance[i][j - 1] == -1) {
								distance[i][j - 1] = steps;
							}
						}
					}
				}
			}
			steps++;
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
		
		int stepCount = Math.max(Math.abs(shipLocation[0] - end[0]), Math.abs(shipLocation[1] - end[1]))+1;
		System.out.println(stepCount);
		
		int[][] path = new int[stepCount][2];
		path[0][0] = shipLocation[0];
		path[0][1] = shipLocation[1];
		
		int i = 0;
		
		while((path[i][0] != end[0]) || (path[i][1] != end[1])){
			int x = path[i][0];
			int y = path[i][1];
			i++;
			if (distance[y+1][x] == distance[y][x] - 1) {
				y++;
			} else if (distance[y-1][x] == distance[y][x] - 1) {
				y--;
			} 
			if (distance[y][x+1] == distance[y][x] - 1) {
				x++;
			} else if (distance[y][x-1] == distance[y][x] - 1) {
				x--; 
			}
			path[i][0] = x;
			path[i][1] = y;
		}
		
		
		for(int z = 0; z<path.length; z++){
			System.out.println(path[z][0] + " " + path[z][1]);
		}
		return path;
	}
}
