import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu implements ActionListener{

	//panels and such
	JFrame menuFrame;
	JButton singlePlayer, multiPlayer;
	JButton[] gameModes = new JButton[2];
	
	
	//font and color management
	Font mainFont = new Font("Verdana", Font.PLAIN, 30);
	Color menuGray = new Color(60,60,60);
	Color buttonDarkGrayColor = new Color(30,30,30);
	Color buttonTextWhite = new Color(200,200,200);
	
	
	//constructor for main menu
	MainMenu(){
		menuFrame = new JFrame("Main Menu");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(600, 600);
		menuFrame.setLayout(null);
		menuFrame.getContentPane().setBackground(menuGray);
		menuFrame.setVisible(true);
		
		
		//menu buttons
		singlePlayer = new JButton("Single Player");
		multiPlayer = new JButton("Two Players");
		gameModes[0] = singlePlayer;
		gameModes[1] = multiPlayer;
		for(int i = 0; i < 2; i++) {
			gameModes[i].setBackground(buttonDarkGrayColor);
			gameModes[i].setForeground(buttonTextWhite);
			gameModes[i].setFont(mainFont);
			gameModes[i].addActionListener(this);
		}
		
		singlePlayer.setBounds(100, 125, 400, 150);
		multiPlayer.setBounds(100, 300, 400, 150);
		menuFrame.add(singlePlayer);
		menuFrame.add(multiPlayer);
	}
	
	
	
	public static void main(String[] args) {
		MainMenu menu = new MainMenu();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

