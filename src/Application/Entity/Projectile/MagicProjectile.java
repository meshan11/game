package Application.Entity.Projectile;

import Application.Entity.particle.Particle;
import Application.Graphics.Screen;
import Application.Graphics.Sprite;

public class MagicProjectile extends Projectile {

	public static final int FIRE_RATE = 15;

	public MagicProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 4;
		damage = 20;
		sprite = Sprite.projectileMagic;

		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void update() {
		if (level.tileCollision(x, y, nx, ny, 7))
		{
			remove();
		}
		move();
	}

	protected void move() {
		x += nx;
		y += ny;

		if (distance() > range) remove();
	}

	private double distance() {
		double dist = 0;
		dist = Math.sqrt((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y));
		return dist;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x - 12, (int) y, this);
	}

}
