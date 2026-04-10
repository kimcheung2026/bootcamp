import java.math.BigDecimal;
import java.time.LocalDate;

public class Customer {
  // id
  private String firstName;
  private String lastName;
  private char gender; //'M' 'F'
  private LocalDate dob;
  private Order[] orders; //! Array (Custom Class)
  
  // isVip(), total amount for all orders >100,000
  //true / false

  public boolean isVip() {
    return this.totalOrderAmount() > 100_000;
  }

  public double totalOrderAmount() {
    BigDecimal sum = BigDecimal.ZERO;
    for ( int i = 0; i < this.orders.length; I++) {
      sum = sum.add(BigDecimal.valueOf(this.orders[i].totalAmount()))
    }
    return sum.doubleValue();
  }

  //constructor
  //! implicitly empty constructor
  public Customer() {
    System.out.println("Creating Customer...");
  }
  // More than one Constructor
  public Customer(String firstName, String lastName, char gender,
      LocalDate dob) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.gender = gender;
      this.dob = dob;
      }
    

    public Customer(LocalDate dob) {
      this.dob = dob;
    }
  
  //get set

  public String getFirstName() {
    return this.firstName;
  }
  public int getBirthYear() {
    return this.dob.getYear();
  }

  public LocalDate getDob() {
    return this.dob;
  }
  


  public static void main(String[] args) {
// "new" -> produce object (call constructor)
//
    Customer c1 = new Customer();
    Customer c2 = new Customer();
    Customer c3 = new Customer(LocalDate.of(1985, 11, 02));

    System.out.println(c3.getBirthYear());
    System.out.println(c3.getDob().getYear());

    Customer c4 = new Customer();
    // 2 orders
    // order 1: 2 items
    // order 2: 1 item
    // c4.isVip -> true
    
  }
  
}
