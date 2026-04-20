public class LinkedList1<T> {
  public static class Node<T> {
    private T element;
    private Node<T> next;

    public Node(T element) {
      this.element = element;
    }

    public T getElement() {
      return this.element;
    }
  }

  public LinkedList1() {

  }

  private Node<T> head;

  public boolean add(T element) {
    Node<T> newNode = new Node<>(element);
    if (head == null) {
      head = newNode;
    } else {
      Node<T> current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    Node<T> current = head;
    while (current != null) {
      sb.append(current.element);
      if (current.next != null)
        sb.append(", ");
      current = current.next;
    }
    return sb.append("]").toString();
  }

  public static void main(String[] args) {
    LinkedList1<String> names = new LinkedList1<>();
    names.add("Leo");
    names.add("Sally");
    System.out.println(names);
  }
}
