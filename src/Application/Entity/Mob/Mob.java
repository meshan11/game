package Application.Entity.Mob;

import Application.Entity.Entity;
import Application.Entity.Projectile.MagicProjectile;
import Application.Entity.Projectile.Projectile;
import Application.Graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int direction = 0;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0)
		{
			move(xa, 0);
			move(0, ya);
			return;
		}
		
		if (xa > 0) direction = 1;
		if (xa < 0) direction = 3;
		if (ya > 0) direction = 2;
		if (ya < 0) direction = 0;

		if (!collision(xa, ya))
		{
			x += xa;
			y += ya;
		}
	}

	public void update() {
		
	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 12 - 7) >> 4;
			int yt = ((y + ya) + c / 2 * 12 + 5) >> 4; 
			if (level.getTile(xt, yt).isSolid()) solid = true;
		}

		return solid;
	}
	
	public void shoot(int x, int y, double dir) {
		// dir = dir * (180 / Math.PI);
		Projectile p = new MagicProjectile(x, y, dir);
		level.addProjectile(p);
		
		//dir = Math.toDegrees(dir);
		//System.out.println(dir);
	}
}
