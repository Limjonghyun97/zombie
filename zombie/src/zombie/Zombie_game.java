package zombie;

import java.util.Random;
import java.util.Scanner;

public class Zombie_game {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		Heros hero = new Heros(1, 200, 20, 3);
		Zombies zom = new Zombies(3, 100, 10);
		Bosses boss = new Bosses(9, 200, 20, 10);

		int heroHp = hero.getHp();
		int zomHp = zom.getHp();
		int bossHp = boss.getHp();

		while (true) {
			for (int i = 0; i <= 10; i++) {
				if (hero.getPos() == i) {
					System.out.print("��");
				} else if (zom.getPos() == i) {
					System.out.print("��");
				} else if (boss.getPos() == i) {
					System.out.print("��");
				} else {
					System.out.print("__");
				}
			}
			System.out.println();
			System.out.println("1) ������");
			System.out.println("2) ����");
			System.out.println("0) ����");
			int sel = scan.nextInt();

			if (sel == 1 && hero.getPos() < 10) {
				if (hero.getPos() + 1 == zom.getPos() || hero.getPos() + 1 == boss.getPos()) {
					System.out.println("���� ����");
					hero.rightMove();
					while (true) {
						System.out.println("1. �����ϱ�");
						System.out.println("2. ü��ȸ��");
						System.out.println("3. ����ġ��");
						int menu = scan.nextInt();
						if (menu == 1) {
							if (hero.getPos() == zom.getPos()) {
								hero.attack(zom);
								System.out.println("���� hp : " + zom.getHp());
								zom.attack(hero);
								System.out.println("����� hp : " + hero.getHp());

								if (hero.getHp() <= 0)
									break;
								else if (zom.getHp() <= 0) {
									zom.setPos(-1);
									break;
								}
							} else if (hero.getPos() == boss.getPos()) {
								hero.attack(boss);
								System.out.println("���� hp : " + boss.getHp());
								boss.attack(hero);
								System.out.println("����� hp : " + hero.getHp());

								if (hero.getHp() <= 0)
									break;
								else if (boss.getHp() <= 0) {
									System.out.println("next stage>>>");
									int ranN = ran.nextInt(30) + 1;
									hero = new Heros(1, heroHp + ranN, hero.getMax() + ranN, 3 + ranN);
									ranN = ran.nextInt(30) + 1;
									zom = new Zombies(3, zomHp + ranN, zom.getMax() + ranN);
									ranN = ran.nextInt(30) + 1;
									boss = new Bosses(9, bossHp + ranN, boss.getMax() + ranN, 15 + ranN);

									heroHp = hero.getHp();
									zomHp = zom.getHp();
									bossHp = boss.getHp();
									break;
								}
							}
						} else if (menu == 2)
							hero.recovery();
						else if (menu == 3)
							break;
					}

				} else {
					hero.rightMove();
				}
			} else if (sel == 2 && hero.getPos() >= 0) {
				if (hero.getPos() - 1 == zom.getPos() || hero.getPos() - 1 == boss.getPos()) {
					System.out.println("���� ����");
					hero.leftMove();
					while (true) {
						System.out.println("1. �����ϱ�");
						System.out.println("2. ü��ȸ��");
						int menu = scan.nextInt();
						if (menu == 1) {
							if (hero.getPos() == zom.getPos()) {
								hero.attack(zom);
								System.out.println("���� hp : " + zom.getHp());
								zom.attack(hero);
								System.out.println("����� hp : " + hero.getHp());

								if (hero.getHp() <= 0)
									break;
								else if (zom.getHp() <= 0)
									break;
							} else if (hero.getPos() == boss.getPos()) {
								hero.attack(boss);
								System.out.println("���� hp : " + boss.getHp());
								boss.attack(hero);
								System.out.println("����� hp : " + hero.getHp());

								if (hero.getHp() <= 0)
									break;
								else if (boss.getHp() <= 0)
									break;
							}
						} else if (menu == 2)
							hero.recovery();
					}

				} else {
					hero.leftMove();
				}
			} else if (sel == 0) {
				break;
			}

			if (hero.getHp() <= 0) {
				System.out.println("�÷��̾� ���");
				break;
			}
		}
	}
}
