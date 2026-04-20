import java.util.HashSet;

public class DemoHashSet {
  public static void main(String[] args) {
    HashSet<String> strings = new HashSet<>();
    strings.add("Sally");
    strings.add("Leo");
    strings.add("Jason");
    strings.add("Alex");
    System.out.println(strings);
    strings.add("Jason");
    System.out.println(strings);
    System.out.println(strings.contains("Alex")); // true

    // equals
    HashSet<Cat> cats = new HashSet<>();
    cats.add(new Cat("John"));
    cats.add(new Cat("KING"));
    cats.add(new Cat("John"));
    cats.add(new Cat("king"));
    System.out.println(cats);

    // HashSet cannot remove by index

    // ! ArrayList vs HashSet
    // 1.Hash has No ordering
    // 2. Avoid Duplicated
    // 3. Has
  }
}
