public class Item {
  // id
  private String name;
  private double price;
  private int quantity;

  public Item() {

  }

  public Item(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public double subTotal() {
    return this.price * this.quantity;
  }

  // get set
  public String getName() {
    return this.name;
  }

  public double getPrice() {
    return this.price;
  }

  public int getQuantity() {
    return this.quantity;
  }
  
}