import java.util.LinkedList;

public class DemoLinkedList {
  public static void main(String[] args) {
    LinkedList<String> strings = new LinkedList<>();
    strings.add("leo");
    strings.add("steven");
    strings.add("vincent");
    System.out.println(strings);
    System.out.println(strings.size());
    System.out.println(strings.contains("steven"));
    strings.remove(1);

    // Linkedlist VS Arraylist
    // ! (Arraylist remove ) clear element (may) resize the array (loop)
    // ! (Linkedlist remove) loop
    // ! (A Add)

    // create delete update search (4)
    // CRUD -> create read update delete
  }
}
