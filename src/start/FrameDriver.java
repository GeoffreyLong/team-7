package start;

import java.awt.Component;
import java.sql.Connection;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import game.EndScreen;
import game.GameSetup;
import game.MapChooser;
import game.SetupPanel;
import gameplay.ExplosionPanel;
import gameplay.MapPanel;
import startscreen.PlayerOnePanel;
import startscreen.PlayerPanel;
import startscreen.PlayerTwoPanel;
import startscreen.ReadyActionListener;
import startscreen.WelcomePanel;
import statistics.AllStatsPanel;
import statistics.TopTenPanel;
import statistics.HeadToHead;
import user.CreateUser;
import user.LoginGUI;
import user.Player;

public class FrameDriver {
	static Frame frame;
	static WelcomePanel welcome;
	static PlayerPanel paneOne;
	static PlayerPanel paneTwo;
	static GameSetup setup;
	static SetupPanel setupPanel;
	static CreateUser createOne;
	static CreateUser createTwo;
	static LoginGUI loginOne;
	static LoginGUI loginTwo;
	static MapChooser choose;
	static EndScreen endScreen;
	public static PlayerOnePanel pane1;
	public static PlayerTwoPanel pane2;
	
	
	public FrameDriver(Frame frame){
		this.frame = frame;
	}
	public void init(){
		welcome = new WelcomePanel();
		welcome.setVisible(false);
		paneOne = new PlayerOnePanel(Main.playerOne);
		paneOne.setVisible(false);
		paneTwo = new PlayerTwoPanel(Main.playerTwo);
		paneTwo.setVisible(false);
		ReadyActionListener listen = new ReadyActionListener(paneOne, paneTwo);
		
		setup = new GameSetup(Main.playerOne, Main.playerTwo);
		setupPanel = new SetupPanel(Main.playerOne, Main.playerTwo, setup);
		setupPanel.setVisible(false);
		
		choose = new MapChooser(setupPanel);
		choose.setBounds(0,0,Frame.getXSize(), Frame.getYSize());
		choose.setVisible(false);
		
		createOne = new CreateUser(Main.playerOne);
		createOne.setBounds(-1,Frame.getYSize()/4,Frame.getXSize()/2,3*Frame.getYSize()/4);
		createOne.setVisible(false);

		createTwo = new CreateUser(Main.playerTwo);
		createTwo.setBounds(Frame.getXSize()/2-1,Frame.getYSize()/4,Frame.getXSize()/2,3*Frame.getYSize()/4);
		createTwo.setVisible(false);
		
		loginOne = new LoginGUI(Main.playerOne);
		loginOne.setBounds(-1,Frame.getYSize()/4,Frame.getXSize()/2,3*Frame.getYSize()/4);
		loginOne.setVisible(false);

		loginTwo = new LoginGUI(Main.playerTwo);
		loginTwo.setBounds(Frame.getXSize()/2-1,Frame.getYSize()/4,Frame.getXSize()/2,3*Frame.getYSize()/4);
		loginTwo.setVisible(false);
		
		endScreen = new EndScreen();
		endScreen.setBounds(0,0,Frame.getXSize(), Frame.getYSize());
		endScreen.setVisible(false);
		
		frame.addPanel(paneOne);
		frame.addPanel(paneTwo);
		frame.addPanel(welcome);
		frame.addPanel(setupPanel);
		frame.addPanel(createOne);
		frame.addPanel(createTwo);
		frame.addPanel(loginOne);
		frame.addPanel(loginTwo);
		frame.addPanel(choose);
		frame.addPanel(endScreen);
	}
	public static void mainMenu(){
		hideAll();
		paneOne.setVisible(true);
		paneTwo.setVisible(true);
		welcome.setVisible(true);
	}
	public static void startGameSetup(){
		hideAll();
		setupPanel.setVisible(true);
	}
	public static void createAccount(Player player){
		if (player.getPlayerNumber() == 1){
			paneOne.setVisible(false);
			createOne.setVisible(true);
		}
		else{
			paneTwo.setVisible(false);
			createTwo.setVisible(true);
		}
	}
	public static void login(Player player){
		if (player.getPlayerNumber() == 1){
			loginOne.setVisible(true);
			paneOne.setVisible(false);
		}
		else{
			loginTwo.setVisible(true);
			paneTwo.setVisible(false);
		}
	}
	public static void endGame(int pOneWins, int pTwoWins, int gamesPlayed){
		hideAll();
		endScreen.initComponents();
		endScreen.initLayout();
		endScreen.setPOneWins(pOneWins);
		endScreen.setPTwoWins(pTwoWins);
		endScreen.setGamesPlayed(gamesPlayed);
		endScreen.updatePanel();
		endScreen.setVisible(true);
	}
	
	public static void setPaneOne(Player player){
		loginOne.setVisible(false);
		
		pane1 = new PlayerOnePanel(player);
		pane1.setUser();
		frame.addPanel(pane1);
		pane1.setVisible(true);
		
	}
	
	public static void setPaneTwo(Player player){
		loginTwo.setVisible(false);
		
		pane2 = new PlayerTwoPanel(player);
		pane2.setUser();
		frame.addPanel(pane2);
		pane2.setVisible(true);
	}
	
	public static void Statistics(){
		Connection conn = Connect.connect();
		
		JFrame newFrame = new JFrame("View All Statistics");
		JScrollPane scrollPane = new JScrollPane(new AllStatsPanel(conn));  
		newFrame.getContentPane().add(scrollPane);  
		newFrame.setSize(500, 480);  
		newFrame.setVisible(true); 
	}
	
	public static void HeadToHead(String username1, String username2){
		Connection conn = Connect.connect();
		
		JFrame newFrame = new JFrame("View Head To Head Score");
		JScrollPane scrollPane = new JScrollPane(new HeadToHead(conn, username1, username2));  
		newFrame.getContentPane().add(scrollPane);  
		newFrame.setSize(500, 480);  
		newFrame.setVisible(true);
	}
	
	public static void TopTen(){
		Connection conn = Connect.connect();
		
		JFrame newFrame = new JFrame("View Top Ten");
		JScrollPane scrollPane = new JScrollPane(new TopTenPanel(conn));  
        	newFrame.getContentPane().add(scrollPane);  
        	newFrame.setSize(500, 480);  
        	newFrame.setVisible(true);
	}
	
	
	public static void mapChooser(){
		choose.setVisible(true);
		setupPanel.setVisible(false);
	}
	public static void hideAll(){
		//TODO may want to check to make sure that i is a jpanel
		
		for (Component i : Frame.frame.getContentPane().getComponents()){
			i.setVisible(false);
		}
	}
	public static void startGame(MapPanel mapPanel){
	    FrameDriver.hideAll();
	    frame.addPanel(mapPanel);
	}
	public static void explosion(ExplosionPanel exp, int xOffset, int yOffset){
		exp.setBounds(0,0,Frame.getXSize(), Frame.getYSize());
		frame.addPanel(exp);
	}
	public static void removePanel(JPanel panel){
		frame.removePanel(panel);
	}
}
