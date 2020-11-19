package Application.Level.Tile;

import Application.Graphics.Screen;
import Application.Graphics.Sprite;

public class RockTile extends Tile {
	public RockTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this.sprite);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
