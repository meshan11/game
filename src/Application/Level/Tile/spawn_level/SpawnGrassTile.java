package Application.Level.Tile.spawn_level;

import Application.Graphics.Screen;
import Application.Graphics.Sprite;
import Application.Level.Tile.Tile;

public class SpawnGrassTile extends Tile {

	public SpawnGrassTile(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this.sprite);
	}
}
