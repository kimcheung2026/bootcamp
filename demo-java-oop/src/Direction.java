//! Immutable
public enum Direction {
  EAST(1, "East."),
  SOUTH(2, "South."),
  WEST(-1, "West."),
  NORTH(-2, "North.");

  //attribute
  private int value;
  private String desc;

  // Private Constructor
  private Direction(int value, String desc){
    this.value = value;
    this.desc = desc;
  }


  //Presentation
  public Direction opposite(){
    for (Direction d : Direction.values()){
      if(this.value * -1 == d.getValue()) {
        return d;
      }

    }
    return null;
  }



  // setter
  public int getValue() {
    return this.value;
  }

  public String getDesc() {
    return this.desc;
  }

  public static void main(String[] args) {
    Direction d1 = Direction.SOUTH;
    System.out.println(d1.getDesc());
  System.out.println(d1.opposite().getDesc());
  }

}
