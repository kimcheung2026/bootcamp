import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle extends Shape {
  private double length;
  private double height;

  public Triangle(){
    super();
    
  }
  public Triangle(Color color, double length, double height) { // this structure with parent Color  for presentation
    super(color);
    this.length = length;
    this.height = height;

  }


  public Triangle(double length, double height) { // this structure only for length height without parent Color
    this.length = length;
    this.height = height;
  }
  
  public double getLength() {
    return this.length;
  }

  public double getHeight() {
    return this.height;
  }
  
  public void setLength(double length) {
    this.length = length;
  }
  
  public void setHeight(double height) {
    this.height = height;
  }
  @Override
  public double area() {
    return BigDecimal.valueOf(this.length)//
    .multiply(BigDecimal.valueOf(this.height))//
    .divide(BigDecimal.valueOf(2)).setScale(2, RoundingMode.HALF_UP).doubleValue();
  }





  public static void main(String[] args){
  Triangle t1 = new Triangle();
  t1.setColor(Color.RED);
  t1.setHeight(4);
  t1.setLength(2);
  // Triangle t2 = new Triangle(3,5,Color.BLACK); WE didn't SET length height color in constructor for present
  Triangle t2 = new Triangle(Color.BLACK, 3, 5);  // we set new structure that (color length height)
  System.out.println(t1.area());
  System.out.println(t2.area());
  }



}
