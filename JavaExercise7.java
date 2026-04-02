public class JavaExercise7 {
  // Sum values of an array
  public static void main(String[] args) {
    // Sum up all odd number between 0 - 50

    // System.out.println("The sum is " + sum);
    int odd = 50;
    int sum = 0;
    for ( int i = 0; i < odd; i++) {
      if ( i % 2 != 0) {
        sum = sum + i;
      }
    }
    System.out.println("The sum is " + sum);
  }
}

