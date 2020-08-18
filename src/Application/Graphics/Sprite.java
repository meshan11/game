package Application.Graphics;

public class Sprite {
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x3471eb);
	
	// Spawn Level Sprites:
	public static Sprite spawn_grass = new Sprite(16, 0, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_hedge = new Sprite(16, 1, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_water = new Sprite(16, 2, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_wall1 = new Sprite(16, 0, 1, SpriteSheet.spawn_level);
	public static Sprite spawn_wall2 = new Sprite(16, 0, 2, SpriteSheet.spawn_level);
	public static Sprite spawn_floor = new Sprite(16, 1, 1, SpriteSheet.spawn_level);
	
	
	public static Sprite player0 = new Sprite(16, 0, 2, SpriteSheet.tiles);
	
	public static Sprite player_forward = new Sprite(32, 5, 3, SpriteSheet.tiles);
	public static Sprite player_back = new Sprite(32, 5, 4, SpriteSheet.tiles);
	public static Sprite player_left = new Sprite(32, 5, 5, SpriteSheet.tiles);
	public static Sprite player_right = new Sprite(32, 5, 6, SpriteSheet.tiles);
	
	
	public static Sprite player_forward_1 = new Sprite(32, 6, 3, SpriteSheet.tiles);
	public static Sprite player_forward_2 = new Sprite(32, 7, 3, SpriteSheet.tiles);
	
	public static Sprite player_back_1 = new Sprite(32, 6, 4, SpriteSheet.tiles);
	public static Sprite player_back_2 = new Sprite(32, 7, 4, SpriteSheet.tiles);
	
	public static Sprite player_left_1 = new Sprite(32, 6, 5, SpriteSheet.tiles);
	public static Sprite player_left_2 = new Sprite(32, 7, 5, SpriteSheet.tiles);
	
	public static Sprite player_right_1 = new Sprite(32, 6, 6, SpriteSheet.tiles);
	public static Sprite player_right_2 = new Sprite(32, 7, 6, SpriteSheet.tiles);
	
	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	private void load() {
		for (int y = 0; y < SIZE; y++)
		{
			for (int x = 0; x < SIZE; x++)
			{
				pixels[x + y * SIZE] = sheet.pixels[(this.x + x) + ((this.y + y) * sheet.SIZE)];
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
