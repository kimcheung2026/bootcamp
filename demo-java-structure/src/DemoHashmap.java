import java.util.ArrayList;
import java.util.HashMap;

public class DemoHashmap {
  public static void main(String[] args) {
    HashMap<String, String> hashMap = new HashMap<>();
    // key + value
    hashMap.put("AAPL", "apple");
    hashMap.put("TSLA", "tesla");

    HashMap<String, Cat> hashMap2 = new HashMap<>();
    hashMap2.put("ABC", new Cat("Jason"));
    hashMap2.put("DEF", new Cat("Mandy"));

    // ! get by KEY (hash -> search , much better than loop)
    System.out.println(hashMap.get("TSLA")); // tesla
    Cat cat = hashMap2.get("DEF");
    System.out.println(cat.getName());

    hashMap.put("tsla", "NVIDA"); // Case Senitive
    System.out.println(hashMap.size()); // 3
    hashMap.put("abc", null);
    System.out.println(hashMap.get("abc")); // null

    System.out.println(hashMap2.get("ABC").getName()); // Jason

    HashMap<String, ArrayList<String> hashMap3 = new HashMap<>(); 
    hashMap.put("UFO", new ArrayList<String> (UFO.add("HI")));
  }
}
