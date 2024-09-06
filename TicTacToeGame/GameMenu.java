import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameMenu extends JFrame{
	
	//panels and such
	JFrame gameFrame;
	JPanel gamePanel;
	
	//fonts and color management 
	Font mainFont = new Font("Verdana", Font.PLAIN, 30);
	
	Color menuGray = new Color(60,60,60);
	Color buttonLightGray = new Color(90,90,90);
	Color buttonTextBlack = new Color(5,5,5);
	Color darkGrayColor = new Color(35,35,35); 
	
	//constructor
	public GameMenu(Point location) {
		 //Generate Frame
		gameFrame = new JFrame("Game");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(600, 625); //+25 for title bar
		gameFrame.setLayout(null);
		gameFrame.getContentPane().setBackground(menuGray);
		gameFrame.setResizable(false);
		gameFrame.setLocation(location);
		gameFrame.setVisible(true);
		
		//generate main game panel
		gamePanel = new JPanel();
		gamePanel.setBounds(50, 50, 100, 100);
		gamePanel.setLayout(new GridLayout());
		gamePanel.setBackground(darkGrayColor);

		

	}
}

