package Panel;

import java.awt.Graphics;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

import Object.BoundaryBlock;
import Object.MyBall;
import Object.MyObject;
import Object.NormalBlock;
import Object.RacketBlock;
import Object.SpecialBlock;
import Object.TargetBlock;

public class GamePanel extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CopyOnWriteArrayList<MyObject> obj = new CopyOnWriteArrayList<MyObject>();
	
	private MainFrame m = null;

	private float vx=0;
	
	private RacketBlock block = null;
	private int blockX = 20;
	
	private boolean stop = false;
	private int round = 1;
	
	public GamePanel(MainFrame m, int round) {
		
		this.m = m;
		this.round = round;
		m.stopMusic();
		
		obj.add(new BoundaryBlock(0,0,540,20));
	    obj.add(new BoundaryBlock(0,480,540,20));
	    obj.add(new BoundaryBlock(0,0,20,500));
	    obj.add(new BoundaryBlock(520,0,20,500));  
	    
	    block = new RacketBlock(220,400,100,20);
	    obj.add(block);

		obj.add(new MyBall(m));
		
		if(round == 1)
			setRound1();
		else if(round == 2) {
			try {
				m.playMusic(9);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setRound2();
		}
		else if(round == 3) {
			try {
				m.playMusic(9);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setRound3();
		}
		Thread t = new Thread(this);
		t.start();
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void setVx(float _vx) {
		this.vx = _vx;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (MyObject o : obj)
			o.draw(g);
	}

	@Override
	public void run() {
		while (!stop) {
			double dt = 0.033;
			try {
				Thread.sleep((int) (dt * 300));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (MyObject o : obj)
				o.update(dt);

			for (MyObject o : obj)
				if (o instanceof MyBall)
					for (MyObject b : obj) {
						o.resolveCollision(this, obj, b);
					}
			if(obj.size()<=6)
				stop = true;
			
			isBallZero();
			isBlockZero();
			
			updatePosition();
			repaint();
		}
	}
	
	private void updatePosition() {
		
	   if(block.getX() > 10 && block.getX() < 430)
		   block.setX((int)vx);
	   if(block.getX() <= 10)
		   block.setX(10);
	   else if(block.getX() >= 430)
		   block.setX(-10);

	   repaint();
	}
	
	private void setRound1() {
		Random random = new Random();
	    for(int i = 0; i < 4; i++, blockX += 125) {
	    	// row 1
	    	if(random.nextInt(4) > 0)
	    		obj.add(new NormalBlock(blockX,20,125,60));
	    	else
	    		obj.add(new SpecialBlock(blockX,20,125,60));
	    	// row 2
	    	if(random.nextInt(4) > 0)
	    		obj.add(new NormalBlock(blockX,80,125,60));
	    	else
	    		obj.add(new SpecialBlock(blockX,80,125,60));
	    	// row 3
	    	if(random.nextInt(4) > 0)
	    		obj.add(new NormalBlock(blockX,140,125,60));
	    	else
	    		obj.add(new SpecialBlock(blockX,140,125,60));
	    }
	}
	
	private void setRound2() {
		Random random = new Random();
	    for(int i = 0; i < 5; i++, blockX += 100) {
	    	// row 1
	    	if(random.nextInt(4) > 0)
	    		obj.add(new NormalBlock(blockX,20,100,50));
	    	else
	    		obj.add(new SpecialBlock(blockX,20,100,50));
	    	// row 2
	    	if(random.nextInt(4) > 0)
	    		obj.add(new NormalBlock(blockX,70,100,50));
	    	else
	    		obj.add(new SpecialBlock(blockX,70,100,50));
	    	// row 3
	    	if(random.nextInt(4) > 0)
	    		obj.add(new NormalBlock(blockX,120,100,50));
	    	else
	    		obj.add(new SpecialBlock(blockX,120,100,50));
	    	// row 4
	    	if(random.nextInt(4) > 0)
	    		obj.add(new NormalBlock(blockX,170,100,50));
	    	else
	    		obj.add(new SpecialBlock(blockX,170,100,50));
	    }
	}
	
	private void setRound3() {
		Random random = new Random();
	    for(int i = 0; i < 10; i++, blockX += 50) {
	    	// row 1
	    	if(random.nextInt(4) > 0)
	    		obj.add(new NormalBlock(blockX,20,50,40));
	    	else
	    		obj.add(new SpecialBlock(blockX,20,50,40));
	    	// row 2
	    	if(random.nextInt(4) > 0)
	    		obj.add(new NormalBlock(blockX,60,50,40));
	    	else
	    		obj.add(new SpecialBlock(blockX,60,50,40));
	    	// row 3
	    	if(random.nextInt(4) > 0)
	    		obj.add(new NormalBlock(blockX,100,50,40));
	    	else
	    		obj.add(new SpecialBlock(blockX,100,50,40));
	    	// row 4
	    	if(random.nextInt(4) > 0)
	    		obj.add(new NormalBlock(blockX,140,50,40));
	    	else
	    		obj.add(new SpecialBlock(blockX,140,50,40));
	    	// row 5
	    	if(random.nextInt(4) > 0)
	    		obj.add(new NormalBlock(blockX,180,50,40));
	    	else
	    		obj.add(new SpecialBlock(blockX,180,50,40));
	    }
	}
	
	private void isBallZero() {
		// 공 전부 사라지면 종료
		boolean isZero = true;
		for (MyObject myObject : obj) {
			if(myObject instanceof MyBall) {
				isZero = false;
				break;
			}
		}
		if(isZero) {
			try {
				m.playMusic(6);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setStop(true);
			m.setNextPage(false);
		}
	}
	
	private void isBlockZero() {
		// 블록 전부 사라지면 종료
		boolean isZero = true;
		for (MyObject myObject : obj) {
			if(myObject instanceof TargetBlock) {
				isZero = false;
				break;
			}
		}
		if(isZero) {
			setStop(true);
			if(round < 3)
				m.setNextRound();
			else if(round == 3)
				m.setNextPage(true);
		}
	}
}
