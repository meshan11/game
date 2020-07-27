package Application.Entity.Mob;

import Application.Input.Keyboard;

public class Player extends Mob {

	private Keyboard input;

	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	@Override
	public void update() {
		int xa = 0, ya = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
	}

	public void render() {

	}
}