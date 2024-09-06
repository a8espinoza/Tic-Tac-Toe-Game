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
	
	//constructor for main menu
	MainMenu(){
		menuFrame = new JFrame("Main Menu");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(600, 600);
		menuFrame.setLayout(null);
		menuFrame.getContentPane().setBackground(menuGray);
	}
	
	
	public static void main(String[] args) {
		MainMenu menu = new MainMenu();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

