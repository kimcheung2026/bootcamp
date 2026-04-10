public class DemoStringII {
  public static void main(String[] args){
    // ! "hello" -> JVM create object in String pool
    String s1 = "hello";
    String s2 = "hello";
    // ! new -> produce Object (Force)
    String s3 = new String("hello");
    String s4 = new String("hello");

    //! Don't use "==" FOR Comparsion forever
    //! For class object (Non Primitive) always use equals for comparsion
    //! "==" check if they are in same address (same object)
    System.out.println(s1 == s2); //true 
    System.out.println(s4 == s3); // false
    System.out.println(s2 == s3); //false

    //! equals -> check if they are with same String value
    if (s1.equals(s4)) { //true
      System.out.println(s4);
    }

    //! ALL Primitives still use == for comparsion
  }
}
