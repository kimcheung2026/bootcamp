import java.math.BigDecimal;

public class Order {
  //id
  private Item[] items;
  private String address;

  public Order() {

  }
  public Order(Item[] items) {

  }
  // return type always keep primitive (Best Practice)
  public double totalAmount() {
    // sum
    BigDecimal sum = BigDecimal.ZERO;
    for (int i =0; i < this.items.length; i++) {
      Item item = items[i];
      double subTotal = item.subTotal();
      sum = sum.add(BigDecimal.valueOf(subTotal))//
        ;
      
      
      return sum.doubleValue();
    }
  }
}
