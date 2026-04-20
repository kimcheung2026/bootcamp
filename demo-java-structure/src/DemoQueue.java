import java.util.LinkedList;
import java.util.Queue;

public class DemoQueue {
  public static void main(String[] args) {
    Queue<String> queue = new LinkedList<>();
    queue.add("Leo");
    queue.add("Tommy");
    queue.add("Alex");

    System.out.println(queue.peek());

    // ! Queue --> must while loop --> retieve data
    System.out.println(queue.size());
    while (!queue.isEmpty()) {
      String head = queue.poll();
      System.out.println(head); // remove head
    }
    System.out.println(queue.size());

  }
}
