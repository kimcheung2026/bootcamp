// interface

import java.util.Random;

public class Superman extends Human implements Flyable, Swimable { //Step 1 --> call interface Flyable
  private int hp; //100
  private int baseAttack;
  private static final Random random = new Random(); // Static 負責抽籤


   public Superman (String name, int hp, int attackValue) {
    super(name);
    this.hp = 100;
    this.baseAttack = 5; // 每個超人基本 5 點
  }
  

//總結建議：
//如果是「每次攻擊都不一樣」 
// 用 Static 在 attack() 裡抽。
//如果是「每個超人天賦不同」 
// 用 Constructor 在出生時抽。

  public Superman () {
    super();
    this.hp = 100;
    this.baseAttack = 5;
  }

  public int getHp() {
    return this.hp;
  }

  public boolean isAlive() {
    return this.hp > 0;
    }
  
  
  //! setHP() -> deductHP (封裝)
  public void deductHp(int toBeDeducted) {
    if (this.hp >= toBeDeducted) {
      this.hp -= toBeDeducted;
    } else {
      this.hp = 0; // 若扣除量大於現有血量，歸零
    }
    
  }


  // Instance Method (Skill -> Contract)
  @Override // Step 3 
  public void fly() {
    System.out.println("Superman " + this.getName() + " is flying...");
  }
  @Override
  public void swim() {
    System.out.println("Superman " + this.getName() + " is swimming...");
  }
  public void sleep(){
    System.out.println("i am Sleeping...");
  }
  
  public void attack(Superman superman) {
    //s1 attack value
    //s2 status change
    //s1 (this), s2 (superman)
    // 最終傷害 = 基本盤 + (-2 到 +2 的隨機浮動)
    int finalDamage = this.baseAttack + (random.nextInt(5) - 2);
    
    if (this.isAlive()) {
    superman.deductHp(finalDamage);
    System.out.println( this.getName() +" 對 " + superman.getName() +" 造成了 " + finalDamage + " 傷害！");
    
    } else {
    System.out.println("You die already. Cannot Attack.");

    }
  }

  public static void main(String[] args) {
    Superman s1 = new Superman();
    s1.setName("Macy");
    s1.sleep();
    s1.fly();
    s1.swim();
    // Developer = coding + Testing (Test Case)
    System.out.println(s1.getHp());
    s1.deductHp(2);
    System.out.println(s1.getHp());
    
    Superman s2 =new Superman();
    s1.attack(s2);
    System.out.println(s2.getName() + " 現在只有 "+ s2.getHp() + " 生命. ");

    //s1 attack s2
    //Superman attack Superman (Verb -> method)
    //Status Change (s2) -> s2 has 
    //
    Superman s4 = new Superman();
    //Parent Class can be the Object Reference Type
    
    Superman h1 = new Superman();
    
    h1.setName("John");
    System.out.println(h1.getName());
    //! Compile time. h1 can call Parent Class Method ONLY
    //! Runtime, h1 will know it points to Superman object
  }
   
}
