package Application.Level.Tile;

import Application.Graphics.Screen;
import Application.Graphics.Sprite;

public class FlowerTile extends Tile {
	public FlowerTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}
