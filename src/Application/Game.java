package Application;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import Application.Entity.Mob.Player;
import Application.Graphics.Screen;
import Application.Graphics.Sprite;
import Application.Input.Keyboard;
import Application.Input.Mouse;
import Application.Level.Level;
import Application.Level.TileCoordinate;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;

	private Thread thread;
	private boolean running = false;

	private Screen screen;
	private Level level;
	private Player player;
	private Keyboard keyboard;
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public static String gameTitle = "tbd...";
	private JFrame frame;

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale); // height * scale);
		setPreferredSize(size);
		screen = new Screen(width, height);
		frame = new JFrame();
		level = Level.spawn;

		keyboard = new Keyboard();
		TileCoordinate playerSpawn = new TileCoordinate(19, 62);
		player = new Player(playerSpawn.x(), playerSpawn.y(), keyboard);
		player.init(level);

		addKeyListener(keyboard);
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.add(game);
		game.frame.setResizable(false);
		game.frame.setTitle(gameTitle);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try
		{
			thread.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;

		requestFocus();

		while (running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1)
			{
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				frame.setTitle(gameTitle + "    |    " + updates + " ups, " + frames + " fps.");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	public void update() {
		keyboard.update();
		player.update();
		level.update();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);

		Sprite sprite = new Sprite(80, 80, 0xff00ff);
		screen.renderSprite(0, 0, sprite, true);
		
		for (int i = 0; i < pixels.length; i++)
		{
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.white);
		g.setFont(new Font("Verdana", 0, 50));
		//g.fillRect(Mouse.getX() - 32, Mouse.getY() - 32, 64, 64);
		if (Mouse.getB() != -1) g.drawString("Button: " + Mouse.getB(), 70, 70);

		g.dispose();
		bs.show();
	}
}
