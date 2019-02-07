package Panel;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.UnsupportedEncodingException;

import javax.swing.JPanel;

public class GameOverPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainFrame m = null;
	
	private boolean isSuccess = false;
	private int score = 0;
	private int highScore = 0;
	
	public GameOverPanel(MainFrame m, boolean isSuccess, int score, int highScore) {
		
		this.m = m;
		
		this.isSuccess = isSuccess;
		this.score = score;
		this.highScore = highScore;
		
		setBackground(Color.BLACK);
	    setLayout(null);
	}
	   
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	      
	    g.setColor(Color.white);
	    g.setFont(new Font("Arial",Font.BOLD,50));
	    if(isSuccess) {
	    	try {
				m.playMusic(9);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	g.drawString("ALL CLEAR!!", 100, 120);
	    }
	    else
	    	g.drawString("GAME OVER", 100, 120);
	      
	    g.setColor(Color.darkGray);
	    g.setFont(new Font("Arial",Font.BOLD,20));
	    g.drawString("HIGH SCORE : " + highScore, 130, 250);
	    g.drawString("YOUR SCORE : " + score, 120, 270);
	      
	    g.setColor(Color.RED);
	    g.setFont(new Font("Arial",Font.BOLD,25));
	    g.drawString("PRESS SPACEBAR", 120, 400);
	      
	}
}
