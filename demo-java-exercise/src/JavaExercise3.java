public class JavaExercise3 {
  public static void main(String[] args) {
    // Take a character and check whether it is:
    // 1. Vowel (a, e, i, o, u – both lowercase and uppercase)
    // 2. Consonant (anothor 21 letters)
    // 3. Not an alphabet
    char ch = 'A';
    String vowel = "aeiouAEIOU";
    if ( vowel.indexOf(ch) != -1) {
        System.out.println(" It is Vowel.");
        } else if (ch >= 65 && ch <= 91 || ch >= 97 && ch <= 123) {
        System.out.println(" It is Consonant.");
      } else {
      System.out.println(" It is not an alphabet.");
    }

    


    // Take salary and years of experience, then calculate and print bonus
    // Experience ≥ 10 years → 20% bonus
    // 5–9 years → 10% bonus
    // < 5 years → 5% bonus
    int exp = 12;
    int salary = 110_000;
    int bonusPerYear = 5;
    if (exp >= 10) {
      bonusPerYear += 15;
    } else if ( exp >=5 && exp < 10) {
      bonusPerYear += 5;
    }
    System.out.println("You have " + exp + " years of experience." );
    System.out.println("Your salary now is " +salary +" per year." );
    System.out.println("Your have bonus "+ salary  * bonusPerYear / 100);
    
      
  }
}

