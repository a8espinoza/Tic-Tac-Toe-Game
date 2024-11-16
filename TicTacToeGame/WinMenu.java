import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class WinMenu extends JFrame implements ActionListener{
	//panels and such
	JFrame winFrame;
	JTextField winField;
	JButton newGameButton;
	Point location;
	int gameNum, player1Score, player2Score; 
	
	//fonts and color management 
		Font mainFont = new Font("Verdana", Font.PLAIN, 30);
		Font subFont = new Font("Verdana", Font.PLAIN, 20);

		
		Color menuGray = new Color(60,60,60);
		Color buttonLightGray = new Color(90,90,90);
		Color buttonTextBlack = new Color(5,5,5);
		Color darkGrayColor = new Color(35,35,35); 

	
	public WinMenu(Point location, Boolean winningPlayer, int gameNum, int player1Score, int player2Score) {
		this.gameNum = gameNum;
		this.player1Score = player1Score;
		this.player2Score = player2Score;
		
		winFrame = new JFrame("Winner!");
		winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winFrame.setSize(600, 620); //+25 for title bar
		winFrame.setLayout(null);
		winFrame.getContentPane().setBackground(menuGray);
		winFrame.setResizable(false);
		winFrame.setLocation(location);
		winFrame.setVisible(true);
		
		winField = new JTextField();
		winField.setBounds(150, 200, 300, 100);
		winField.setEditable(false);
		winField.setBackground(buttonLightGray);
		winField.setForeground(buttonTextBlack);
		winField.setFont(mainFont);
		winField.setBorder(new EmptyBorder(0, 0, 0, 0));
		winField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		
		newGameButton = new JButton();
		newGameButton.setBackground(buttonLightGray);
		newGameButton.setForeground(buttonTextBlack);
		newGameButton.setFont(mainFont);
		newGameButton.addActionListener(this);
		newGameButton.setBorderPainted(false);
		newGameButton.setFocusable(false);
		newGameButton.setBounds(150, 350, 300, 100);
		newGameButton.setText("Play Again?");

		
		//case for player 2 (because it switches before checking)
		if(winningPlayer) {
			winField.setText("!!Player 2 WINS!!");
			this.player2Score++;
		//case for player 1
		}else {
			winField.setText("!!Player 1 WINS!!");
			this.player1Score++;
		}
		
		
		
		winFrame.add(winField);
		winFrame.add(newGameButton);

		System.out.println("WinMenu: gameNum: " + this.gameNum + " player1Score: "+ this.player1Score+ " player2Score: "+this.player2Score);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGameButton) {
			location = winFrame.getLocation();
			GameMenu newGameMenu = new GameMenu(location, ++gameNum, player1Score, player2Score);
			winFrame.setVisible(false);
		}
		
	}

}
