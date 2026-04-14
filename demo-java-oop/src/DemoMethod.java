public class DemoMethod {
  // ! static (non-OOP presentation)
  private static double pi = 3.14159;

  public static double getPI() {
    return DemoMethod.pi;
  }

  private static int daysPerYear = 365;
  private static int hoursPerDay = 24;
  public static int hoursPerYear() {
    return daysPerYear * hoursPerDay;
  }
  
  public static void main(String[] args) {
   // 1+3 -> 4
   System.out.println(DemoMethod.sum(1, 3)); // 4

   // sum2 (instance method)
   DemoMethod dm = new DemoMethod(); // create instance
   System.out.println(dm.sum2(1,3)); // 4
   // Dog d1 = new Dog()
   //d1.eat();
   System.out.println(DemoMethod.hoursPerYear());
  }


  // ! tool (not belongs to any object) (Static Method)
   public static int sum(int a, int b) {
    return a + b ;
   }

   // ! Method belongs to object (Instance Method)
   public int sum2(int x, int y) {
    return x + y;
   }

  
}
