public class Dog extends Animal {
  private double weight;
  
  public Dog() {
     
  }
  //name
  //age
  public double getWeight() {
    return this.weight;
  }
  public void setWeight(double weight){
    this.weight = weight;
  }
  
  public static void main(String[] args) {
    Dog d1 = new Dog();
    d1.setAge(5);
    d1.setName("John");
    d1.setWeight(8.5);
    
    System.out.println(d1.getAge());
    System.out.println(d1.getName());
    System.out.println(d1.getWeight());
    }
  }
