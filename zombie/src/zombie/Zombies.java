package zombie;

public class Zombies extends Units {
	public int power;

	public Zombies(int pos, int hp, int max) {
		super(pos, hp, max);
	}

	public void attack(Units hero) {
		int power = r.nextInt(max) + 1;

		hero.setHp(hero.getHp() - power);
		System.err.println("���� " + power + "�� �������� �־����ϴ�.");
	}

}
