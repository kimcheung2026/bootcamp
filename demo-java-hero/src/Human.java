import java.util.Random;

public abstract class Human {
  private String name;
  private int hp; // 100
  private int mp;
  private int baseAttack;
  private static final Random random = new Random(); // Static 負責抽籤
  private static int idCount = 1001;

  public Human(String name) {
    idCount++;
    this.hp = 100;
    this.mp = 100;
    this.baseAttack = 5;
    this.name = name;

  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHp() {
    return this.hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getMp() {
    return this.mp;
  }

  public void setMp(int mp) {
    this.mp = mp;
  }

  public int getBaseAttack() {
    return this.baseAttack;
  }

  public void setAtt(int baseAttack) {
    this.baseAttack = baseAttack;
  }

  public boolean isAlive() {
    return this.hp > 0;
  }

  // ! setHP() -> deductHP (封裝)
  public void deductHp(int toBeDeducted) {
    if (this.hp >= toBeDeducted) {
      this.hp -= toBeDeducted;
    } else {
      this.hp = 0; // 若扣除量大於現有血量，歸零
    }
  }

  public void deductMp(int toBeDeducted) {
    if (this.mp >= toBeDeducted) {
      this.mp -= toBeDeducted;
    } else {
      this.mp = 0;
    }
  }

  public void attack(Human human) {
    int finalDamage = this.baseAttack + (random.nextInt(5) - 2);
    if (this.isAlive()) {
      human.deductHp(finalDamage);
      System.out.println(this.getName() + " 對 " + human.getName() + " 造成了 " + finalDamage + " 傷害！");

    } else {
      System.out.println("You die already. Cannot Attack.");

    }
  }

}
