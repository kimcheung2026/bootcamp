import java.util.List;

public class DemoIf {
  public static void main(String[] args) {
    int age = 13; // > . < . >= . <=
    if (age >= 18) {
      System.out.println("Adult");
    } else {
      System.out.println("Child");
    }
    // 8 Primitives + String
    // boolean
    // = (assignment)
    // == (check if equals)
    age = 80;
    boolean isElderly = age >65 ;
    if (isElderly) {
      System.out.println("Fee=2");
    }
    // && ||
    int a =21;
    if (a >= 5 && a <= 20) {
      System.out.println("a is between 5 and 20. ");
    }
    int b = 10;
    if(a > 20 || b > 12) {
      System.out.println("hello");
    } else {
      System.out.println("goodbye");
    }
    // Event 1: a > 15
    // Event 
    if ( a > 20 || b > 6 && b < 20) {
      System.out.println("Correct/");
    }
    // double, char, String (Comparsion)
    // String -> methods
    // Swap
    int x= 9;
    int y = 5;
    int temp =x;
    x = y;
    y = temp;
    System.out.println(x);
    System.out.println(y);

    //
    int j = 10;
    int k = 5;
    //10
    if (j > k) {
      System.out.println(j);
    } else {
      System.out.println(k);
    }
    // another  Find Max between 2 numbers
    int max = j;
    if (j > k ) {
      max = j;
    } else {max = k;
    }
    System.out.println(max);

    // Find min between 3 numbers
    int q= 4;
    int u = 3;
    int t = 0;
    int min = q;
    if ( q < u && q < t ) {
      min = q ;
    } else if( u < q && u < t) {
        min = u ;
      } else {
          min = t;
      }
      System.out.println(min);
      

      //double, char, String (comparsion
      // String --> methods
      int score = 78;
     // >= 90 Grade A)
     // >= 80 and < 90 Grade B
     // >= 70 and < 80 Grade C
     char grade = 'F';
     if (score >= 90 ) {
      grade = 'A';
     } else if (score >= 80) {
      grade = 'B';
     } else if (score >= 70) {
      grade = 'C';
     }
     if (grade == 'A' || grade == 'B') {
      System.out.println("Excellent.");
     } else if (grade == 'C') {
      System.out.println("Pass.");
     }

     String s1= "Java";
     // check if s1 starts with J or S1 length>5 -> print hello
     // otherwise -> print byebye
     if (s1.charAt(0) == 'J' || s1.length() > 5) {
      System.out.println("hello");
     } else {
      System.out.println("byebye");
     }

     // Switch
     // 1. (no) and OR
     // 2. (no) Range checking
     // 3. must type break
     char gender = 'K';
     switch (gender) {
      case 'M':
        System.out.println("he is a male.");
        break;
      case 'F':
        System.out.println("She is a female.");
        break;
      default:
        System.out.println("Invalid Gender.");

        // year
        int year = 2024;
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0){
          System.out.println("It is a leap year.");
        } else {System.out.println("It is not a leap year.");
        }

        boolean isLeapYear = false;
        if (year % 4 == 0) {
          if (year % 100 == 0) {
            if (year % 400 == 0) {
            isLeapYear = true;
            } else {
            isLeapYear = false;
            }
          } else {
          isLeapYear = true;
          }
        } else {
        isLeapYear = false;
        }
        if (isLeapYear) {
        System.out.println("it is a leap year.");
        } else {
        System.out.println("it is not a leap year.");
        }


     }
  }
}