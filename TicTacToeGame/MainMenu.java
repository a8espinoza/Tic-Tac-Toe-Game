import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu implements ActionListener{

	//panels and such
	JFrame menuFrame;
	JButton singlePlayer, multiPlayer;
	JButton[] gameModes = new JButton[2];
	Point location;

	
	
	//font and color management
	Font mainFont = new Font("Verdana", Font.PLAIN, 30);
	Color menuGray = new Color(60,60,60);
	Color buttonLightGray = new Color(90,90,90);
	Color buttonTextBlack = new Color(5,5,5);
	Color darkGrayColor = new Color(35,35,35); 	
	
	//constructor for main menu
	MainMenu(){
		menuFrame = new JFrame("Main Menu");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(600, 625); //+25 for title bar
		menuFrame.setResizable(false);
		menuFrame.setLayout(null);
		menuFrame.getContentPane().setBackground(menuGray);
		menuFrame.setVisible(true);
		menuFrame.setLocationRelativeTo(null);
		
		
		//menu buttons
		singlePlayer = new JButton("Single Player");
		multiPlayer = new JButton("Two Players");
		gameModes[0] = singlePlayer;
		gameModes[1] = multiPlayer;
		for(int i = 0; i < 2; i++) {
			gameModes[i].setBackground(buttonLightGray);
			gameModes[i].setForeground(buttonTextBlack);
			gameModes[i].setFont(mainFont);
			gameModes[i].addActionListener(this);
			gameModes[i].setBorderPainted(false);
			gameModes[i].setFocusable(false);
		}
		
		singlePlayer.setBounds(100, 125, 400, 150);
		multiPlayer.setBounds(100, 300, 400, 150);
		menuFrame.add(singlePlayer);
		menuFrame.add(multiPlayer);
	}
	
	
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MainMenu menu = new MainMenu();
		//GameMenu game = new GameMenu(null);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//2 player mode
		if(e.getSource() == multiPlayer) {
			location = menuFrame.getLocation();
			@SuppressWarnings("unused")
			GameMenu gameMenu = new GameMenu(location, 1, 0, 0);
			menuFrame.setVisible(false); //disable for comparison
		}

		//1 player mode
		if(e.getSource() == singlePlayer) {
			location = menuFrame.getLocation();
			@SuppressWarnings("unused")
			GameMenu gameMenu = new GameMenu(location, 1, 0, 0);
			menuFrame.setVisible(false); //disable for comparison
		}
	}

}

