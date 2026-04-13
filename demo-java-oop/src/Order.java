import java.math.BigDecimal;

public class Order {
  // id
  private String address;
  private Item[] items;

  public Order() {
    this.items = new Item[0];
  }

  public Order(Item[] items) {
    this.items = items;
  }

  public Item[] getItems() {
    return this.items;
  }
  
  // ! Nice to have
  public void addItem(Item newItem) {
    Item[] newItems = new Item[this.items.length + 1];
    for (int i = 0; i < this.items.length; i++) {
      newItems[i] = this.items[i];
    }
    newItems[newItems.length - 1] = newItem;
    this.items = newItems;
  }

  // return type always keep primitive (Best Practice)
  public double totalAmount() { // APIE: Encapsulation
    // sum
    BigDecimal sum = BigDecimal.ZERO;
    for (int i = 0; i < this.items.length; i++) {
      Item item = this.items[i];
      double subTotal = item.subTotal();
      sum = sum.add(BigDecimal.valueOf(subTotal));
    }
    return sum.doubleValue();
  }

  // ! One-to-Many -> Array -> Encapsulation ()
  public static void main(String[] args) {
    

    Customer c1 = new Customer();




    Order order2 = new Order();

    c1.addOrder(order2);

    System.out.println(c1.totalOrderAmount()); // 88.97
    System.out.println(c1.isVip());
  }
}