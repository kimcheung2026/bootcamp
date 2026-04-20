import java.util.Comparator;

public class SortByAgeAsc implements Comparator<Person1> {
  // Compare p1 and p2
  // -1 -> return
  // 1 -> return p2
  @Override
  public int compare(Person1 p1, Person1 p2) {
    return p1.getAge() < p2.getAge() ? -1 : 1;

  }
}
