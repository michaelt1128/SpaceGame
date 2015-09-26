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

import gameTest.*;

public class GameOutput {
	// arraylists to store values for the ship battle
	public static ArrayList<Integer> tempP = new ArrayList<Integer>();
	public static ArrayList<Integer> tempE = new ArrayList<Integer>();
	public static boolean gameState = true;

	// declares and initializes the images used on maps
	private static Icon mars = new ImageIcon(WorldGen.class.getResource("/images/mars.png"));
	private static Icon sun = new ImageIcon(WorldGen.class.getResource("/images/sun.png"));
	private static Icon uranus = new ImageIcon(WorldGen.class.getResource("/images/uranus.png"));
	private static Icon marsBase0 = new ImageIcon(WorldGen.class.getResource("/images/marsBase0.png"));
	private static Icon pluto = new ImageIcon(WorldGen.class.getResource("/images/pluto.png"));

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
	private static Dimension shipLocation = new Dimension(4, 4);
	private static Dimension marsLocation = new Dimension(4, 2);
	private static Dimension uranusLocation = new Dimension(6, 3);
	private static Dimension plutoLocation = new Dimension(3, 8);

	public static void main(String[] args) {

		// Creates the universe object, w, and sets its location in the top
		// center
		WorldGen w = new WorldGen(10, 10, spc_icons);
		w.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		w.frame.setLocation(dim.width / 2 - w.frame.getSize().width, 0);

		// Creates the gameUpdate object and places it below the universe object
		// this is used for the main text of the program
		GameUpdates gameUpdate = new GameUpdates();
		gameUpdate.frame.setLocation(w.frame.getX(), w.frame.getY() + w.frame.getHeight() + 400);

		//Starts the game
		welcomeText(w, gameUpdate);
		setUpGame();

		// Create the mars tile and open mars map
		w.setTile(4, 2, mars);
		w.grid[4][2].setToolTipText("Mars");
		w.grid[4][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				moveShip(marsLocation, w);

				marsGen.frame.setVisible(true);
				uranusGen.frame.setVisible(false);
				plutoGen.frame.setVisible(false);

				marsGen.frame.setTitle("Mars");
				marsGen.frame.setLocation(w.frame.getX() + w.frame.getWidth(), w.frame.getY());
				if (Math.random() < .65) {
					SpaceBattle sb = new SpaceBattle(tempP, randomEnemy());
					sb.bFrame.setLocation(w.frame.getX(), w.frame.getHeight());
					sb.bFrame.setVisible(true);
				}
				marsGen.setTile(3, 3, marsBase0);
				marsGen.grid[3][3].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e2) {
						WorldGen marsBaseMap = new WorldGen(10, 10, uranus_Icons);
						marsBaseMap.frame.setVisible(true);
					}

				});
				gameUpdate.leaveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						w.grid[4][2].setIcon(mars);
						marsGen.frame.setVisible(false);
					}
				});
			}
		});

		// Create the uranus tile and open uranus map
		w.setTile(6, 3, uranus);
		w.grid[6][3].setToolTipText("Uranus");
		w.grid[6][3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {

				moveShip(uranusLocation, w);

				marsGen.frame.setVisible(false);
				uranusGen.frame.setVisible(true);
				plutoGen.frame.setVisible(false);

				uranusGen.frame.setTitle("Uranus");
				uranusGen.frame.setLocation(w.frame.getX() + w.frame.getWidth(), w.frame.getY());

				if (Math.random() < .65) {
					SpaceBattle sb = new SpaceBattle(tempP, randomEnemy());
					sb.bFrame.setLocation(w.frame.getX(), w.frame.getHeight());
					sb.bFrame.setVisible(true);
				}
				gameUpdate.leaveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						w.grid[6][3].setIcon(uranus);
						uranusGen.frame.setVisible(false);
					}
				});
			}

		});

		// Create the pluto tile and open map
		w.setTile(3, 8, pluto);
		w.grid[3][8].setToolTipText("Pluto");
		w.grid[3][8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				moveShip(plutoLocation, w);

				marsGen.frame.setVisible(false);
				uranusGen.frame.setVisible(false);
				plutoGen.frame.setVisible(true);

				plutoGen.frame.setTitle("Pluto");
				plutoGen.frame.setLocation(w.frame.getX() + w.frame.getWidth(), w.frame.getY());

				if (Math.random() < .65) {
					SpaceBattle sb = new SpaceBattle(tempP, randomEnemy());
					sb.bFrame.setLocation(w.frame.getX(), w.frame.getHeight());
					sb.bFrame.setVisible(true);
				}
				gameUpdate.leaveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						w.grid[3][8].setIcon(pluto);
						plutoGen.frame.setVisible(false);
					}
				});
			}
		});

		// Create sun tile
		w.setTile(8, 8, sun);
		w.grid[8][8].setToolTipText("Sun");

		w.grid[8][8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameUpdate.label.setText("<html>WHAT HAVE YOU DONE??!?!? AAAAAAAAAAAAAAA-</html>");
				new java.util.Timer().schedule(new java.util.TimerTask() {
					public void run() {
						gameUpdate.label.setText(
								"<html><body style='width: 500px'>Oh just kidding. But you should know that the sun is very dangerous and could easily kill you... oh wait...</html>");
					}
				}, 2000);
				new java.util.Timer().schedule(new java.util.TimerTask() {
					public void run() {
						System.exit(0);
					}
				}, 4000);
			}
		});
	}

	public static void welcomeText(WorldGen x, GameUpdates y) {
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
				frame.dispose();
				y.frame.setVisible(true);
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
		PlayerShip pShip = new PlayerShip();
		EnemyShip eShip = new EnemyShip();
		tempP.add(0, 100);
		tempP.add(1, 1000);
		tempP.add(2, 100);
		tempP.add(3, 150);
		tempP.add(4, 90);
		tempP.add(5, 1000);

		tempE.add(0, 100);
		tempE.add(1, 1000);
		tempE.add(2, 100);
		tempE.add(3, 130);
		tempE.add(4, 90);
		tempE.add(5, 1000);
		pShip.setShipStats(tempP);
		eShip.setShipStats(tempE);
	}

	public static ArrayList<Integer> randomEnemy() {
		ArrayList<Integer> randEnemyShip = new ArrayList<Integer>();

		int randShieldAbsorb = (int) (Math.random() * 20 + 80);
		int randShieldDurability = (int) (Math.random() * 200 + 900);
		int randArmor = (int) (Math.random() * 30 + 70);
		int randAttack = (int) (Math.random() * 40 + 100);
		int randAccuracy = (int) (Math.random() * 20 + 80);

		randEnemyShip.add(0, randShieldAbsorb);
		randEnemyShip.add(1, randShieldDurability);
		randEnemyShip.add(2, randArmor);
		randEnemyShip.add(3, randAttack);
		randEnemyShip.add(4, randAccuracy);
		randEnemyShip.add(5, randShieldDurability);

		return randEnemyShip;
	}

	public static Dimension moveShip(Dimension end, WorldGen w) {
		if (shipLocation.equals(marsLocation)) {
			w.setTile(marsLocation.width, marsLocation.height, mars);
		} else if (shipLocation.equals(plutoLocation)) {
			w.setTile(plutoLocation.width, plutoLocation.height, pluto);
		} else if (shipLocation.equals(uranusLocation)) {
			w.setTile(uranusLocation.width, uranusLocation.height, uranus);
		} else {
			w.resetTile(shipLocation.width, shipLocation.height, spc_icons);
		}
		shipLocation.setSize(end.getSize());
		if (end.equals(marsLocation)) {
			w.makeSpaceShip(end.width, end.height, mars);
		} else if (end.equals(plutoLocation)) {
			w.makeSpaceShip(end.width, end.height, pluto);
		} else if (end.equals(uranusLocation)) {
			w.makeSpaceShip(end.width, end.height, uranus);
		} else {
			w.makeSpaceShip(end.width, end.height, w.resetTile(end.width, end.height, spc_icons));
		}
		return shipLocation;
	}
}
