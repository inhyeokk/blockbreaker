package Object;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CopyOnWriteArrayList;

import Panel.GamePanel;
import Panel.MainFrame;

public class MyBall extends MyObject {
	private MainFrame m = null;
	
	private double x, y, r;
	private double vx, vy;
	private double prex, prey;

	// generate default ball
	public MyBall(MainFrame _m) {
		m = _m;
		x = 270;
		y = 380;
		r = 5;
		vx = 100; // set speed
		vy = 100; // set speed
	}
	
	// generate new ball
	public MyBall(MainFrame _m, int _x, int _y) {
		m = _m;
		x = _x;
		y = _y;
		r = 5;
		vx = 100; // set speed
		vy = 100; // set speed
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.BLACK);
		g2.fillOval((int) (x - r), (int) (y - r), (int) (2 * r), (int) (2 * r));
	}

	@Override
	public void update(double dt) {
		prex = x;
		prey = y;
		x += vx * dt;
		y += vy * dt;
	}

	@Override
	public void resolveCollision(GamePanel p, CopyOnWriteArrayList<MyObject> oList, MyObject o) {
		if (o instanceof MyBlock) {
			MyBlock b = (MyBlock) o;
			double x1 = b.getX() - r;
			double y1 = b.getY() - r;
			double x2 = b.getX() + b.getW() + r;
			double y2 = b.getY() + b.getH() + r;
			
			if (x > x1 && x < x2 && y > y1 && y < y2) {
				if (prey < y1) {
					y = y1;
					vy = -vy;
					
					if(b instanceof RacketBlock)
						try {
							m.playMusic(5);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					if(b.getX() == 0 && b.getY() == 480 && b.getW() == 540 && b.getH() == 20)
						oList.remove(this);
				}
				if (prey > y2) {
					y = y2;
					vy = -vy;
					
					if(b instanceof RacketBlock)
						try {
							m.playMusic(5);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				if (prex < x1) {
					x = x1;
					vx = -vx;
					
					if(b instanceof RacketBlock)
						try {
							m.playMusic(5);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				if (prex > x2) {
					x = x2;
					vx = -vx;
					
					if(b instanceof RacketBlock)
						try {
							m.playMusic(5);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
		} else if (o instanceof TargetBlock) {
			TargetBlock b = (TargetBlock) o;
			double x1 = b.getX() - r;
			double y1 = b.getY() - r;
			double x2 = b.getX() + b.getW() + r;
			double y2 = b.getY() + b.getH() + r;
			if (x > x1 && x < x2 && y > y1 && y < y2) {
				if (prey < y1) {
					y = y1;
					vy = -vy;
					oList.remove(b);
					// ³ë¶õ ºí·°°ú ºÎµóÈù °æ¿ì
					if(b instanceof SpecialBlock) {
						m.plusScore(20);
						try {
							m.playMusic(4);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						oList.add(new MyBall(m, (int)(x + 20), (int)(y + 20)));
						oList.add(new MyBall(m, (int)(x + 10), (int)(y + 10)));
					} 
					// ÀÏ¹Ý ºí·°°ú ºÎµóÈù °æ¿ì
					else {
						m.plusScore(10);
						try {
							m.playMusic(3);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if (prey > y2) {
					y = y2;
					vy = -vy;
					oList.remove(b);
					if(b instanceof SpecialBlock) {
						m.plusScore(20);
						try {
							m.playMusic(4);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						oList.add(new MyBall(m, (int)(x + 20), (int)(y + 20)));
						oList.add(new MyBall(m, (int)(x + 10), (int)(y + 10)));
					}
					// ÀÏ¹Ý ºí·°°ú ºÎµóÈù °æ¿ì
					else {
						m.plusScore(10);
						try {
							m.playMusic(3);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if (prex < x1) {
					x = x1;
					vx = -vx;
					oList.remove(b);
					if(b instanceof SpecialBlock) {
						m.plusScore(20);
						try {
							m.playMusic(4);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						oList.add(new MyBall(m, (int)(x + 20), (int)(y + 20)));
						oList.add(new MyBall(m, (int)(x + 10), (int)(y + 10)));
					}
					// ÀÏ¹Ý ºí·°°ú ºÎµóÈù °æ¿ì
					else {
						m.plusScore(10);
						try {
							m.playMusic(3);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if (prex > x2) {
					x = x2;
					vx = -vx;
					oList.remove(b);
					if(b instanceof SpecialBlock) {
						m.plusScore(20);
						try {
							m.playMusic(4);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						oList.add(new MyBall(m, (int)(x + 20), (int)(y + 20)));
						oList.add(new MyBall(m, (int)(x + 10), (int)(y + 10)));
					}
					// ÀÏ¹Ý ºí·°°ú ºÎµóÈù °æ¿ì
					else {
						m.plusScore(10);
						try {
							m.playMusic(3);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		} 
	}
}
