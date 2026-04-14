import java.math.BigDecimal;
import java.math.RoundingMode;

// Java 1-21 (super first)
// Java 23-25
// super? this?
public class Circle extends Shape {
  private double radius;

  // Child Class
  // ! Inherit Attributes & Instance Methods
  // ! Won't inherit constructors

  // public Circle() {
    //  implicitly calling parent's empty constructor
  // }

  // ! Every Child Class Constructor would call parent's constructor
  public Circle(double radius) {
    // super(Color.BLACK); // calling Shape All Args Constructor
    super(); // calling Shape Empty Constructor
    this.radius = radius;
  }
  
  // RED Circle
  public Circle(double radius, Color color) {
    super(color);
    this.radius = radius;
  }

  public double getRadius() {
    return this.radius;
  }



  // area
  @Override
  public double area() {
   return BigDecimal.valueOf(this.radius) //
        .multiply(BigDecimal.valueOf(this.radius)) //
        .multiply(BigDecimal.valueOf(Math.PI)) //
        .setScale(2, RoundingMode.HALF_UP) // 設定小數點後 2 位，並四捨五入
        .doubleValue();
  }

  public static void main(String[] args) {
    Circle c1 = new Circle(3.5, Color.BLACK);
    System.out.println(c1.getColor()); // RED
    System.out.println(c1.getRadius()); // 3.5
    System.out.println(c1.area());
  }
}