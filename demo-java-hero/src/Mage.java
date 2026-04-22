
import java.util.Random;

public class Mage extends Human implements Mskill, Stave, Levelup {
  private int newAtt;
  private int newHp;
  private int newMp;

  public Mage(String name) {
    super(name);
    this.newAtt = super.getBaseAttack() + 5;
    this.newHp = super.getHp() + 50;
    this.newMp = super.getMp() + 100;
    super.setHp(this.newHp);
    super.setMp(this.newMp);
    super.setAtt(this.newAtt);
  }

  @Override
  public void addHp(int amount) {
    this.newHp = this.newHp + amount; // 先拿現有的
    super.setHp(this.newHp);
  }

  @Override
  public void addMp(int amount) {
    this.newMp = this.newMp + amount; // 先拿現有的
    super.setMp(this.newMp);
  }

  @Override
  public void addAtt(int amount) {
    this.newAtt = this.newAtt + amount;
    super.setAtt(this.newAtt);

  }

  public void levelup() { // Warrior level
    this.addAtt(5);
    this.addMp(100);
    this.addHp(50);
    System.out.println(this.getName() + " (法師)等級提升了！ ");
  }

  @Override
  public void hit1(Human target) {
    if (this.getMp() >= 10) {
      int damage = (this.newAtt) * 50 / 100 + (this.newAtt);

      System.out.println(this.getName() + " 使用了【火球】！造成了"//
          + damage + " 傷害！");
      target.deductHp(damage);
      this.deductMp(10);
    } else {
      this.attack(target);
    }
  }

  @Override
  public void hit2(Human target) {
    if (this.getMp() >= 50) {
      int damage = (this.newAtt) * 300 / 100 + (this.newAtt);
      System.out.println(this.getName() + " 使用了【地爆天星】！造成了"//
          + damage + " 傷害！");
      target.deductHp(damage);
      this.deductMp(50);
    } else {
      this.hit1(target);
    }
  }

  @Override
  public void equip1() {
    this.addAtt(10);
    this.addMp(50);
    System.out.println(this.getName() + " 裝備了大天使之仗!");
  }

  @Override
  public void equip2() {
    this.addAtt(5);
    this.addMp(80);
    System.out.println(this.getName() + " 裝備了蘭德里之仗!");
  }

  @Override
  public void remove1() {
    this.addAtt(-10);
    this.addMp(-50);
    System.out.println(this.getName() + " 移除了大天使之仗!");
  }

  @Override
  public void remove2() {
    this.addAtt(-5);
    this.addMp(-80);
    System.out.println(this.getName() + " 移除了蘭德里之仗!");
  }

  public void action(Human target) { // for Warrior ONLY
    // 因為 Random 在 Human 類別已經是 static 了，這裡可以直接用，或者另外傳入
    Random idx = new Random();
    int chance = idx.nextInt(10);

    if (chance < 2) {
      this.hit1(target);
    } else if (chance < 4) {
      this.hit2(target);
    } else {
      this.attack(target);
    }
  }

  public void battle(Human target) {
    System.out.println("戰鬥開始：" + this.getName() + " VS " + target.getName());

    while (this.isAlive() && target.isAlive()) {
      // 執行自己的隨機動作
      this.action(target);

      // 如果對方還活著，換對方執行動作
      if (target.isAlive()) {
        // 如果 target 也是 Warrior，就呼叫他的 action
        if (target instanceof Warrior3) {
          ((Warrior3) target).action(this);
        } else {
          target.attack(this); // 如果只是普通 Human 就用普通攻擊
        }
      }
    }
  }
}
