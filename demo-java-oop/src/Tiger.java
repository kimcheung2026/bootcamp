public class Tiger {
  private Color color;



  // Constructor
  public Tiger() {}

  public Tiger(Color color) {
    this.color = color;
  }


  //get set
  public Color getColor() {
    return this.color;
  }

   public void setColor(Color color) {
        this.color = color;
   }


  public static void main(String[] args) {
    Tiger t1 = new Tiger();
    t1.setColor(Color.YELLOW);
    Tiger t2 = new Tiger(Color.RED);
    Tiger t3 = new Tiger();
    System.out.println(t1.getColor());
  }
}
