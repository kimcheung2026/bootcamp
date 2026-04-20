import java.util.ArrayList;

public class DemoArrayList {
  public static void main(String[] args) {
    String[] arr = new String[3];
    arr[0] = "abc";
    arr[1] = "def";
    arr[2] = "ijk";

    // What if i need one more space to store "qwe"
    String[] arr2 = new String[4];
    for (int i = 0; i < arr.length; i++) {
      arr2[i] = arr[i];
    }
    arr2[arr2.length - 1] = "qwe";
    arr = arr2;

    // Solution
    // ArrayList -> Fuctionality
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("abc");
    strings.add("def");
    System.out.println(strings.size()); // 4
    System.out.println(strings.contains("def")); // true(loop)
    strings.set(1, "leo");
    System.out.println(strings.getFirst());
    System.out.println(strings.isEmpty());

    // equals
    ArrayList<Integer> integers1 = new ArrayList<>();
    integers1.add(100);
    integers1.add(99);

    ArrayList<Integer> integers2 = new ArrayList<>();
    integers2.add(100);
    integers2.add(99);

    // ArrayList @Override equals
    System.out.println(integers1.equals(integers2)); // true
    System.out.println(integers1 == integers2); // false

    System.out.println(integers1.hashCode()); // 4160
    System.out.println(integers2.hashCode());

    ArrayList<String> languages = new ArrayList<>();
    languages.add("java");
    languages.add("python");

    strings.addAll(languages);
    System.out.println(strings);

    System.out.println(strings.get(3)); // java

    // Cat, Dog, Animal
    ArrayList<Cat> cats = new ArrayList<>();
    cats.add(new Cat("John"));
    cats.add(new Cat("Mary"));
    System.out.println(cats.size()); // 2

    // John
    System.out.println(cats.contains(new Cat("John"))); // ture

    System.out.println(cats.size()); // 2
    cats.remove(new Cat("John"));
    System.out.println(cats.size()); // 1

    ArrayList<Character> chs = new ArrayList<>();
    chs.add('a');
    chs.add('t');
    // for - loop (arry , algorithm)
    // for-each
    for (Character ch : chs) {
      System.out.println(ch);
    }
    for (Cat a : cats) {
      System.out.println(a.getName());
    }

    // !ArrayList -> Encapsulate Array
    // Arraylist vs Array
    // 1. Array is fixed length, ArrayList is dynamic length
    // 2. ArrayList & Array: get object by index
    // 4. Primitive (Array) Only, Class (ArrayList, Array)
  }
}