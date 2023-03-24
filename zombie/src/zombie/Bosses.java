package zombie;

import java.util.Random;

class Bosses extends Zombies {
	Random r = new Random();
	private int shield;

	public Bosses(int pos, int hp, int max, int shield) {
		super(pos, hp, max);
		this.shield = shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public int getShield() {
		return this.shield;
	}

	public void attack(Units hero) {
		int power = r.nextInt(max) + 1;

		hero.setHp(hero.getHp() - power);
		System.err.println("보스가 " + power + "의 데미지를 주었습니다.");
	}
}
