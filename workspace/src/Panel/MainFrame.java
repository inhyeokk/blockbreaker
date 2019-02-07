package Panel;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class MainFrame extends JFrame implements KeyListener {
   
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private InitialPanel initialPanel = null;
	private GamePanel gamePanel = null;
	private GameOverPanel gameOverPanel = null;
   
	private int pageFLG = 1;
	private int roundFLG = 1;
	
	private int score = 0;
	private int highScore = 0;
   
	private Clip clip = null;
   
	public MainFrame() {
		setTitle("º®µ¹±ú±â");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		addKeyListener(this);
		
		change(false, pageFLG);
		
		pack();
		setVisible(true);
	}
	
	public void setNextPage(boolean isSuccess) {
		pageFLG += 1;
		if(highScore < score)
			highScore = score;
		change(isSuccess, pageFLG);
	}
	
	public void clearPage() {
		pageFLG = 1;
		roundFLG = 1;
		score = 0;
		change(false, pageFLG);
	}
	
	public void setNextRound() {
		roundFLG += 1;
		if(highScore < score)
			highScore = score;
		change(false, pageFLG);
	}
	
	public void plusScore(int score) {
		this.score += score;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public void change(boolean isSuccess, int i) {
		if(i == 1) {
			initialPanel  = new InitialPanel(this);
			getContentPane().removeAll();
			getContentPane().add(initialPanel);
		} else if(i == 2) {
			gamePanel = new GamePanel(this, roundFLG);
			getContentPane().removeAll();
			getContentPane().add(gamePanel);
		} else if(i == 3) {
			gameOverPanel  = new GameOverPanel(this, isSuccess, score, highScore);
			getContentPane().removeAll();
			getContentPane().add(gameOverPanel);
		}
		revalidate();
		repaint();
	}
	
	public void playMusic(int order) throws UnsupportedEncodingException {
		
		File f = null;
		//String path1 = MainFrame.class.getClassLoader().getResource("").getPath();
		//System.out.println(path1);
		String path = MainFrame.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decodedPath = URLDecoder.decode(path, "UTF-8");
		System.out.println(decodedPath);
		
		String subPath = "../res/music";
		
		if(order == 1)
			f = new File(decodedPath + subPath + "/title.wav");
		else if(order == 2)
			f = new File(decodedPath + subPath + "/loop.wav");
		else if(order == 3)
			f = new File(decodedPath + subPath + "/ping.wav");
		else if(order == 4)
			f = new File(decodedPath + subPath + "/ping2.wav");
		else if(order == 5)
			f = new File(decodedPath + subPath + "/pong.wav");
		else if(order == 6)
			f = new File(decodedPath + subPath + "/dead.wav");
		else if(order == 9)
			f = new File(decodedPath + subPath + "/stageclear.wav");
	   
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(f);
			clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
   
	public void stopMusic() {
		if(clip != null) {
			clip.stop();
			clip = null;
		}
	}
   
	public static void main(String[] args) {
	   
		new MainFrame(); 
	}

	@Override
	public void keyPressed(KeyEvent e) {
	   
		switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				if(pageFLG == 1) {
					pageFLG += 1;
	        		change(false, pageFLG);
	        	}
	        	if(pageFLG == 3)
	        		clearPage();
	        	break;
	        	
	        case KeyEvent.VK_LEFT:
	        	if(pageFLG == 2)
	        		gamePanel.setVx(-10);
	        	break;
	        	
	        case KeyEvent.VK_RIGHT:
	        	if(pageFLG == 2)
	        		gamePanel.setVx(10);
	        	break;
	        	
	        default:   break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	   
		switch(e.getKeyCode()) {
	   
			case KeyEvent.VK_LEFT:
				if(pageFLG == 2)
	        		gamePanel.setVx(0);
	        	break;
	        	
	        case KeyEvent.VK_RIGHT:
	        	if(pageFLG == 2)
	        		gamePanel.setVx(0);
		        break;
	        
	        default:
	        	break;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	   
	}
}
