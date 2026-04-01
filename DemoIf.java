import java.util.List;

public class DemoIf {
  public static void main(String[] args) {
    int age = 13; // > . < . >= . <=
    if (age >= 18) {
      System.out.println("Adult");
    } else {
      System.out.println("Child");
    }
    // 8 Primitives + String
    // boolean
    // = (assignment)
    // == (check if equals)
    age = 80;
    boolean isElderly = age >65 ;
    if (isElderly) {
      System.out.println("Fee=2");
    }
    // && ||
    int a =21;
    if (a >= 5 && a <= 20) {
      System.out.println("a is between 5 and 20. ");
    }
    int b = 10;
    if(a > 20 || b > 12) {
      System.out.println("hello");
    } else {
      System.out.println("goodbye");
    }
    // Event 1: a > 15
    // Event 
    if ( a > 20 || b > 6 && b < 20) {
      System.out.println("Correct/");
    }
    // double, char, String (Comparsion)
    // String -> methods





  }
  
}
