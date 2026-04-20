import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Shape {
  private Color color;

  // Empty Constructor
  public Shape() {
    
  }

  // All Args Constructor
  public Shape (Color color) {
    this.color = color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return this.color;
  }
  //! implicitly public
  abstract double area(); //---> must add back Override to child for prensentation

  public static void main(String[] args) {
    Shape s1 = new Circle(3.5);
    System.out.println(s1.area()); // parent call child method --> line 22 abstract
    //Dynamic Polymorphism
    Shape s2 = new Triangle(Color.BLACK,4,2 );
    System.out.println(s2.area()); // present different area belongs to child
    // for-each
    //Shape[] -> 2 Circle 1 Square
    // loop -> summ all area
    Shape[] Shapes = new Shape[]{new Triangle(Color.BLACK,4,3), new Circle(3.6,Color.BLACK), new Circle(4,Color.BLACK)};
    double totalArea = 0;
    for(Shape s : Shapes) {
      double currentArea= s.area();
      System.out.println("面積: " + currentArea);
      totalArea += currentArea;
      BigDecimal bd = new BigDecimal(Double.toString(totalArea));
      bd = bd.setScale(2, RoundingMode.HALF_UP);
      System.out.println(bd);
    }
    //! What is the difference / same between interface and parent class
    //1. interface has No attributes , No constructor, No concrete method
    //2.Parent Class and interface -> Polymorphism (Shape[])
    //3. Parent Class and interface -> static varible
    //4. Parent Class (Normal Class (new) / Abstract )
    //5. extends One Parent, implements Many interface

  }
}