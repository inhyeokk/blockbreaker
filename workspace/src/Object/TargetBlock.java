package Object;

import java.awt.Graphics;

public class TargetBlock extends MyObject {
	
	private int x, y, w, h;
	
	public TargetBlock(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int _x) {
		x += _x;
	}

	public int getY() {
		return y;
	}
	
	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
