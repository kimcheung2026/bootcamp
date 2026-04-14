//" Animal" is an abstract description of Cat/Dog
// Object()
//! APIE: Inheritance
// Animal is a Parant Class
public abstract class Animal {
  //! Common Attributes
  private String name;
  private int age;

  public Animal (String name, int age) {
    this.name = name;
    this.age = age;
  }
  public Animal () {

  }
   public int getAge() {
    return this.age;
  }
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public void setAge(int age) {
    this.age = age;
  }


}



