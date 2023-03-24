package zombie;

class Heros extends Units {
	public int power;
	public int count;

	public Heros(int pos, int hp, int max, int count) {
		super(pos, hp, max);
		this.count = count;
	}

	public void attack(Units enemy) {
		this.power = r.nextInt(max) + 1;
		if (enemy instanceof Bosses) {
			Bosses boss = (Bosses) enemy;

			if (boss.getShield() > 0) {
				int shield = boss.getShield();
				if (shield - this.power > 0) {
					boss.setShield(shield - this.power);
				} else if (shield - this.power <= 0) {
					boss.setHp(boss.getHp() + shield - this.power);
					boss.setShield(0);
				}
				System.err.println("����ΰ� " + this.power + " �� �������� �־����ϴ�.");
			} else if (boss.getShield() == 0) {
				boss.setHp(boss.getHp() - this.power);
				System.err.println("����ΰ� " + this.power + " �� �������� �־����ϴ�.");
			}
		} else {
			Zombies zom = (Zombies) enemy;
			zom.setHp(zom.getHp() - this.power);
			System.err.println("����ΰ� " + this.power + " �� �������� �־����ϴ�.");
		}
	}

	public void recovery() {
		if (this.count > 0) {
			setHp(getHp() + 100);
			System.out.println("ü�� ȸ���ؼ� " + getHp() + " �� �Ǿ����ϴ�");
			this.count -= 1;
			System.out.println("���� ���� : " + this.count);
		} else if (this.count == 0) {
			System.out.println("��� ����߽��ϴ�.");
		}
	}
}