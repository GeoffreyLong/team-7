package startscreen;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import start.Frame;

public class PlayerPanel extends JPanel{
	public PlayerPanel(int playerNum){
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(null);
		setVisible(true);
		
		JLabel playerLabel;
		if (playerNum==1){
			setBounds(-1,Frame.getYSize()/4,Frame.getXSize()/2,3*Frame.getYSize()/4);
			playerLabel = new JLabel("PLAYER ONE");
		}
		else{
			setBounds(Frame.getXSize()/2-1,Frame.getYSize()/4,Frame.getXSize()/2,3*Frame.getYSize()/4);
			playerLabel = new JLabel("PLAYER TWO");
		}
		
		playerLabel.setBounds(50,30,300,60);
		add(playerLabel);
	}
}
