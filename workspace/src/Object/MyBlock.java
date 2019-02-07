package Object;

import java.awt.Graphics;

public class MyBlock extends MyObject {
	private int x, y, w, h;
	
	public MyBlock(int _x, int _y, int _w, int _h) {
		x = _x;
		y = _y;
		w = _w;
		h = _h;
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
		
	}
}
