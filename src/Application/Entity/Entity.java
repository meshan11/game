package Application.Entity;

import java.util.Random;

import Application.Graphics.Screen;
import Application.Level.Level;

public abstract class Entity {
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return this.removed;
	}
	
	public void init(Level level) {
		this.level = level;
	}
	
}
