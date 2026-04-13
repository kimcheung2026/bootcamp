// Circle (radius)

// Class
public class Person {
  // Attributes
  private String name;
  private double height; // m
  private double weight; // kg

  public Person() {

  }

  // Creating Object ....
  public Person(String name, double height, double weight) {
    this.name = name;
    this.height = height;
    this.weight = weight;
  }

  public boolean isOverWeight() {
    if (this.weight > 100) {
      // System.out.println("weight > 100");
      return true; // presentation
    }
    // base case
    return false;
  }

  public String bmiGroup() {
    double bmi = this.bmi();
    if (bmi > 25) {
      return "Overweight";
    } else if (bmi < 18.5) {
      return "Underweight";
    }
    return "Normal";
  }

  // Metohd -> Presentation (APIE: Encapsulation)
  public String getInfo() {
    return this.name + " " + this.height + " " + this.weight;
  }

  // Metohd -> Presentation (APIE: Encapsulation)
  // bmi -> weight / height^2
  public double bmi() {
    return this.weight / (this.height * this.height);
  }

  // Instance Method (Object Method)
  public String getName() {
    return this.name;
  }

  // Instance Method (Object Method)
  public double getHeight() {
    return this.height;
  }

  // Instance Method (Object Method)
  public double getWeight() {
    return this.weight;
  }

  // Instance Method (Object Method)
  // void -> return nothing
  public void setName(String name) {
    this.name = name;
  }

  // Instance Method (Object Method)
  public void setHeight(double height) {
    this.height = height;
  }

  // Instance Method (Object Method)
  public void setWeight(double weight) {
    this.weight = weight;
  }

  // Runtime
  // JVM execute main method
  public static void main(String[] args) {
    Person p1 = new Person();
    Person p2 = new Person();
    p1.setName("John");
    p1.setHeight(1.76);
    p1.setWeight(75);
    System.out
        .println(p1.getName() + " " + p1.getHeight() + " " + p1.getWeight());
    System.out.println(p1.getInfo());

    System.out.println(p1.bmi()); // 24.212293388429753

    System.out.println(p1.isOverWeight()); // true/false

    if (p1.isOverWeight()) {

    }

    p2.setName("Jason");

    //Car c1 = new Car();
    // c1.setHeight(1.76);

    // Memory
    int x = 3;
    System.out.println(x);

    // Database
    // insert into database (3)
    // select 3
  }
}