public class Card1 {
  private int rank; // 1,2,3,4,5,6,7,8,10,J,Q,K (1-13) (0-12)
  private Suite suite; // DIAMOND, CLUB, HEART, SPADE
  

  // constructor
  public Card1(int rank, Suite suite) {
    this.rank = rank;
    this.suite = suite;
  }

  // get set
  public int getRank() {
    return this.rank;
  }

  public Suite getSuite() {
    return this.suite;
  }

  public static void main(String[] args) {
    Card1 c2 = new Card1(2, Suite.DIA);
    System.out.println(c2.getRank());
    System.out.println(c2.getSuite());
  }
}