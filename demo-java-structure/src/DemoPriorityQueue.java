import java.util.PriorityQueue;

public class DemoPriorityQueue {
  public static void main(String[] args) {
    // formula (age >= 70) -> Sorting
    PriorityQueue<Person1> persons = new PriorityQueue<>();

    // Sorting -> whan happen? add() or poll()
    // ! poll is slow when sorting out
    persons.add(new Person1(50));
    persons.add(new Person1(25));
    persons.add(new Person1(15));
    persons.add(new Person1(30));

    System.out.println(persons.poll().getAge());
    persons.add(new Person1(70));
    System.out.println(persons.poll().getAge());
    persons.add(new Person1(65));

    // ! Comparator
    PriorityQueue<Person1> dq2 = new PriorityQueue<>(new SortByAgeDesc());
    dq2.add(new Person1(70));
    dq2.add(new Person1(90));
    dq2.add(new Person1(30));
    dq2.add(new Person1(80));
    System.out.println(dq2.poll().getAge()); // 90
    System.out.println(dq2.poll().getAge()); // 80
    System.out.println(dq2.poll().getAge()); // 70
    System.out.println(dq2.poll().getAge()); // 30

  }
}
