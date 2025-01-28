import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InterruptedIOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class GameMenu extends JFrame implements ActionListener{
	
	//panels and such
	JFrame gameFrame;
	JPanel gameboard;
	JButton a1, a2, a3, b1, b2, b3, c1, c2, c3;
	JButton[] tiles = new JButton[9];
	JTextField playerTurnField;
	JTextField gameNumField, scoreField;
	JTextField[] textFields = new JTextField[3];
	boolean playerTurn; //true = p1, false = p2
	boolean winner, tie;
	GameFunction functionalGame = new GameFunction();
	int player1, player2, mode;
	int gameNum, player1Score, player2Score;
	Point location;
	
	
	//fonts and color management 
	Font mainFont = new Font("Verdana", Font.PLAIN, 30);
	Font subFont = new Font("Verdana", Font.PLAIN, 20);
	Font buttonFont = new Font("Verdana", Font.PLAIN, 75);
	
	Color menuGray = new Color(60,60,60);
	Color buttonLightGray = new Color(90,90,90);
	Color buttonTextBlack = new Color(5,5,5);
	Color darkGrayColor = new Color(35,35,35); 
	
	//constructor
	public GameMenu(Point location, int gameNum, int player1Score, int player2Score, int mode) {
		this.gameNum = gameNum;
		this.player1Score = player1Score;
		this.player2Score = player2Score;
		//Mode: 2 = 2 player, 1 = single player
		this.mode = mode;
		
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
		a1 = new JButton();
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
			tiles[i].setBorder(new EmptyBorder(0, 0, 0, 0));
			tiles[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
			tiles[i].setFont(buttonFont);

			
		}
		
		//All Text fields
		playerTurnField = new JTextField();
		gameNumField = new JTextField();
		scoreField = new JTextField(); 
		//gameNum = 1;

		textFields[0] = playerTurnField;
		textFields[1] = gameNumField;
		textFields[2] = scoreField;
		
		for(int i=0; i<3; i++) {
			textFields[i].setEditable(false);
			textFields[i].setBackground(buttonLightGray);
			textFields[i].setForeground(buttonTextBlack);
			textFields[i].setBorder(new EmptyBorder(0, 0, 0, 0));
			textFields[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
			textFields[i].setFont(subFont);
		}
		//playerTurnField
		playerTurnField.setBounds(50, 25, 125, 50);
		playerTurnField.setText("Player 1");
		playerTurn = true;
		//gameNumField
		gameNumField.setBounds(200, 25, 125, 50);
		gameNumField.setText("Game: " + this.gameNum);
		//scoreField
		scoreField.setBounds(350, 25, 125, 50);
		scoreField.setText(this.player1Score + " to " + this.player2Score);



		

		//add tiles to panel, then panel to frame
		gameboard.add(a1); 			//	  a b c 
		gameboard.add(b1);			//	 1	
		gameboard.add(c1);			//	 2
		gameboard.add(a2);			//	 3
		gameboard.add(b2);
		gameboard.add(c2);
		gameboard.add(a3);
		gameboard.add(b3);
		gameboard.add(c3);

		
		gameFrame.add(gameboard);
		gameFrame.add(playerTurnField);
		gameFrame.add(gameNumField);
		gameFrame.add(scoreField);
		
		player1 = 1;
		player2 = 2;
		winner = false;
		
		System.out.println("GameMenu: gameNum: " + this.gameNum + " player1Score: "+ this.player1Score+ " player2Score: "+this.player2Score);

	}
	
	public void checkForWinner(boolean winner) {
		if(winner) {
			//do other winner work here
			for(int i=0; i<9; i++) {
				tiles[i].setEnabled(false);
			}
			System.out.println("Winner found"); //print in terminal
			
			//open win menu
			location = gameFrame.getLocation();
			//2 player winscreen 
			if(mode == 2){
				WinMenu winMenu = new WinMenu(location, playerTurn, gameNum, player1Score, player2Score, false);
				gameFrame.setVisible(false); //disable for comparison
			//Single player win screen (STILL NEED TO EDIT)
			}else{
				WinMenu winMenu = new WinMenu(location, playerTurn, gameNum, player1Score, player2Score, false);
				gameFrame.setVisible(false); //disable for comparison
			}

		}
	}
	
	public void checkForTie(boolean tie) {
		if(tie) {
			System.out.println("Game ends in Tie!"); //in terminal
			
			//open win menu with no winner
			location = gameFrame.getLocation();

						//STILL NEED TO EDIT!!!!
			//2 player tie screen
			if(mode == 2){
				WinMenu tieMenu = new WinMenu(location, playerTurn, gameNum, player1Score, player2Score, true);
				gameFrame.setVisible(false);
	
			//single player tie screen
			}else{
				WinMenu tieMenu = new WinMenu(location, playerTurn, gameNum, player1Score, player2Score, true);
				gameFrame.setVisible(false);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//9 primary  buttons
		if(e.getSource() == a1) {			
			//game functionality
			if(playerTurn) { 		//player 1
				a1.setText("X");
				winner = functionalGame.nextTurn(player1, 0, 0);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 2");
			}else {					//player 2
				a1.setText("O");
				winner = functionalGame.nextTurn(player2, 0, 0);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 1");
			}
			
			//edit button and check for winner and tie
			tie = functionalGame.checkForTie(winner);
			checkForTie(tie);

			a1.setEnabled(false);
			checkForWinner(winner);

		}
		
		if(e.getSource() == b1) {
			//change button
			b1.setEnabled(false);
			
			//game functionality
			if(playerTurn) { 		//player 1
				b1.setText("X");
				winner = functionalGame.nextTurn(player1, 0, 1);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 2");
			}else {					//player 2
				b1.setText("O");
				winner = functionalGame.nextTurn(player2, 0, 1);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 1");
			}
			
			//Single player mode: AI functionality
			if(mode == 2 && playerTurn == false){
				//AI Shit here
			}

			//edit button and check for winner after each action
			tie = functionalGame.checkForTie(winner);
			checkForTie(tie);

			b1.setEnabled(false);
			checkForWinner(winner);
		}

		if(e.getSource() == c1) {
			//change button
			c1.setEnabled(false);
			
			//game functionality
			if(playerTurn) { 		//player 1
				c1.setText("X");
				winner = functionalGame.nextTurn(player1, 0, 2);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 2");
			}else {					//player 2
				c1.setText("O");
				winner = functionalGame.nextTurn(player2, 0, 2);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 1");
			}
			
			//edit button and check for winner
			tie = functionalGame.checkForTie(winner);
			checkForTie(tie);

			c1.setEnabled(false);
			checkForWinner(winner);
		}

		if(e.getSource() == a2) {
			//change button
			a2.setEnabled(false);
			
			//game functionality
			if(playerTurn) { 		//player 1
				a2.setText("X");
				winner = functionalGame.nextTurn(player1, 1, 0);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 2");
			}else {					//player 2
				a2.setText("O");
				winner = functionalGame.nextTurn(player2, 1, 0);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 1");
			}
			
			//edit button and check for winner
			tie = functionalGame.checkForTie(winner);
			checkForTie(tie);

			a2.setEnabled(false);
			checkForWinner(winner);
		}

		if(e.getSource() == b2) {
			//change button
			b2.setEnabled(false);
			
			//game functionality
			if(playerTurn) { 		//player 1
				b2.setText("X");
				winner = functionalGame.nextTurn(player1, 1, 1);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 2");
			}else {					//player 2
				b2.setText("O");
				winner = functionalGame.nextTurn(player2, 1, 1);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 1");
			}
			
			//edit button and check for winner
			tie = functionalGame.checkForTie(winner);
			checkForTie(tie);

			b2.setEnabled(false);
			checkForWinner(winner);
		}

		if(e.getSource() == c2) {
			//change button
			c2.setEnabled(false);
			
			//game functionality
			if(playerTurn) { 		//player 1
				c2.setText("X");
				winner = functionalGame.nextTurn(player1, 1, 2);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 2");
			}else {					//player 2
				c2.setText("O");
				winner = functionalGame.nextTurn(player2, 1, 2);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 1");
			}
			
			//edit button and check for winner
			tie = functionalGame.checkForTie(winner);
			checkForTie(tie);

			c2.setEnabled(false);
			checkForWinner(winner);
		}

		if(e.getSource() == a3) {
			//change button
			a3.setEnabled(false);
			
			//game functionality
			if(playerTurn) { 		//player 1
				a3.setText("X");
				winner = functionalGame.nextTurn(player1, 2, 0);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 2");
			}else {					//player 2
				a3.setText("O");
				winner = functionalGame.nextTurn(player2, 2, 0);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 1");
			}
			
			//edit button and check for winner
			tie = functionalGame.checkForTie(winner);
			checkForTie(tie);

			a3.setEnabled(false);
			checkForWinner(winner);
		}

		if(e.getSource() == b3) {
			//change button
			b3.setEnabled(false);
			
			//game functionality
			if(playerTurn) { 		//player 1
				b3.setText("X");
				winner = functionalGame.nextTurn(player1, 2, 1);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 2");
			}else {					//player 2
				b3.setText("O");
				winner = functionalGame.nextTurn(player2, 2, 1);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 1");
			}
			
			//edit button and check for winner
			tie = functionalGame.checkForTie(winner);
			checkForTie(tie);

			b3.setEnabled(false);
			checkForWinner(winner);
		}

		if(e.getSource() == c3) {
			//change button
			c3.setEnabled(false);
			
			//game functionality
			if(playerTurn) { 		//player 1
				c3.setText("X");
				winner = functionalGame.nextTurn(player1, 2, 2);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 2");
			}else {					//player 2
				c3.setText("O");
				winner = functionalGame.nextTurn(player2, 2, 2);
				playerTurn = !playerTurn;
				playerTurnField.setText("Player 1");
			}
			
			//edit button and check for winner
			tie = functionalGame.checkForTie(winner);
			checkForTie(tie);

			c3.setEnabled(false);
			checkForWinner(winner);
		}

		
	}
}

