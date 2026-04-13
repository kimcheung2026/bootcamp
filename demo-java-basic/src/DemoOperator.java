public class DemoOperator {
  public static void main(String[] args) {
    int remainder = 5%2;
    System.out.println(remainder);
    System.out.println(5%6);
    int a = 10; // += -= *= /=
    a = a + 1;
    a += 1;
    a++;
    ++a;
    System.out.println(a);
    int b = 2; //
    b *=2;
    System.out.println(b);

    int c = 10;
    c = c +2;
    c +=2;
    double hourRate = 40.5; // int long  double
    int hoursPerDay = 7; //Naming Convension : Caml Case  no space
    double todaySalary = hourRate * hoursPerDay;
    System.out.println(todaySalary);
    int g = 10;
    int k = g++ *2;
    System.out.println(k);
    System.out.println(g);

  }
}