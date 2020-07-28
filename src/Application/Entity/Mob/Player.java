package Application.Entity.Mob;

import Application.Graphics.Screen;
import Application.Graphics.Sprite;
import Application.Input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private Sprite playerSprite;
	private int animate = 0;
	private boolean walking = false;

	public Player(Keyboard input) {
		this.input = input;
		this.playerSprite = Sprite.player_back;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	@Override
	public void update() {
		int xa = 0, ya = 0;
		if (animate < 10000)
			animate++;
		else
			animate = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;

		if (xa != 0 || ya != 0)
		{
			move(xa, ya);
			walking = true;
		}
		else
		{
			walking = false;
		}
	}

	public void render(Screen screen) {
		int spriteSize = Sprite.player_forward.SIZE / 2;

		if (direction == 0)
		{
			playerSprite = Sprite.player_forward;
			if (walking)
			{
				int animState = animate % 40;
				if (animState > 10 && animState <= 20)
				{
					playerSprite = Sprite.player_forward_1;
				}
				else if (animState > 30) playerSprite = Sprite.player_forward_2;
			}
		}

		if (direction == 1)
		{
			playerSprite = Sprite.player_right;
			if (walking)
			{
				int animState = animate % 40;
				if (animState > 10 && animState <= 20)
				{
					playerSprite = Sprite.player_right_1;
				}
				else if (animState > 30) playerSprite = Sprite.player_right_2;
			}
		}

		if (direction == 2)
		{
			playerSprite = Sprite.player_back;
			if (walking)
			{
				int animState = animate % 40;
				if (animState > 10 && animState <= 20)
				{
					playerSprite = Sprite.player_back_1;
				}
				else if (animState > 30) playerSprite = Sprite.player_back_2;
			}
		}

		if (direction == 3)
		{
			playerSprite = Sprite.player_left;
			if (walking)
			{
				int animState = animate % 40;
				if (animState > 10 && animState <= 20)
				{
					playerSprite = Sprite.player_left_1;
				}
				else if (animState > 30)
				{
					playerSprite = Sprite.player_left_2;
				}
			}
		}

		screen.renderPlayer(x - spriteSize, y - spriteSize, playerSprite);
	}
}
