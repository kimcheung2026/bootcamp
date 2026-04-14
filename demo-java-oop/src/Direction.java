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
    for (Direction d : Direction.values()){ //! 背
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
        // 測試方向邏輯
        Direction d1 = Direction.SOUTH;
        System.out.println("當前方向: " + d1.getDesc());
        System.out.println("相反方向: " + d1.opposite().getDesc());

        System.out.println("--- 陣列迴圈範例 ---");
        
        // 測試 for-each 範例
        int[] arr = {4, 9, -5};
        
        // 傳統 for 迴圈
        for (int i = 0; i < arr.length; i++) {
            System.out.println("傳統迴圈: " + arr[i]);
        }
        
        // 增強型 for-each 迴圈
        for (int x : arr) {
            System.out.println("For-each: " + x);
        }
    }
}