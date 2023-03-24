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
				System.err.println("히어로가 " + this.power + " 의 데미지를 주었습니다.");
			} else if (boss.getShield() == 0) {
				boss.setHp(boss.getHp() - this.power);
				System.err.println("히어로가 " + this.power + " 의 데미지를 주었습니다.");
			}
		} else {
			Zombies zom = (Zombies) enemy;
			zom.setHp(zom.getHp() - this.power);
			System.err.println("히어로가 " + this.power + " 의 데미지를 주었습니다.");
		}
	}

	public void recovery() {
		if (this.count > 0) {
			setHp(getHp() + 100);
			System.out.println("체력 회복해서 " + getHp() + " 이 되었습니다");
			this.count -= 1;
			System.out.println("남은 포션 : " + this.count);
		} else if (this.count == 0) {
			System.out.println("모두 사용했습니다.");
		}
	}
}