package Object;

import java.awt.Graphics;
import java.util.concurrent.CopyOnWriteArrayList;

import Panel.GamePanel;

public abstract class MyObject {
	abstract public void draw(Graphics g);

	public void update(double dt) {
	};

	public void resolveCollision(GamePanel p, CopyOnWriteArrayList<MyObject> blockList, MyObject o) {
	};
}
