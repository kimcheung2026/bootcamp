public class DemoString {
  public static void main(String[] args) {
    System.out.println("hello");
    String s1 = "h";
    char c1 = 'h';

    s1 = c1 +"!!!";
    System.out.println(s1); // string is class - has methods
    System.out.println(s1.length()); //4 length return char
    String s2 ="hello";
    System.out.println(s2.charAt(2)); // charAt return char java index star with 0 
    System.out.println(s2.charAt(s2.length()-1));
    String s3 = "hello"; // equals()  return boolean
    System.out.println(s2.equals(s3));
    String s4 = "Hello";
    System.out.println(s2.equals(s4));
  }
}
