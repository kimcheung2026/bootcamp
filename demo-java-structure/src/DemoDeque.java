import java.util.ArrayDeque;
import java.util.Deque;

public class DemoDeque {
  public static void main(String[] args) {
    Deque<String> dq = new ArrayDeque<>(); // LinkedList or ArrayDeque (how to do)
    // Queue vs Deque
    // 1. queue (add Last and poll first)
    // 2. Deque (add Last/ First and poll First/Last)
    dq.addLast("Leo");
    dq.addFirst("Peter");
    System.out.println(dq.pollLast()); // Leo
    dq.addLast("Ellen");
    dq.addFirst("Steve");
    System.out.println(dq.pollFirst());

    while (dq.size() >= 2) {
      System.out.println(dq.pollFirst());
      System.out.println(dq.pollLast());

    }
    // Queue: add + poll
    // Deque: add + poll or pop + push
    // ! Another use -> pop + push only
    dq.push("Kelly");
    dq.push("Oscar");
    dq.push("Jenny");
    System.out.println(dq.pop());
    System.out.println(dq.pop());
    System.out.println(dq.pop());
    // System.out.println(dq.pop()); Error
    dq.push("Kelly1");
    dq.push("Oscar1");
    dq.push("Jenny1");
    System.out.println(dq.poll()); // ! Wrong Presentation

  }
}
