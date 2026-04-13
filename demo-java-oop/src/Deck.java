import java.util.ArrayList;
import java.util.Collections;

import javax.smartcardio.Card1;

public class Deck {
  //Step3 將Card1 陣列設定私有 --> line 22 
  private Card1[] cards;

  // constructor
  public Deck() { //Step 5 定義資料型態 & 定義資料 --> line11
    // 13 x 4
    
    this.cards = new Card1[13 * Suite.values().length]; // 0-51
    int idx = 0;
    for (int i = 1; i <= 13; i++) { //外层循环：点数 1 到 13
      for (Suite suite : Suite.values()) {//内层循环：依次遍历 4 种花色
         this.cards[idx] = new Card1(i, suite);// 生成資料
         idx++;
      }
    }
  }

  // Step 4 由於 Card1 設為只可提取, 故開放this.card路徑取資料 --> line8 
  public Card1[] getCards() {
    return this.cards;
  }
  // shuffle (random)

  // Class  -> 5 Cards -> boolean


  public static void main(String[] args) {
    //STEP1 創建d1櫃子 給 Card1 安放資料 --> line 34
    Deck d1 = new Deck();
    //STEP2 由於CARD1 超過 3個, 用陣列[] 儲存及 提取 d1 資料 --> line5
    Card1[] cards = d1.getCards();
    int cards5 = 5;
    // AI 提供 功能未清楚 待查
    ArrayList<Integer> list = new ArrayList<>();

    
    for (int j = 1; j <= 52; j++) {
        list.add(j);
        }

        // 随机打乱顺序
        Collections.shuffle(list);

        // 输出前6个不重复数字
      System.out.println("發5个張牌：");
      for (int j = 0; j < cards5 ; j++) {
      int randomCard = list.get(j);
      System.out.println(cards[randomCard].getRank() + " " + cards[randomCard].getSuite());
    }
  }
}
