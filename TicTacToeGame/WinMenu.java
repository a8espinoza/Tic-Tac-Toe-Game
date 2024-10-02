import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class WinMenu extends JFrame implements ActionListener{
	//panels and such
	JFrame winFrame;
	JTextField winField;
	
	//fonts and color management 
		Font mainFont = new Font("Verdana", Font.PLAIN, 30);
		
		Color menuGray = new Color(60,60,60);
		Color buttonLightGray = new Color(90,90,90);
		Color buttonTextBlack = new Color(5,5,5);
		Color darkGrayColor = new Color(35,35,35); 

	
	public WinMenu(Point location) {
		winFrame = new JFrame("Winner!");
		winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winFrame.setSize(600, 620); //+25 for title bar
		winFrame.setLayout(null);
		winFrame.getContentPane().setBackground(menuGray);
		winFrame.setResizable(false);
		winFrame.setLocation(location);
		winFrame.setVisible(true);
		
		winField = new JTextField();
		winField.setBounds(100, 100, 100, 100);
		winField.setEditable(false);
		winField.setBackground(new Color(104,116,85));
		winField.setForeground(new Color(56,63,47));
		winField.setText("!!YOU WIN!!");
		
		winFrame.add(winField);


	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
