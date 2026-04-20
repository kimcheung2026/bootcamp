public class Person1 implements Comparable<Person1> {
  private int age;

  public Person1(int age) {
    this.age = age;
  }

  public int getAge() {
    return this.age;
  }

  // ! Compare Two Person, return 1 Person
  // return int
  // -1 -> return this
  // 1-> return person
  @Override
  public int compareTo(Person1 person) {
    return this.age > person.getAge() ? -1 : 1;
  }

  @Override
  public String toString() {
    return "Person(" //
        + "age=" + this.age //
        + ")";
  }

}
