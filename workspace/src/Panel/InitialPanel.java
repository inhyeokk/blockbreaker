package Panel;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.UnsupportedEncodingException;

import javax.swing.JPanel;

public class InitialPanel extends JPanel {
	   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InitialPanel(MainFrame m) {
		try {
			m.playMusic(1);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setPreferredSize(new Dimension(540, 500));
		setBackground(Color.BLACK);
		setLayout(null);
	}
	   
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.drawString("Java Progaming", 160, 100);
		g.drawString("Homework #5", 180, 150);
	      
		g.setFont(new Font("Arial",Font.BOLD,50));
		g.drawString("BLOCK BREAKER", 35, 270);
	      
		g.setColor(Color.RED);
		g.setFont(new Font("Arial",Font.ITALIC,15));
		g.drawString("PRESS SPACEBAR TO PLAY", 160, 400);
	}
}
