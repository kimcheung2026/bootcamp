import java.math.BigDecimal;
import java.time.LocalDate;

public class Customer {
  // id
  private String firstName;
  private String lastName;
  private char gender; // 'M', 'F'
  private LocalDate dob;
  private Order[] orders; // ! Array (Custom Class)

  // isVip(), total amount for all orders > 100,000
  // true/ false

  // constructor (建構者) -> produce object
  // ! implicitly empty constructor
  public Customer() {
    System.out.println("Creating Customer...");
    // ! advanced
    this.orders = new Order[0];
  }

  public Customer(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Customer(Order[] orders) {
    this.orders = orders;
  }

  public void addOrder(Order newOrder) {
    Order[] newOrders = new Order[this.orders.length + 1];
    // loop original array
    for (int i = 0; i < this.orders.length; i++) {
      newOrders[i] = this.orders[i];
    }
    newOrders[newOrders.length - 1] = newOrder;
    this.orders = newOrders;
  }

  public boolean isVip() {
    return this.totalOrderAmount() > 100_000;
  }

  public double totalOrderAmount() {
    BigDecimal sum = BigDecimal.ZERO;
    for (int i = 0; i < this.orders.length; i++) {
      sum = sum.add(BigDecimal.valueOf(this.orders[i].totalAmount()));
    }
    return sum.doubleValue();
  }



  // ! More than One Constructor
  // Provide 4 values
  public Customer(String firstName, String lastName, char gender,
      LocalDate dob) {
    // creating..
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.dob = dob;
  }

  // Methods:
  // BirthYear -> return int
  public int getBirthYear() {
    return this.dob.getYear();
  }

  public LocalDate getDob() {
    return this.dob;
  }

  // get set

  public String getFirstName() {
    return this.firstName;
  }

  public Order[] getOrders() {
    return this.orders;
  }

  public static void main(String[] args) {
    // "new" -> produce object (call constructor)
    //
    Customer c1 = new Customer();
    Customer c2 = new Customer("John", "Chan", 'M', LocalDate.of(1990, 1, 1));
    Customer c3 = new Customer("Leo", "Lau");
    System.out.println(c2.getFirstName()); // John

    System.out.println(c1.getFirstName()); // null

    System.out.println(c2.getBirthYear()); // 1990
    System.out.println(c2.getDob().getYear()); // 1990


    Customer c4 = new Customer();
    Order o1 = new Order();

    // 2 orders
    // order 1: 2 items
    // order 2: 1 item
    Item rice = new Item("rice", 99.5, 2);
    Item water = new Item("water", 5, 10);
    Item fish = new Item("fish", 50, 4);
    System.out.println(fish.subTotal()); // 200.0

    Item[] items = new Item[2];
    items[0] = rice;
    items[1] = water;

    Item[] items2 = new Item[1];
    items2[0] = fish;

    Order o10 = new Order(items);
    Order o11 = new Order(items2);
    System.out.println(o10.totalAmount()); // 249.0

    Order[] orders = new Order[2];
    orders[0] = o10;
    orders[1] = o11;

    Customer c10 = new Customer(orders);
    System.out.println(c10.totalOrderAmount()); // 449.0
    System.out.println(c10.isVip()); // false

    // c10.addOrder(o10)

    // c4.isVip -> true
    System.out.println(orders[1].getItems()[0].subTotal()); // 200.0

    System.out.println(c10.getOrders()[0].getItems()[1].subTotal()); // 50
  }

}