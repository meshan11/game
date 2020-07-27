package Application.Entity.Mob;

import Application.Entity.Entity;
import Application.Graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int direction = 0;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if (xa > 0) direction = 1;
		if (xa < 0) direction = 3;
		if (ya > 0) direction = 2;
		if (ya < 0) direction = 0;

		if (!collision())
		{
			x += xa;
			y += ya;
		}
	}

	public void update() {

	}

	private boolean collision() {
		return false;
	}
}
