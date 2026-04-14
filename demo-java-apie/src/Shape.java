
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
    Shape s2 = new Triangle(4,2);
    System.out.println(s2.area()); // present different area belongs to child


  }
}