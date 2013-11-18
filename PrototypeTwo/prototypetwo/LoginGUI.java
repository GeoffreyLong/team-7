package prototypetwo;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

public class LoginGUI extends JPanel implements ActionListener{
	
	private JLabel title;
	private JLabel username;
	private JTextField usernameField;
	private JLabel password;
	private JPasswordField passwordField;
	private JButton login;	

	
	public LoginGUI(){
		makeComponents();
		makeLayout();
	}
	
	private void makeComponents(){

		title = new JLabel("Login to your account");
		title.setFont(new Font("Times", Font.BOLD, 37));
		title.setBounds(90, 10, 510, 45);
		
		username = new JLabel("Username : ");
		username.setFont(new Font("Times", Font.BOLD, 18));
		username.setBounds(20, 170, 140, 25);
		
		usernameField = new JTextField(40);
		usernameField.setBounds(130, 170, 170, 25);
		
		password = new JLabel("Password : ");
		password.setFont(new Font("Times", Font.BOLD, 18));
		password.setBounds(20, 200, 140, 25);
		
		passwordField = new JPasswordField(40);
		passwordField.setBounds(130, 200, 170, 25);
		
		login = new JButton("Login");
		login.setBounds(130, 230, 100, 30);
		login.addActionListener(this);
		
	}
	
	private void makeLayout(){
		setLayout(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}


}
