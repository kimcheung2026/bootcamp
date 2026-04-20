public class Box<T> {
  private T x;

  public Box(T x) {
    this.x = x;
  }

  public T getX() {
    return this.x;
  }

  public void setX(T x) {
    this.x = x;
  }

  // ! Generic
  // Less Class (Box<T>) to achieve same purpose (IntegerBox)
  // Runtime -> Definr Generic Type (Strong Type)

  public static void main(String[] args) {
    Box<String> stringBox = new Box<>("hello");
    Box<Integer> integerBox = new Box<>(10);
    Box<Cat> catBox = new Box<>(new Cat("John"));
  }

}
