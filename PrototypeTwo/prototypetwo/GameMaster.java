 
/* This class is responsible for controlling the high-level game functions.
 * These functions include 
 * initializing the MapPanel, starting the game, and ending the game.
 */
package prototypetwo;

import javax.swing.Timer;

public class GameMaster {
	private Map map;
	private MapPanel mapPanel;
	private static Timer timer;
	
	/**
	 * This will initialize the game.  
	 * It will do this by setting up the map and the cycle objects.
	 */
	public void gameInit(){
		map = new Map();
		map.setDefaultMap();
		mapPanel= Frame.start(map);
	}
	
	/**
	 * This will start the game.  
	 * This method kicks off a timer which will call MapPanel.updatePanel()
	 * through the GameTimer class.  This is run every 33 ms.  
	 * 33 ms was chosen as this corresponds to 30 frames per second, 
	 * which is a standard for gaming.
	 */
	public void gameStart(){
		timer = new Timer(33, new GameTimer(mapPanel));
		timer.start();
	}
	
	/**
	 * A call to this will stop the timer.  
	 * When the timer is stopped the player positions stop updating.  
	 * This will effectively end the game.
	 */
	public static void gameEnd(){
		timer.stop();
	}
}