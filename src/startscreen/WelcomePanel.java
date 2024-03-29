package startscreen;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import start.Frame;

public class WelcomePanel extends JPanel {
	private JLabel welcome;
	private JLabel instructions;
	
	public WelcomePanel(){
		setBackground(Color.black);
		initComponents();
		initLayout();
	}	
	private void initComponents(){
		welcome = new JLabel("Welcome to Tron!!!!");
		welcome.setFont(new Font("Apple Color Emoji", Font.BOLD, 64));
		welcome.setForeground(new Color(142,229,238));
		
		instructions = new JLabel("Press \u2191 button when you are ready to go...");
		instructions.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 27));
		instructions.setForeground(new Color(240, 255, 255));
		instructions.setToolTipText("\u2191");
	}
	private void initLayout(){
		setBounds(-1,0,Frame.getXSize(),Frame.getYSize()/6);
		setBorder(BorderFactory.createLineBorder(new Color(0xD4FFFF)));
		
		add(welcome, "cell 0 0, alignx center, growy");
		add(instructions, "cell 1 0,alignx center,growy");
		
		setVisible(true);
	}
}
