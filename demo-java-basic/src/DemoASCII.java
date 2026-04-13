 public class DemoASCII {
  public static void main(String[] args) {
    char c1 = 'a';
    int asciiValue = c1; //auto conversion  (promotion)
    System.out.println(asciiValue);
    int asciiValue1 = 'c';
    System.out.println(asciiValue1);
    int ascii4 = '好';
    System.out.println(ascii4);
    int ascii5 = '栄';
    System.out.println(ascii5);
    int ascii6 = '榮';  
    System.out.println(ascii6);
    // int ascii6 = 97; char c3 = ascii6; risk
    char c3 = 62000;
    System.out.println(c3);
    char c4 = 27054;
    System.out.println(c4);
    // byte + byte --> int + int

    float f2 = 999.99f;
    double d2 = f2;
    System.out.println(f2);
    

  }
  
}
