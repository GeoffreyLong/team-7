package prototypetwo;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoggedIn extends JPanel implements ActionListener{
	
	private JLabel username;
	private JButton back;
	private Players player;
	
	public LoggedIn(String username, Players player){
		this.player = player;
		setBorder(BorderFactory.createLineBorder(Color.black));
		makeComponents(username);
		makeLayout();
	}
	
	private void makeComponents(String username){
		this.username = new JLabel("Welcome " + username + "!");
		this.username.setFont(new Font("Times", Font.BOLD, 30));
		this.username.setBounds(140, 200, 400, 50);
		
		back = new JButton("Back");
		back.setBounds(20, 500, 80, 30);
		back.addActionListener(this);
		
	}
	
	private void makeLayout(){
		setLayout(null);
		add(username);
		add(back);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == back){
			WelcomeScreen welcome = new WelcomeScreen(player);
			Frame.removePanel(this);
			if (player == Players.ONE){
				welcome.setBounds(0,0,Frame.getXSize()/2, Frame.getYSize());
			}
			else{
				welcome.setBounds(Frame.getXSize()/2,0,Frame.getXSize()/2, Frame.getYSize());
			}
			Frame.addPanel(welcome);
		}
		
	}

}
