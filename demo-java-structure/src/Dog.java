public class Dog {
  // attribute 本質 (memory)
  private String name;
  private Dog dog;

  public Dog(String name) {
    this.name = name;
  }

  public void setDog(Dog dog) {
    this.dog = dog;
  }

  public Dog getDog() {
    return this.dog;
  }

  public String getName() {
    return this.name;
  }

  // Person has age (age -> Person?) (p1.getAge())

  public static void main(String[] args) {
    Dog d1 = new Dog("John");
    d1.setDog(new Dog("Mary"));
    d1.getDog().setDog(new Dog("Peter"));

    // 2nd dog = ?
    System.out.println(d1.getDog().getName()); // Mary
    System.out.println(d1.getDog().getDog().getName()); // Peter
  }

}