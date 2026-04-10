public class car {

  private String color;
  private String brand;
  private int year;

  public void setColor(String color) {
    this.color = color;
  }
  public String getColor() {
    return this.color;
  }
public void setBrand(String brand) {
    this.brand = brand;
  }
  public String getBrand() {
    return this.brand;
  }
public void setYear(int year) {
    this.year = year;
  }
  public int getYear() {
    return this.year;

    public static void main (String[] args) {
      // 2 car objects
      // set and get
      Car c1 = new Car();
      c1.setBrand("tesla");
      c1.setColor("RED");
      c1.setYear(2023);
      System.out.println(c1.getColor());
    }








}


