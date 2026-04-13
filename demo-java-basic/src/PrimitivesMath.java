public class PrimitivesMath {
  public static void main(String[] args) {
    int count =3;
    int price =10;

    int total = count * price;
    System.out.println(total); 

    int totalScore =750;
    int peopleCount = 8;
    int average = totalScore / peopleCount;
    System.out.println(average);

    byte b1 = -128;
    System.out.println(b1-1); //byte - int = int
    b1=(byte)(b1-3); 
    System.out.println(b1); //125 

    int amount = 2_100_000_000;

    amount = amount + 100_000_000; //overflow
    System.out.println(amount);
    amount = 2_100_000_000;
    long L2 = amount + 100_000_000L;
    System.out.println(L2);

    double k2 = 0.1;
    double k3 = 0.2;
    System.out.println(k2+k3); // no double + double

    byte b4 = 60;
    byte b2 = 70;
    // code here with tips, pls fix ...
    // sum = b1 + b2;
    int sum = b4 + b2;
    System.out.println("The another sum reuslt is " + sum);


  }
}