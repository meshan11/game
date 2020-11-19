package Application.Entity.Projectile;

import Application.Entity.Entity;
import Application.Graphics.Sprite;

public abstract class Projectile extends Entity {

	protected final int xOrigin, yOrigin;
	protected double x, y;
	protected double angle;
	protected Sprite sprite;
	protected double nx, ny;
	protected double distance;
	protected double speed, range, damage;

	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}

	protected void move() {

	}
	
	public Sprite getSprite() {
		return this.sprite;
	}

	public int getSpriteSize() {
		return this.sprite.SIZE;
	}
}
