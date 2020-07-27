package Application.Graphics;

public class Sprite {
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x3471eb);

	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		this.pixels = new int[SIZE * size];
		load();
	}

	private void load() {
		for (int y = 0; y < SIZE; y++)
		{
			for (int x = 0; x < SIZE; x++)
			{
				pixels[x + y * SIZE] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
			}
		}
	}

	private void setColor(int color) {
		for (int i = 0; i < SIZE * SIZE; i++)
		{
			pixels[i] = color;
		}
	}

}
