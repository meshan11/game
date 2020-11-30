package Application.Entity;

import Application.Entity.particle.Particle;
import Application.Level.Level;

public class Spawner extends Entity {

	public enum Type {
		PARTICLE, MOB;
	}

	private Type type;

	public Spawner(int x, int y, Type type, int amount, Level level) {
		this.x = x;
		this.y = y;
		this.type = type;

		for (int i = 0; i < amount; i++)
		{
			if (type == Type.PARTICLE)
			{
				level.add(new Particle(x, y, 50));
			}
		}
	}
}
