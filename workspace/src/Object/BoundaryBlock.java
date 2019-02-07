package Object;



import java.awt.Graphics;
import java.awt.Graphics2D;

public class BoundaryBlock extends MyBlock {
	
	private int x, y, w, h;
	
	public BoundaryBlock(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.fill3DRect(x, y, w, h, false);
	}
}
