package zombie;

import java.util.Random;

abstract class Units {
	private int pos;
	private int hp;
	public int max;
	public Random r;

	public Units(int pos, int hp, int max) {
			this.pos = pos;
			this.hp = hp;
			this.max = max;

			r = new Random();
		}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getPos() {
		return this.pos;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMax() {
		return this.max;
	}

	public void rightMove() {
		if (pos < 10) {
			pos++;
		}
	}

	public void leftMove() {
		if (pos > 0) {
			pos--;
		}
	}

	abstract void attack(Units nuit);
}
