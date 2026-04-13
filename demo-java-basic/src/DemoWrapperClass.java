public class DemoWrapperClass {
  public static void main (String[] args) {
    // Primitives (byte, short, int, long, float, double, char, boolean)
    // Wrapper Class
    byte b1 = 100; // Primitive
    Byte b2 = 100; // Class

    short s1 = 100;
    Short s2 = 100;

    int x1 = 100;
    // ! Always use method for comparsion
    Integer x2 = 100;
    if (x2.compareTo(100) > 0 ) { // check if x2 is larger than 100
    System.out.println(x2);}
    if (x2.compareTo(100) < 0 ) { // check if x2 is larger than 100
    System.out.println(x2);}
    if (x2.equals(100) ) { // check if x2 is larger than 100
    System.out.println(x2);}


    long l1 = 100;
    Long l2 = 100L;

    float f1 = 9.0f;
    Float f2 = 9.0f;

    double d1 = 100.99;
    Double d2 = 100.99;

    char ch1 = 'c';
    Character ch2 = 'c';
    if (ch2.equals('c')) {
      System.out.println("equals");
    }
    if (!ch2.equals('c')) {
      System.out.println("not equals");
    }

    boolean o1 = true;
    Boolean o2 = true;
    // equal and Not equals

    //Internal Cache
    Integer k1 = 127;
    Integer k2 = 127;
    System.out.println(k1.equals(k2)); //true
    System.out.println(k1 == k2); //true

    Integer k3 = 128; //create a new object
    Integer k4 = 128; // create a new object
    System.out.println(k3.equals(k4)); //true
    System.out.println(k3 == k4);  // false

    Integer k5 = -128;
    Integer k6 = -128;
    System.out.println(k5.equals(k6)); //true
    System.out.println(k5 == k6);  // true
    //! -128 to 127 (Java Define a range of common use number)

    //Integer (Class/Object) -> comparsion -> compareTo equals
    // ! implicit Promotion (Primtives)
    float f10= 1000L;
    double d10 = 10.9f;
    float f12 =19;
    byte b10 =127;
    double d11 = b10;
    int x10 = 'a';
    double d12 = 'a';

    // int x11 = d12; // ! risky  downcasting  int -> 

    //! Wrapper Class vs Primtives (auto-box / un-box)
    //! auto-box (long -> Long)
    Long l30 = 100L; // long -> Long
    Integer i30 = 100; // int -> Integer
    Character ch30 = 'x';
    
    //! un-box (Long ->long)
    long l31 = l30;
    int i31 = i30;
    char ch31 = ch30;

    // long l20 = 100; // int -> long
    //! Java would Not ayto convert "implicit promotion" and "auto-box" at the same time
    // Long l21 = 100; // int -> long 
  
  
  
  } 


}
