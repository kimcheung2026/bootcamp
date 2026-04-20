import java.util.LinkedList;
import java.util.List;

public class DemoException { // 重要 Interview topic
  public static void main(String[] args) {
    String s = "Hello";
    System.out.println(s.charAt(0)); // h

    s = null;
    // System.out.println(s.charAt(1)); // java.lang.NullPointerException

    if (s != null) {
      System.out.println(s.charAt(0));
    } else {
      System.out.println("s is null");
    }

    String[] arr = new String[3];
    // System.out.println(arr[-1]); java.lang.ArrayIndexOutOfBoundsException
    // System.out.println(arr[3]); java.lang.ArrayIndexOutOfBoundsException

    List<String> names = new LinkedList<>();
    names.add("Peter");
    names.add("Jason");
    // System.out.println(names.get(2)); java.lang.IndexOutOfBoundsException

    // Math (divide 0)
    int count = 0;
    // double average = 999 / count; java.lang.ArithmeticException

    double d1 = Double.valueOf("23.4");
    System.out.println(d1);

    // double d2 = Double.valueOf("23.4a");
    // System.out.println(d2); java.lang.NumberFormatException

    String s4 = "10hello";
    // check if s4 is a number -> true / false
    // Learn: try-catch
    boolean isNumber = false;
    try {
      double d10 = Double.valueOf(s4); // if not number, throw NumberFormatException
      isNumber = true;
    } catch (NumberFormatException e) {
      isNumber = false;
    }
    System.out.println("s4 is number:" + isNumber);

    // ! Unchecked Exception (Runtime Exception)
    // ! Checked Exception (Complite time Exception)
  }
}
