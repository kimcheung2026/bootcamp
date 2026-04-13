public class DemoEnum {
  public static void main(String[] args) {
    String color = "RED";
    char color1 = 'R';

    if (color.equals("Red")) { // case sensitive

    } else {

    }

    // Java Object -> Not being referenced -> auto GC

    // Color.RED -> RED Object
    Color red = Color.RED;
  }
}