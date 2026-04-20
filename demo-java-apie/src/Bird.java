import java.util.ArrayList;
import java.util.Objects;

public class Bird implements Flyable {
  private String name;
  private int code;
   // 關鍵點：static 代表這是「鳥類全體共享」的登記冊
    public static ArrayList<Bird> birdRegistry = new ArrayList<>();

  public Bird() {
  birdRegistry.add(this);
  }
  public Bird(String name) {
    this.name = name;
    birdRegistry.add(this);
  } 


  public Bird(String name, int code) {
    this.name = name;
    this.code = code;
    birdRegistry.add(this);
  }
  public int getCode() {
    return this.code;
  }

  public String getName() {
    return this.name;
  }

  @Override 
  public void fly() {
    System.out.println("Bird " + this.getName() + " is flying...");
  }
  // ! 背
  @Override
  public boolean equals(Object obj) {
    //! Part 1 : Memory Address same -> Same Memory object -> same thing
    if(this == obj) {
      return true;
    } 
    // ! Part 2: "instanceof" to check object vs Type
    if (!(obj instanceof Bird)) {
      return false;
    }
    // ! Part 3 : Compare 2 bird objects
    Bird b1 = (Bird) obj;
    return b1.getCode() == this.code; // Compare bird's code
    }
    @Override
    public int hashCode() {
    return Objects.hash(this.code); // 保持與 equals 的判斷屬性一致
    }
    @Override
    public String toString() {
        return "Bird[名稱=" + this.name + ", 編號=" + this.code + "]";
    }
 


  public static void main(String[] args) {
    //! If we do not @override equals() -> checking object address
    Bird b1 = new Bird();
    Bird b2 = new Bird();
    System.out.println(b1.equals(b2)); //false (b1 == b2) After override true
    
    Bird b3 = new Bird("John", 101);
    Bird b4 = new Bird("John", 102);
    System.out.println(b3.equals(b4));

    Bird b5 = new Bird("Mary", 101);
    Bird b6 = new Bird("Sally", 101);
    System.out.println(b5.equals(b5)); 
    
    
    



    //出生 Record System
    //Baby b9 = new Baby("John Chan", 65321);
    //Baby b10 = new Baby("John Chan", 65321);
    System.out.println(b1.equals(b2));
  }
}