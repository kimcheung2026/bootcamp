public class DemoString {
  public static void main(String[] args) {
    System.out.println("hello");
    String s1 = "h";
    char c1 = 'h';

    s1 = c1 +"!!!";
    System.out.println(s1); // string is class - has methods
    System.out.println(s1.length()); //1. length return char 
    String s2 ="hello";
    System.out.println(s2.charAt(2)); //2. charAt return char java index star with 0 
    System.out.println(s2.charAt(s2.length()-1));
    String s3 = "hello"; // 3. equals()  return boolean  
    System.out.println(s2.equals(s3));
    String s4 = "Hello";
    System.out.println(s2.equals(s4));


    // 4. isEmpty()
    String s5 = ""; 
    System.out.println(s5.isEmpty());
    System.out.println(s4.isEmpty());

    // 5. isBlank()
    String s6 = " ";
    System.out.println(s6.isEmpty()); // false
    System.out.println(s6.isBlank()); // true

    // 6. toLowerCase/ toUpperCase
    String lowercase = s4.toLowerCase();
    String uppercase = s4.toUpperCase();
    System.out.println(s4);
    System.out.println(lowercase);
    System.out.println(uppercase);

    // 7. contains() (case-sensitive) 大 小 useful
    if (s4.contains("ll")) {
      System.out.println("contains ll");
    }
    if (s4.contains("LLL")) {
        System.out.println("contains LLL");
      } else {
        System.out.println("Does not contain LLL ");
    }

    // 8. starts with / ends with
    if (s4.startsWith("he")) {
      System.out.println("Starts with He");
    }
    if (s4.endsWith("llo")) {
      System.out.println("End with llo");
    }

    //9. replace --> return String
    String s10 = "Bootcamp";
    String s11 = s10.replace( 'o', 'x');
    System.out.println(s11); // bxxtcamp

    String s12 = s10.replace("camp", "");
    System.out.println(s12); //boot

    //10. substring(startIndex, endIndex)
    String s13="hello";
    String ss = s13.substring(2,4);  // endindex 4-1
    System.out.println(ss);

    System.out.println(s13.substring(1)); //ello

    //11. indexOf -> return index      useful
    String s14 = "bootcamp";
    System.out.println(s14.indexOf('o')); //1
    System.out.println(s14.indexOf("camp"));//4
    System.out.println(s14.indexOf("java")); // -1
    System.out.println(s14.indexOf(97)); //5

    //12. lastIndexOf
    System.out.println(s14.lastIndexOf('o')); //2
    System.out.println(s14.lastIndexOf("oo"));

    //13. trim
    String s15 = "       hello world    ";
    String afterTrim = s15.trim();
    System.out.println(afterTrim); //hello world
    System.out.println(s15.replace(" ", "")); //helloword

    // 14. concat
    String s16 = "hello";
    String s17 = "world";
    // String + String = String
    System.out.println(s16 + s17); // helloword

    String combineString = s16.concat(s17);
    System.out.println(combineString); // helloworld;

    //15. compareTo
    String s18 = "abc";
    String s19 ="defg";
    System.out.println(s18.compareTo(s19)); //-3;
    if (s18.compareTo(s19)>0) {
      System.out.println("s18 ASCII > s19 ASCII");
    } else {
      System.out.println("s19 ASCII > s18 ASCII");
    }



    //16. equalsIgnoreCase()
    String s20 = "JOHN LAU";
    String s21 = "john lau";
    System.out.println(s20.equalsIgnoreCase(s21));



  }
}
