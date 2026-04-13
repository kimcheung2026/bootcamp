import java.math.BigDecimal;

public class Circle {
    private double radius;

  // constructor
  // ! Empty Contructor
  public Circle() {

  }

  // ! All Arguments Contructor (with all attribute)
  public Circle(double radius) {
    this.radius = radius;
  }

  // get, set
  public double getRadius() {
    return this.radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  // area
  // Presentation
  public double area() {
    return BigDecimal.valueOf(this.radius) //
        .multiply(BigDecimal.valueOf(this.radius)) //
        .multiply(BigDecimal.valueOf(Math.PI)) //
        .doubleValue();
  }

  public static void main(String[] args) {
    // System.out.println(new Circle(3.5).area()); // 38.48451000647496

    Circle c1 = new Circle(); // default 0.0
    System.out.println(c1.area()); // 0.0
    c1.setRadius(7.5);
    System.out.println(c1.area()); // 176.71458676442586
  }
}
