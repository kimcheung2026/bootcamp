public class JavaExercise6 {
  // Sum values of an array
  public static void main(String[] args) {
     // Print the numbers fulfill the below criteria:
    // 1. Even numbers
    // 2. Divisible by 3
    // 3. First ten numbers
    String st1 = "";
    String st2 = "";
    String st3 = "";
    int count = 10;
    int count1 = 0;
    for (int i = 0; i < 100; i++) {
      // code here ...
      if ( i % 2 != 1) {
        st1 += i + " ";
        count--;
        if (count >= 0) {
          st3 += i + " ";
        }
      } else if ( i % 3 != 1) {
        st2 += i + " ";
        count--;
        if (count >= 0) {
        st3 += i + " ";
        }
      } 
      count1++;
    }   
    System.out.println("1.Even number within "+ count1 + " are " + st1);
    System.out.println(st2);
    System.out.println(st3);
  }
}
  
