import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameMenu extends JFrame implements ActionListener{
	
	//panels and such
	JFrame gameFrame;
	JPanel gameboard;
	JButton a1, a2, a3, b1, b2, b3, c1, c2, c3;
	JButton[] tiles = new JButton[9];
	
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
		gameFrame.setSize(600, 620); //+25 for title bar
		gameFrame.setLayout(null);
		gameFrame.getContentPane().setBackground(menuGray);
		gameFrame.setResizable(false);
		gameFrame.setLocation(location);
		gameFrame.setVisible(true);
		
		//generate main game panel
		gameboard = new JPanel();
		gameboard.setBounds(50, 90, 450, 450);
		gameboard.setLayout(new GridLayout(3, 3, 10, 10));
		gameboard.setBackground(darkGrayColor);
		
		//generate game tiles
		a1 = new JButton(" ");
		a2 = new JButton();
		a3 = new JButton();
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		c1 = new JButton();
		c2 = new JButton();
		c3 = new JButton();
		
		tiles[0] = a1;
		tiles[1] = b1;
		tiles[2] = c1;
		tiles[3] = a2;
		tiles[4] = b2;
		tiles[5] = c2;
		tiles[6] = a3;
		tiles[7] = b3;
		tiles[8] = c3;
		
		for(int i=0; i<9; i++) {
			tiles[i].addActionListener(this);
			tiles[i].setFocusable(false);
			tiles[i].setBackground(buttonLightGray);
			tiles[i].setBorderPainted(false);
		}

		

		//add tiles to panel, then panel to frame
		gameboard.add(a1);
		gameboard.add(b1);
		gameboard.add(c1);
		gameboard.add(a2);
		gameboard.add(b2);
		gameboard.add(c2);
		gameboard.add(a3);
		gameboard.add(b3);
		gameboard.add(c3);

		
		gameFrame.add(gameboard);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

