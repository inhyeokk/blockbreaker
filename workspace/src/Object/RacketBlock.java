package Object;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class RacketBlock extends MyBlock {
	private int x, y, w, h;
	
	public RacketBlock(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int _x) {
		super.setX(_x);
		x += _x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getW() {
		return w;
	}


	@Override
	public int getH() {
		return h;
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.fill3DRect(x, y, w, h, false);
	}
}

